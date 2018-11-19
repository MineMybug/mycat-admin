/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月16日  
* @version 1.0  
*/
package com.gihubMyMinebug.test.proxyTest.staticProxy.jicheng;

import com.gihubMyMinebug.test.proxyTest.Moveable;

/**
 * <p>
 * Description: 采用实现接口 使用代理模式
 * </p>
 * 
 * @author ruanhang
 * @date 2018年11月16日
 */
public class TimeProxy implements Moveable {

	Moveable m;

	public TimeProxy(Moveable m) {
		super();
		this.m = m;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("time start");
		m.move();
		System.out.println("time end");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}


}
