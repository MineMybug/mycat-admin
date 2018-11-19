/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月16日  
* @version 1.0  
*/
package com.gihubMyMinebug.test.proxyTest;

import java.util.Random;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年11月16日  
*/
public class Tank implements Moveable{

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("====Tank Move====");
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("====Tank Stop====");
	}

	public void String (){
		System.out.println("............");
	}
}
