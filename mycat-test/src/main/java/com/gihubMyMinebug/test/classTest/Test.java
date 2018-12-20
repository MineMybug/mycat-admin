/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年12月19日  
* @version 1.0  
*/
package com.gihubMyMinebug.test.classTest;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author ruanhang
 * @date 2018年12月19日
 */
public class Test {

	static {
		System.out.println("静态初始化执行了!");
	}

	private int s;

	/**
	 * @return the s
	 */
	public int getS() {
		return s;
	}

	/**
	 * @param s
	 *            the s to set
	 */
	public void setS(int s) {
		this.s = s;
	}

}
