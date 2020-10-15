package com.zhiyou.redis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

public class RedisCache implements Cache{

	//����һ��id
	private final String id;
	//ͨ�����췽����id��ֵ
	
	//������д������
	private final ReadWriteLock rwl = new ReentrantReadWriteLock();
	//�������ӵĹ���
	private static JedisConnectionFactory jedisConnectionFactory;
	
	//Ϊ��ע��JedisConnectionFactory
	public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory){
		RedisCache.jedisConnectionFactory=jedisConnectionFactory;
	}
	
	public RedisCache(String id){
		this.id=id;
	}
	//���idʵ���Ͼ��ǻ����key
	public String getId() {
		
		return id;
	}

	//������д�뵽������(redis)
	public void putObject(Object key, Object value) {
		rwl.writeLock().lock();//д���ݵ�ʱ�������,��ֹ�Լ�д��ʱ����Ҳ��д
		//��ȡ��redis����
		RedisConnection redis = jedisConnectionFactory.getConnection();
		//�������л�����(key,valus)
		RedisSerializer<Object> ser = new JdkSerializationRedisSerializer();
		//��key��value���л�����뵽redis��
		redis.set(ser.serialize(key), ser.serialize(value));
		redis.close();
		rwl.writeLock().unlock();//д����ɺ�,�ſ�д��
	}

	//�ӻ�����ȡ������
	public Object getObject(Object key) {
		rwl.readLock().lock();//����
		//��ȡ��redis����
		RedisConnection redis = jedisConnectionFactory.getConnection();
		//�������л�����
		RedisSerializer<Object> ser = new JdkSerializationRedisSerializer();
		//�������л����key��redis��ȡֵ,Ȼ���ٽ�redisȡ�������ݽ��з����л�
		Object object=ser.deserialize(redis.get(ser.serialize(key)));
		redis.close();
		rwl.readLock().lock();//д����ɺ�,�ſ�����
		return object;//��redis��ȡ�������ݷ���
	}

	//�ӻ�����ɾ������
	public Object removeObject(Object key) {
		rwl.writeLock().lock();//д���ݵ�ʱ�������,��ֹ�Լ�д��ʱ����Ҳ��д
		//��ȡ��redis����
		RedisConnection redis = jedisConnectionFactory.getConnection();
		//�������л�����(key,valus)
		RedisSerializer<Object> ser = new JdkSerializationRedisSerializer();
		//����redis�Ĺ���ʱ��
		Boolean expire = redis.expire(ser.serialize(key),0);
		redis.close();
		rwl.writeLock().unlock();//д����ɺ�,�ſ�д��
		return expire;//����redis��ȡ�������ݷ���
	}

	//������л���
	public void clear() {
		rwl.readLock().lock();//����
		//��ȡ��redis����
		RedisConnection redis = jedisConnectionFactory.getConnection();
		redis.flushDb();
		redis.flushAll();
		redis.close();
		rwl.readLock().unlock();
		
	}

	//��û����е�������
	public int getSize() {
		RedisConnection redis = jedisConnectionFactory.getConnection();//��ȡredis����
		Integer size=Integer.valueOf(redis.dbSize().toString());
		redis.close();
		return size;
	}

	public ReadWriteLock getReadWriteLock() {
		
		return rwl;
	}

}
