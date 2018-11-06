/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月6日  
* @version 1.0  
*/
package com.github.MineMybug.security.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年11月6日  
*/
@ConfigurationProperties(prefix="sxw.elasticsearch")
public class ElasticSearchProperties {
	
	private String clusterName = "elasticsearch";
	
	private String clusterNodes = "127.0.0.1:9300";
	
	private String userName = "elastic";
	
	private String password = "changeme";

	/**
	 * @return the clusterName
	 */
	public String getClusterName() {
		return clusterName;
	}

	/**
	 * @param clusterName the clusterName to set
	 */
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the clusterNodes
	 */
	public String getClusterNodes() {
		return clusterNodes;
	}

	/**
	 * @param clusterNodes the clusterNodes to set
	 */
	public void setClusterNodes(String clusterNodes) {
		this.clusterNodes = clusterNodes;
	}
	
}
