/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月16日  
* @version 1.0  
*/
package com.gihubMyMinebug.test.proxyTest.staticProxy.jicheng;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年11月16日  
*/
public class TankJTest {
	
	public static void main(String[] args) {
		TankTime tankTime = new TankTime();
		tankTime.move();
		TankLog tankLog = new TankLog();
		tankLog.move();
	}

}
