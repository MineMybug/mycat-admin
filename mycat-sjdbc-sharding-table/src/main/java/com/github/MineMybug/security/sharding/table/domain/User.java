/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年12月20日  
* @version 1.0  
*/
package com.github.MineMybug.security.sharding.table.domain;

import java.io.Serializable;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年12月20日  
*/
public class User implements Serializable{

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String city = "";
	
	private String name = "";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
