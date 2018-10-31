/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月31日  
* @version 1.0  
*/
package com.github.MineMybug.security.design.builder;

/**
 * <p>
 * Description: 创建对象模式三剑客之一：建设者模式 简化复杂对象的构造
 * </p>
 * 
 * @author ruanhang
 * @date 2018年10月31日
 */
public class BuilderTest {

	public static void main(String[] args) {
		Programmer programmer = new Programmer.ProgrammerBuilder().setFirstName("F").setLastName("L").setCity("City")
				.setZipCode("0000A").setAddress("Street 39").build();
		System.out.println(programmer.toString());
	}

}

class Programmer {

	private String firstName;
	private String lastName;
	private String address;
	private String zipCode;
	private String city;

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param zipCode
	 * @param city
	 */
	public Programmer(String firstName, String lastName, String address, String zipCode, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
	}

	public static class ProgrammerBuilder {

	 private String firstName;
	 private String lastName;
	 private String address;
	 private String zipCode;
	 private String city;

	 public ProgrammerBuilder setFirstName(String firstName) {
	      this.firstName = firstName;
	      return this;
	    }

	    public ProgrammerBuilder setLastName(String lastName) {
	      this.lastName = lastName;
	      return this;
	    }

	    public ProgrammerBuilder setAddress(String address) {
	      this.address = address;
	      return this;
	    }

	    public ProgrammerBuilder setZipCode(String zipCode) {
	      this.zipCode = zipCode;
	      return this;
	    }

	    public ProgrammerBuilder setCity(String city) {
	      this.city = city;
	      return this;
	    }

		public Programmer build() {
			return new Programmer(firstName, lastName, address, zipCode, city);
		}

	}

	@Override
	public String toString() {
		return "Programmer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", zipCode="
				+ zipCode + ", city=" + city + "]";
	}

}
