/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年12月25日  
* @version 1.0  
*/
package com.gihubMyMinebug.test.threadTest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年12月25日  
*/
public class MyCachedThreadPool {

	public static void main(String[] args) {

		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.err.println(Thread.currentThread().getName() + "running");
				try {
					Thread.sleep(1000l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.err.println(Thread.currentThread().getName() + "end");
			}
		};
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(runnable);
		executorService.execute(runnable);
		executorService.execute(runnable);
		executorService.execute(runnable);
		executorService.shutdown();
	}
	
}