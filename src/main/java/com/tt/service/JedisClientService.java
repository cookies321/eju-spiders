package com.tt.service;

import java.util.List;
import java.util.Set;

/**
* @Description
* @author: 赵乐
* @Date: 2018/5/16 14:14
*/
public interface JedisClientService {
	//redis常用方法
	String get(String key);
	String set(String key, String value);
	String setex(String key, int expire, String value);
	String hget(String hkey, String key);
	long hset(String hkey, String key, String value);
	long incr(String key);
	long expire(String key, int second);
	long ttl(String key);
	long del(String key);
	long hdel(String hkey, String key);
	void close();
	void flushDB();

	void addObjectToList(String Key, Object obj);

	List<Object> lrange(String key, int start, int end);

	Object pollFromList(String key);

	byte[] serialize(Object obj);

	Object unserizlize(byte[] byt);

	Set<String> getKeys(String key);
}
