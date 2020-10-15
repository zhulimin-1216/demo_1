package com.zhiyou.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;


//��̬ע���м���

public class ReidsUtil {

	/*
	 * ����RedisUtil�಻�ܱ�Springֱ�ӹ��������޷�ֱ���������ȡJedisConnectionFactory����������Ҫͨ������࣬������౻IOC��������
	 * Ȼ���������ȡ��JedisConnectionFactory���󣬵���RedisCache���еķ���
	 */
//	@Autowired
	public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"+jedisConnectionFactory);
		RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
	}
}
