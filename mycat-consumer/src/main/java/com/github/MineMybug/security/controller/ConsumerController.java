/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月19日  
* @version 1.0  
*/
package com.github.MineMybug.security.controller;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.MineMybug.security.common.context.BaseContextHandler;
import com.github.MineMybug.security.fiegnclient.IProviderFeign;
import com.github.MineMybug.security.redis.clientservice.RedisClient;
import com.github.MineMybug.security.thread.TestThread;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年10月19日  
*/
@Api(value="/test",tags="测试swagger")
@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {
	
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private IProviderFeign iProviderFeign;
	
	@Autowired
	private RedisClient redisClient;
	
	@Autowired
	private TestThread testThread;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		BaseContextHandler.set("test","consumer");
		System.out.println("当前consumer线程："+ Thread.currentThread().getName() 
				+ "value: " + BaseContextHandler.get("test"));
		return iProviderFeign.provider();
	}
	
	@ApiOperation(value="获取端口号",notes="获取端口号")
	@RequestMapping(value="/testSwagger",method=RequestMethod.GET)
	public String testSwagger() throws InterruptedException, ExecutionException, TimeoutException{
		
		redisClient.set("hello", "111111");
		String redisHello = redisClient.get("hello");
		
		for(int i=0;i<1000;i++){
			testThread.test();
			Future<String> furteurResult = testThread.sayHello(redisHello);
			log.info(furteurResult.get(3, TimeUnit.SECONDS));
		}
		return "i am " + port + redisHello;
	}

}
