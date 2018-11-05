/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月3日  
* @version 1.0  
*/
package com.gihubMyMinebug.test.reflectest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.xml.crypto.dsig.keyinfo.KeyInfo;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年11月3日  
*/
public class Apple {
	
	private int price;
	
	public String name;

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	public static void main(String[] args) throws Exception {
		//正常调用
		Apple apple = new Apple();
		apple.setPrice(4);
		System.out.println("正常调用初始化Apple=========>>>> " + apple.getPrice());
		
		//使用反射调用
		Class clz = Class.forName("com.gihubMyMinebug.test.reflectest.Apple");
		Method method = clz.getMethod("setPrice", int.class);
		Constructor appleConstructor = clz.getConstructor();
		Object appleObject = appleConstructor.newInstance();
		method.invoke(appleObject, 14);
		Method getPriceMethod = clz.getMethod("getPrice");
		System.out.println("使用反射赋值并调用price===========>>>> " +  getPriceMethod.invoke(appleObject));
		
		//通过反射获取类属性、方法、构造器
		Class appclz = Apple.class;
		Field[] fields =  appclz.getFields();//只能获取到共有属性，私有属性获取不到
		for (Field field : fields) {
			System.out.println(field.getName());
		}
		
		Field[] fields2 = appclz.getDeclaredFields();//可以获取包括私有属性内的所有的属性
		for (Field field : fields2) {
			System.out.println(field.getName());
		}
		
	}

}
