package com.zhiyou.redis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

public class RedisCache implements Cache{

	//定义一个id
	private final String id;
	//通过构造方法给id赋值
	
	//创建读写锁对象
	private final ReadWriteLock rwl = new ReentrantReadWriteLock();
	//创建连接的工厂
	private static JedisConnectionFactory jedisConnectionFactory;
	
	//为类注入JedisConnectionFactory
	public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory){
		RedisCache.jedisConnectionFactory=jedisConnectionFactory;
	}
	
	public RedisCache(String id){
		this.id=id;
	}
	//这个id实际上就是缓存的key
	public String getId() {
		
		return id;
	}

	//将数据写入到缓存中(redis)
	public void putObject(Object key, Object value) {
		rwl.writeLock().lock();//写数据的时候加入锁,防止自己写的时别人也在写
		//获取到redis连接
		RedisConnection redis = jedisConnectionFactory.getConnection();
		//用于序列化数据(key,valus)
		RedisSerializer<Object> ser = new JdkSerializationRedisSerializer();
		//将key与value序列化后存入到redis中
		redis.set(ser.serialize(key), ser.serialize(value));
		redis.close();
		rwl.writeLock().unlock();//写入完成后,放开写锁
	}

	//从缓存中取出数据
	public Object getObject(Object key) {
		rwl.readLock().lock();//读锁
		//获取到redis连接
		RedisConnection redis = jedisConnectionFactory.getConnection();
		//用于序列化数据
		RedisSerializer<Object> ser = new JdkSerializationRedisSerializer();
		//根据序列化后的key从redis中取值,然后再将redis取出的数据进行反序列化
		Object object=ser.deserialize(redis.get(ser.serialize(key)));
		redis.close();
		rwl.readLock().lock();//写入完成后,放开读锁
		return object;//将redis中取出的数据返回
	}

	//从缓存中删除数据
	public Object removeObject(Object key) {
		rwl.writeLock().lock();//写数据的时候加入锁,防止自己写的时别人也在写
		//获取到redis连接
		RedisConnection redis = jedisConnectionFactory.getConnection();
		//用于序列化数据(key,valus)
		RedisSerializer<Object> ser = new JdkSerializationRedisSerializer();
		//设置redis的过期时间
		Boolean expire = redis.expire(ser.serialize(key),0);
		redis.close();
		rwl.writeLock().unlock();//写入完成后,放开写锁
		return expire;//将从redis中取出的数据返回
	}

	//清空所有缓存
	public void clear() {
		rwl.readLock().lock();//读锁
		//获取到redis连接
		RedisConnection redis = jedisConnectionFactory.getConnection();
		redis.flushDb();
		redis.flushAll();
		redis.close();
		rwl.readLock().unlock();
		
	}

	//获得缓存中的数据量
	public int getSize() {
		RedisConnection redis = jedisConnectionFactory.getConnection();//获取redis连接
		Integer size=Integer.valueOf(redis.dbSize().toString());
		redis.close();
		return size;
	}

	public ReadWriteLock getReadWriteLock() {
		
		return rwl;
	}

}
