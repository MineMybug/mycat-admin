/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年12月19日  
* @version 1.0  
*/
package com.gihubMyMinebug.test.equalsTest;

import com.gihubMyMinebug.test.reflectest.Apple;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年12月19日  
*/
public class EqualsTest {
	
	public static void main(String[] args) {
		String string = "sdad";
		String string2 = "sdad";
//		System.out.println(string.equals(string2));
		Apple apple = new Apple(1,"苹果");
		Apple apple2 = new Apple(1,"苹果");
		System.out.println(apple.equals(apple2));
		System.out.println(apple == apple2);
		System.out.println(apple.hashCode());
		System.out.println(apple2.hashCode());
		System.out.println(string.hashCode());
		System.out.println(string2.hashCode());
	}

}
