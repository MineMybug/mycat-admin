/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月16日  
* @version 1.0  
*/
package com.gihubMyMinebug.test.proxyTest.moveProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年11月16日  
*/
public class TankProxy implements InvocationHandler{

	private Object target; //业务实现类对象
	
	/*
	 * 绑定一个业务对象并返回一个代理类
	 */
	public Object bind(Object target){
		this.target = target;
		/*
		 * 通过反射机制，创建一个代理类对象实例并返回。用户进行方法调用时使用
		 * 创建代理对象时，需要传递该业务类的类加载器、接口、hanlder的实现类
		 */
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
	}
	
	/*
	 * 包装调用方法
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		System.out.println("预处理操作=======");
		result = method.invoke(target, args);
		System.out.println("调用后处理====");
		return result;
	}
	
}
