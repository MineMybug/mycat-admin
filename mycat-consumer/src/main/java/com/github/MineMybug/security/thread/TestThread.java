/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年12月25日  
* @version 1.0  
*/
package com.github.MineMybug.security.thread;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

import org.checkerframework.checker.units.qual.s;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.common.util.concurrent.ListenableFuture;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年12月25日  
*/
@Component
public class TestThread {
	
	private static AtomicInteger s = new AtomicInteger(0);
	
	@Async
	public String test(){
		System.out.println(Thread.currentThread().getName() + s.incrementAndGet());
		return "i am" ;
	}
	
	@Async
	public Future<String> sayHello(String name){
		String res = name + ":Hello world!";
		return new AsyncResult<>(res) ;
	}

}
