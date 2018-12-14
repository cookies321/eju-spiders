package com.tt.service.impl;

import com.tt.service.JedisClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class JedisClientServiceImpl implements JedisClientService {
	
	@Autowired
	private JedisPool jedisPool; 
	
	@Override
	public String get(String key) {
		Jedis jedis = null;	
		String string = null;
		try {
			jedis = jedisPool.getResource();
			string = jedis.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return string;
	}

	@Override
	public String set(String key, String value) {
		System.out.println(jedisPool+"-=------");
		Jedis jedis = null;
		String string = null;
		try {
			jedis = jedisPool.getResource();
			string = jedis.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return string;
	}

	@Override
	public String hget(String hkey, String key) {
		Jedis jedis = null;
		String string = null;
		try {
			jedis = jedisPool.getResource();
			string = jedis.hget(hkey, key);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return string;
	}

	@Override
	public long hset(String hkey, String key, String value) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.hset(hkey, key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return result;
	}

	@Override
	public long incr(String key) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.incr(key);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return result;
	}

	@Override
	public long expire(String key, int second) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.expire(key, second);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return result;
	}

	@Override
	public long ttl(String key) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.ttl(key);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return result;
	}

	@Override
	public long del(String key) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.del(key);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return result;
	}
	
	@Override
	public long hdel(String hkey, String key) {
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = jedisPool.getResource();
			result = jedis.hdel(hkey, key);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return result;
	}
	

	@Override
	public List<Object> lrange(String key, int start, int end) {
		Jedis jedis = null;
		List<Object> obj = new ArrayList<Object>();
		try {
			jedis = jedisPool.getResource();
			List<byte[]> list = jedis.lrange(key.getBytes(), start, end);
			for (int i = 0; i < list.size(); i++) {
				byte[] bs = list.get(i);
				Object unserizlize = this.unserizlize(bs);
				obj.add(unserizlize);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return obj;
	}

	@Override
	public void addObjectToList(String Key, Object obj) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.lpush(Key.getBytes(), this.serialize(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
	}

	@Override
	public Object pollFromList(String key) {
		Jedis jedis = null;
		Object unserizlize = null;
		try {
			jedis = jedisPool.getResource();
			byte[] rpop = jedis.rpop(key.getBytes());
			if (rpop!=null) {
				unserizlize = this.unserizlize(rpop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return unserizlize;
	}

	@Override
	public byte[] serialize(Object obj) {
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

	@Override
	public Object unserizlize(byte[] byt) {
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

	@Override
	public Set<String> getKeys(String key) {
		Jedis jedis = null;
		Set<String> keys = null;
		try {
			jedis = jedisPool.getResource();
			keys = jedis.keys(key);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return keys;
	}

	@Override
	public void flushDB() {
		// TODO Auto-generated method stub
		Jedis jedis = jedisPool.getResource();
		jedis.flushDB();
		jedis.close();
	}

	/* (non-Javadoc)
	 * @see com.jingjie.service.JedisClientService#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String setex(String key, int expire, String value) {
		Jedis jedis = null;
		String string = null;
		try {
			jedis = jedisPool.getResource();
			string = jedis.setex(key, expire, value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis.close();
			}
		}
		return string;
	}

	
	

}
