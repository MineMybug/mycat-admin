/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月24日  
* @version 1.0  
*/
package com.github.MineMybug.security.common.constant;

/**
 * <p>
 * Description:定义各种常量
 * </p>
 * 
 * @author ruanhang
 * @date 2018年10月24日
 */
public class CommonConstants {

	public final static String RESOURCE_TYPE_MENU = "menu";
	public final static String RESOURCE_TYPE_BTN = "button";
	// 用户token异常
	public static final Integer EX_USER_INVALID_CODE = 40101;
	public static final Integer EX_USER_PASS_INVALID_CODE = 40001;
	// 客户端token异常
	public static final Integer EX_CLIENT_INVALID_CODE = 40301;
	public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
	public static final Integer EX_OTHER_CODE = 500;
	public static final String CONTEXT_KEY_USER_ID = "currentUserId";
	public static final String CONTEXT_KEY_USERNAME = "currentUserName";
	public static final String CONTEXT_KEY_USER_NAME = "currentUser";
	public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
	public static final String JWT_KEY_USER_ID = "userId";
	public static final String JWT_KEY_NAME = "name";

}
