/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月25日  
* @version 1.0  
*/
package com.github.MineMybug.security.auth.entity;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author ruanhang
 * @date 2018年10月25日
 */
@Table(name = "auth_client")
public class Client {

	@Id
	private Integer id;

	private String code;

	private String secret;

	private String name;

	private String locked = "0";

	private String description;

	private Date crtTime;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @param secret the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the locked
	 */
	public String getLocked() {
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(String locked) {
		this.locked = locked;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the crtTime
	 */
	public Date getCrtTime() {
		return crtTime;
	}

	/**
	 * @param crtTime the crtTime to set
	 */
	public void setCrtTime(Date crtTime) {
		this.crtTime = crtTime;
	}
	
}
