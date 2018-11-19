/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月16日  
* @version 1.0  
*/
package com.gihubMyMinebug.test.proxyTest.staticProxy.jicheng;

import com.gihubMyMinebug.test.proxyTest.Tank;

/**   
* <p>Description: 采用继承方式扩展Tank 扩展性不好！！！</p>  
* @author ruanhang  
* @date 2018年11月16日  
*/
public class TankTime extends Tank{
	
	public void move(){
		System.out.println("===Tank Time===");
		super.move();
		System.out.println("===Tank Time end===");
	}

}
