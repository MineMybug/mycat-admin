/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月16日  
* @version 1.0  
*/
package com.gihubMyMinebug.test.proxyTest.staticProxy.jicheng;

import com.gihubMyMinebug.test.proxyTest.Tank;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年11月16日  
*/
public class TankLog extends Tank{

	public void move(){
		System.out.println("===Tank log start===");
		super.move();
		System.out.println("===Tank log end===");
	}
}
