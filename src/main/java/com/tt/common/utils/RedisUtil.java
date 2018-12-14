package com.tt.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

/**
 * 操作redis数据库的工具类 Created by dajiangtai
 *
 */
public class RedisUtil {

	static JedisPool jedisPool = null;

	static {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(10);
		poolConfig.setMaxTotal(100);
		poolConfig.setMaxWaitMillis(10000);
		poolConfig.setTestOnBorrow(true);
		if(jedisPool==null){
			jedisPool = new JedisPool(poolConfig, "10.122.139.29", 6379);
		}
	}


	/**
	 * 构造方法
	 */
	public RedisUtil() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(10);
		poolConfig.setMaxTotal(100);
		poolConfig.setMaxWaitMillis(10000);
		poolConfig.setTestOnBorrow(true);
		jedisPool = new JedisPool(poolConfig, "10.122.139.29", 6379);
		//jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379);
	}

	/**
	 * @Description 查询
	 * @author 徐仁杰
	 * @date 2017年11月30日 上午10:05:31
	 * @action lrange
	 * @return List<String>
	 */
	public static List<Object> lrange(String key, int start, int end) {
		Jedis resource = jedisPool.getResource();
		List<byte[]> list = resource.lrange(key.getBytes(), start, end);
		List<Object> obj = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			byte[] bs = list.get(i);
			Object unserizlize = unserizlize(bs);
			obj.add(unserizlize);
		}
		jedisPool.close();
		return obj;
	}
	
	
	/**
	 * 
	 * @Description 添加list key,value是string
	 * @author 赵乐
	 * @date 2017年12月8日 上午11:21:25
	 * @action addStr
	 * @param @param Key
	 * @param @param url
	 * @return void
	 */
	public static void addStr(String Key, String url) {
		Jedis resource = jedisPool.getResource();
		resource.lpush(Key, url);
		resource.close();
	}
	/**
	 * 
	 * @Description list中获取str
	 * @author 赵乐
	 * @date 2017年12月8日 上午11:25:55
	 * @action poll
	 * @param @param key
	 * @param @return
	 * @return String
	 */
	public static String pollStr(String key) {
		Jedis resource = jedisPool.getResource();
		String rpop = resource.rpop(key);
		resource.close();
		return rpop;
	}

	/**
	 * @Description 添加list
	 * @author 徐仁杰
	 * @date 2017年11月30日 上午10:05:22
	 * @action add
	 * @return void
	 */
	public static void add(String Key, Object obj) {
		Jedis resource = jedisPool.getResource();
		resource.lpush(Key.getBytes(), serialize(obj));
		resource.close();
	}
	/**
	 * @Description list中获取
	 * @author 徐仁杰
	 * @date 2017年11月30日 上午10:05:03
	 * @action poll
	 * @return String
	 */
	public static Object poll(String key) {
		Jedis resource = jedisPool.getResource();
		byte[] rpop = resource.rpop(key.getBytes());
		Object unserizlize = null;
		if(Objects.nonNull(rpop)){
			unserizlize = unserizlize(rpop);
		}
		resource.close();
		return unserizlize;
	}
	
	
	/**
	 * @Description 添加set
	 * @author 徐仁杰
	 * @date 2017年11月30日 上午10:04:57
	 * @action addSet
	 * @return void
	 */
	public static void addSet(String Key, String value) {
		Jedis resource = jedisPool.getResource();
		resource.sadd(Key, value);
		resource.close();
	}
	/**
	 *
	 * 功能描述: 设置key，value
	 *
	 * @param: 
	 * @return:
	 * @auther: 赵乐
	 * @date: 2018/10/29 14:58
	 */
	public static void set(String Key, String value) {
		Jedis resource = jedisPool.getResource();
		resource.set(Key, value);
		resource.close();
	}
	/**
	 *
	 * 功能描述: s设置key-value，并设置key的生命时间
	 *
	 * @param: 
	 * @return:
	 * @auther: 赵乐
	 * @date: 2018/10/29 15:00
	 */
	public static void setex(String key,int second,String value){
		Jedis resource = jedisPool.getResource();
		try {
			resource.setex(key,second,value);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resource.close();
		}
	}
    
	/**
	 *
	 * 功能描述: 获取所有的keys
	 *
	 * @param: 
	 * @return:
	 * @auther: 赵乐
	 * @date: 2018/10/29 15:17
	 */
	public static Set<String> keys(String key){
        Jedis resource = jedisPool.getResource();
        Set<String> keys = null;
        try {
            keys = resource.keys(key+"*");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resource.close();
        }
        return keys;
    }
    
    /**
     *
     * 功能描述: redis中删除key
     *
     * @param: 
     * @return:
     * @auther: 赵乐
     * @date: 2018/10/29 15:18
     */
    public static void delKey(String key){
        Jedis resource = jedisPool.getResource();
        try {
            resource.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            resource.close();
        }

    }

	/**
	 * @Description 随机获取Set 值
	 * @author 徐仁杰
	 * @date 2017年11月30日 上午10:04:50
	 * @action getSet
	 * @return String
	 */
	public static String getSet(String key) {
		Jedis resource = jedisPool.getResource();
		String value = null;
		try {
			value = resource.srandmember(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resource.close();
		}
		return value;
	}

	/**
	 * @Description 删除Set 随机值
	 * @author 徐仁杰
	 * @date 2017年11月30日 上午10:04:42
	 * @action deleteSet
	 * @return void
	 */
	public static void deleteSet(String key, String value) {
		Jedis resource = jedisPool.getResource();
		resource.srem(key, value);
		jedisPool.returnResourceObject(resource);
	}

	/**
	 * @Description 序列化
	 * @author 徐仁杰
	 * @date 2017年11月17日 上午10:46:19
	 * @action serialize
	 * @return byte[]
	 */
	public static byte[] serialize(Object obj) {
		ObjectOutputStream obi = null;
		ByteArrayOutputStream bai = null;
		try {
			bai = new ByteArrayOutputStream();
			obi = new ObjectOutputStream(bai);
			obi.writeObject(obj);
			byte[] byt = bai.toByteArray();
			return byt;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @Description 反序列化
	 * @author 徐仁杰
	 * @date 2017年11月17日 上午10:46:27
	 * @action unserizlize
	 * @return Object
	 */
	public static Object unserizlize(byte[] byt) {
		ObjectInputStream oii = null;
		ByteArrayInputStream bis = null;
		bis = new ByteArrayInputStream(byt);
		try {
			oii = new ObjectInputStream(bis);
			Object obj = oii.readObject();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Jedis getJedis(){
		Jedis resource = jedisPool.getResource();
		return resource;
	}

}