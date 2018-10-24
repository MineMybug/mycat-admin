/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月24日  
* @version 1.0  
*/
package com.github.MineMybug.security.common.context;

import java.util.HashMap;
import java.util.Map;

import com.github.MineMybug.security.common.constant.CommonConstants;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年10月24日  
*/
public class BaseContextHandler {
	
	public static ThreadLocal<Map<String, Object>> threadLocal = new InheritableThreadLocal<Map<String,Object>>(); 
	
	public static void set(String key, Object value){
		Map<String, Object> map = threadLocal.get();
		if(map == null){
			map = new HashMap<String, Object>();
			threadLocal.set(map);
		}
		map.put(key, value);
	}
	
	public static Object get(String key){
		Map<String, Object> map = threadLocal.get();
		if(map == null){
			map = new HashMap<String, Object>();
			threadLocal.set(map);
		}
		return map.get(key);
	}
	
	public static String getUserId(){
		Object value = get(CommonConstants.CONTEXT_KEY_USER_ID);
		return returnObjectValue(value);
	}

	public static String getUserName(){
		Object value = get(CommonConstants.CONTEXT_KEY_USERNAME);
		return returnObjectValue(value);
	}
	
	public static String getName(){
		Object value = get(CommonConstants.CONTEXT_KEY_USER_NAME);
		return returnObjectValue(value);
	}
	
	public static String getToken(){
		Object value = get(CommonConstants.CONTEXT_KEY_USER_TOKEN);
		return returnObjectValue(value);
	}
	
	public static void setUserId(String userId){
		set(CommonConstants.CONTEXT_KEY_USER_ID, userId);
	}
	
	public static void setUserName(String userName){
		set(CommonConstants.CONTEXT_KEY_USERNAME, userName);
	}
	
	public static void setName(String name){
		set(CommonConstants.CONTEXT_KEY_USERNAME, name);
	}
	
	public static void setToken(String token){
		set(CommonConstants.CONTEXT_KEY_USER_TOKEN, token);
	}
	
	private static String returnObjectValue(Object value) {
		return value == null?null:value.toString();
	}
	
	public static void remove(){
		threadLocal.remove();
	}
	
	public static void main(String[] args) throws Exception {
		BaseContextHandler.set("test", "main");
        new Thread(()->{
            BaseContextHandler.set("test", "moo");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程："+ Thread.currentThread().getName() + " " + "value: " + BaseContextHandler.get("test"));
//            assertEquals(BaseContextHandler.get("test"), "moo");
//            log.info("thread one done!");
        }).start();
        new Thread(()->{
            BaseContextHandler.set("test", "moo2");
//            assertEquals(BaseContextHandler.get("test"), "moo2");
//            logger.info("thread two done!");
            System.out.println("当前线程："+ Thread.currentThread().getName() + " " + "value: " + BaseContextHandler.get("test"));
        }).start();

        Thread.sleep(5000);
//        assertEquals(BaseContextHandler.get("test"), "main");
//        logger.info("main one done!");
        System.out.println("当前线程："+ Thread.currentThread().getName() + " " + "value: " + BaseContextHandler.get("test"));
	}

}
