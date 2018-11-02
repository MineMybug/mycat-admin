/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月31日  
* @version 1.0  
*/
package com.github.MineMybug.security.redis.clientservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年10月31日  
*/
@Configuration
@Slf4j
public class RedisClient {
	
	@Autowired
    private RedisTemplate redisTemplate;
	
	@Value("${spring.redis.key_prefix}")
    private String KEY_PREFIX;
	
	private String getKey(String key) {
		return KEY_PREFIX + "" +key;
	}
    /**
     * 写入字符串缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, String value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, String> operations = redisTemplate.opsForValue();
            operations.set(getKey(key), value);
            result = true;
        } catch (Exception e) {
            log.error("操作缓存失败", e);
        }
        return result;
    }
    /**
     * 写入字符串缓存设置时效时间
     * @param key
     * @param value
     * 
     * @return
     */
    public boolean set(final String key, String value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, String> operations = redisTemplate.opsForValue();
            operations.set(getKey(key), value);
            redisTemplate.expire(getKey(key), expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            log.error("操作缓存失败", e);
        }
        return result;
    }
    
    /**
     * 批量删除对应的value
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     * @param pattern
     */
    public void removePattern(final String pattern) {
    	try {
    		Set<Serializable> keys = redisTemplate.keys(pattern);
            if (keys.size() > 0) {
            	redisTemplate.delete(keys);
            }
            log.info("===================移除的redis中key的pattern为："+pattern);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    }
    
    /**
     * 删除对应的value
     * @param key
     */
    public void remove(final String key) {
    	try {
    		if (exists(key)) {
                redisTemplate.delete(getKey(key));
            }
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    }
    
    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
    	try {
    		return redisTemplate.hasKey(getKey(key));
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
        return false;
    }
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public String get(final String key) {
        String result = null;
        try {
        	ValueOperations<Serializable, String> operations = redisTemplate.opsForValue();
            result = operations.get(getKey(key));
        }catch (Exception e) {
            log.error("操作缓存失败", e);
        }
        return result;
    }
    
    /**
     * 写入序列化对象缓存
     * @param key
     * @param value
     * @return
     */
    public boolean setSerializable(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(getKey(key), value);
            result = true;
        } catch (Exception e) {
            log.error("操作缓存失败", e);
        }
        return result;
    }
    
    /**
     * 写入序列化对象缓存,设置时间
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean setSerializable(final String key, Object value,Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(getKey(key), value, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            log.error("操作缓存失败", e);
        }
        return result;
    }
    
    /**
     * 读取序列化对象缓存缓存
     * @param key
     * @return
     */
    public Object getSerializable(final String key) {
        Object result = null;
        try {
        	ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            result = operations.get(getKey(key));
        }catch (Exception e) {
            log.error("操作缓存失败", e);
        }
        return result;
    }
    
    /**
     * 哈希中 单个属性 添加
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object hashvalue){
    	try {
    		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
            hash.put(getKey(key),hashKey,hashvalue);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    }
    
    /**
     * 哈希中 单个属性 添加  并设置哈希表 过期时间
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(String key, Object hashKey, Object hashvalue,Long expireTime){
    	try {
            HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
            hash.put(getKey(key),hashKey,hashvalue);
            this.redisTemplate.expire(getKey(key), expireTime, TimeUnit.SECONDS);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    }

    /**
     * 哈希表中获取单个属性数据
     * @param key
     * @param hashKey
     * @return
     */
    public Object hmGet(String key, Object hashKey){
    	try {
    		HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
            return hash.get(getKey(key),hashKey);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    	return null;
    }
    
    /**
     * 哈希表中获取单个属性数据(value是jsonobject字符串)
     * @param key
     * @param hashKey
     * @return map
     */
    public Map hmGetMap(String key, Object hashKey){
    	try {
    		HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
            Object redisObj = hash.get(getKey(key),hashKey);
            if(redisObj != null) {
            	JSONObject obj = JSONObject.parseObject(redisObj+"");
            	Map<String,Object> map = JSONObject.toJavaObject(obj, Map.class);
            	return map;
            }
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    	return null;
    }
    
    /**
     * 哈希表中的keys转换成set取出
     * @param key
     * @param hashKey
     * @return
     */
    public Set<String> hmkeys(String key){
    	Set<String> localSetList = new HashSet<>();
    	try {
    		HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
    	    Map localMap = hash.entries(getKey(key));
    	    if (null != localMap){
    	    	for (Object str : localMap.keySet()) {
    	    		localSetList.add(str+"");
    	    	}
    	    }
    	    return localSetList;
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    	return null;
    }
    
    /**
     * 哈希表中的值转换成list取出
     * @param key
     * @param hashKey
     * @return
     */
    public List<String> hmvals(String key){
    	List<String> localArrayList = new ArrayList();
    	try {
    		HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
    	    Map localMap = hash.entries(getKey(key));
    	    if (null != localMap){
    	    	for (Object str : localMap.values()) {
    	    		localArrayList.add(str+"");
    	    	}
    	    }
    	    return localArrayList;
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    	return null;
    }
    
    /**
     * 哈希表中的值转换成list取出 
     * @param key
     * @param hashKey
     * @return
     */
    public List<String> hmget(String key,String[] paramArrayOfString){
    	List<String> localArrayList = new ArrayList();
    	try {
    		HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
    	    Map localMap = hash.entries(getKey(key));
    	    if (null != localMap){
    	    	for (String str : paramArrayOfString) {
    	    		String value = (String) localMap.get(str);
    	    		localArrayList.add(value);
    	    	}
    	    }
    	    return localArrayList;
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    	return null;
    }
    
    /**
     * 哈希表中的key:value 模糊匹配取出 
     * @param key
     * @param key_pattern 格式： xxxx* 左匹配；*xxxx 右匹配；*xxxx* 全匹配
     * @return
     */
    public Map<String,Object> hmget(String key,String key_pattern){
    	Map<String,Object> resultMap = new HashMap<>();
    	try {
    		HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
    	    Map<Object, Object> localMap = hash.entries(getKey(key));
    	    if (null != localMap){
    	    	String[] matchs = this.getMatchType(key_pattern);
    	    	for (Map.Entry<Object, Object> entry : localMap.entrySet()) { 
    	    		String localkey = entry.getKey()+"";
    	    		Object localval = entry.getValue();
    	    		if(matchs[0].equals("left")) {  //左匹配
    	    			if(localkey.startsWith(matchs[1])) {
    	    				resultMap.put(localkey, localval);
    	    			}
    	    		}else if(matchs[0].equals("right")) { //右匹配
    	    			if(localkey.endsWith(matchs[1])) {
    	    				resultMap.put(localkey, localval);
    	    			}
    	    		}else {
    	    			if(localkey.contains(matchs[1])) { //中间匹配
    	    				resultMap.put(localkey, localval);
    	    			}
    	    		}
    	    	}
    	    }
    	    return resultMap;
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    	return resultMap;
    }
    
    /**
     * 获取匹配方式 left,center,right
     * @param key_pattern  解析匹配方式  :  xxxx*   *xxxxx    *xxxxx*
     * @return matchs[0] 匹配方式 ; matchs[1] 匹配的字符串
     */
    private String[] getMatchType(String key_pattern) {
    	String[] matchs = new String[2];
    	if(key_pattern != null && !"".equals(key_pattern)) {
    		if(key_pattern.startsWith("*") && key_pattern.endsWith("*")) {
    			matchs[0] = "center";
    		}else {
    			if(key_pattern.endsWith("*")) {
    				matchs[0] = "left";
	    		}else if(key_pattern.startsWith("*")) {
	    			matchs[0] = "right";
	    		}
    		}
    	}
    	matchs[1] = key_pattern.replaceAll("*", "");
    	return matchs;
    }
    
    /**
     * 删除哈希表中的一些属性
     * @param key
     * @param hashKey
     */
    public void hmdel(String key, Object... hashKey){
    	try {
    		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
            hash.delete(getKey(key),hashKey);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    }
    
    
    /**
     * 哈希表 添加
     * @param key
     * @param value(Map)
     */
    public void hmSet(String key, Map value){
    	try {
    		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
            hash.putAll(getKey(key), value);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    }
    
    /**
     * 哈希表 添加 设置时间
     * @param key
     * @param value
     * @param expireTime
     */
    public void hmSet(String key, Map value,Long expireTime){
    	try {
    		HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
            hash.putAll(getKey(key), value);
            redisTemplate.expire(getKey(key), expireTime, TimeUnit.SECONDS);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    }
    
    /**
     * 哈希表 获取
     * @param key
     * @return
     */
    public Map hmGetAll(String key){
    	try {
    		HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
            return hash.entries(getKey(key));
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
        return null;
    }

    /**
     * list列表添加
     * @param k
     * @param v
     */
    public void lPush(String k,List v){
    	try {
    		ListOperations<String, Object> list = redisTemplate.opsForList();
            list.rightPushAll(getKey(k),v);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    }
    
    /**
     * list列表获取
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public List<Object> lRange(String k){
    	try {
    		ListOperations<String, Object> list = redisTemplate.opsForList();
            return list.range(getKey(k),0,-1);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
        return null;
    }

    /**
     * 集合添加
     * @param key
     * @param value
     */
    public void add(String key,Object value){
    	try {
    		SetOperations<String, Object> set = redisTemplate.opsForSet();
            set.add(getKey(key),value);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public Set<Object> setMembers(String key){
    	try {
    		SetOperations<String, Object> set = redisTemplate.opsForSet();
            return set.members(getKey(key));
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    	return null;
    }
    
    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(String key,Object value,double scoure){
    	try {
    		ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
            zset.add(getKey(key),value,scoure);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    }


    /**
     * 有序集合获取
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> rangeByScore(String key,double scoure,double scoure1){
    	try {
    		ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
            return zset.rangeByScore(getKey(key), scoure, scoure1);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
        return null;
    }
    
    /**
     * 有序集合获取
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> range(String key,long scoure, long scoure1){
    	try {
    		ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
    		return zset.range(getKey(key), scoure, scoure1);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
        return null;
    }
    
    /**
     * 设置redis缓存的过期时间
     * @param key
     * @param expireTime
     */
    public void expire(String key,Long expireTime) {
    	try {
    		this.redisTemplate.expire(getKey(key), expireTime, TimeUnit.SECONDS);
    	}catch (Exception e) {
            log.error("操作缓存失败", e);
        }
    }
    

}
