/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月16日  
* @version 1.0  
*/
package com.gihubMyMinebug.test.proxyTest.moveProxy;

import com.gihubMyMinebug.test.proxyTest.Moveable;
import com.gihubMyMinebug.test.proxyTest.Tank;

/**
 * <p>
 * Description: 在使用时，首先创建一个业务实现类对象和一个代理类对象，然后定义接口引用（这里使用向上转型）
 * 并用代理对象.bind(业务实现类对象)的返回值进行赋值。最后通过接口引用调用业务方法即可。
 * （接口引用真正指向的是一个绑定了业务类的代理类对象，所以通过接口方法名调用的是被代理的方法们)
 * 
 * 总结： JDK动态代理的代理对象在创建时，需要使用业务实现类所实现的接口作为参数（因为在后面代理方法时需要根据接口内的方法名进行调用）。
 * 如果业务实现类是没有实现接口而是直接定义业务方法的话，就无法使用JDK动态代理了。并且，如果业务实现类中新增了接口中没有的方法，这些方法是无法被代理的（
 * 因为无法被调用）。
 * 
 * </p>
 * 
 * @author ruanhang
 * @date 2018年11月16日
 */
public class JdkProxyTest {

	public static void main(String[] args) {
		Tank tank = new Tank();
		TankProxy tankProxy = new TankProxy();
		Moveable moveable = (Moveable) tankProxy.bind(tank);
		moveable.move();
	}

}
