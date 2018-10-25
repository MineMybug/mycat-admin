/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月25日  
* @version 1.0  
*/
package com.github.MineMybug.security.auth.entity;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name = "auth_client_server")
public class ClientServer {

	@Id
	private Integer id;

	@Column(name = "service_id")
	private String serviceId;

	@Column(name = "client_id")
	private String clientId;

	private String description;

	@Column(name = "crt_time")
	private Date crtTime;

	@Column(name = "crt_user")
	private String crtUser;

	@Column(name = "crt_name")
	private String crtName;

	@Column(name = "crt_host")
	private String crtHost;

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
	 * @return the serviceId
	 */
	public String getServiceId() {
		return serviceId;
	}

	/**
	 * @param serviceId the serviceId to set
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
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

	/**
	 * @return the crtUser
	 */
	public String getCrtUser() {
		return crtUser;
	}

	/**
	 * @param crtUser the crtUser to set
	 */
	public void setCrtUser(String crtUser) {
		this.crtUser = crtUser;
	}

	/**
	 * @return the crtName
	 */
	public String getCrtName() {
		return crtName;
	}

	/**
	 * @param crtName the crtName to set
	 */
	public void setCrtName(String crtName) {
		this.crtName = crtName;
	}

	/**
	 * @return the crtHost
	 */
	public String getCrtHost() {
		return crtHost;
	}

	/**
	 * @param crtHost the crtHost to set
	 */
	public void setCrtHost(String crtHost) {
		this.crtHost = crtHost;
	}
}
