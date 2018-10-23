/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月19日  
* @version 1.0  
*/
package com.github.MineMybug.security.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年10月19日  
*/
@Api("测试")
@RestController
@RequestMapping("/provider")
public class ProviderController {
	
	@Value("${server.port}")
	private String port;
	
	@ApiOperation(value = "计算+", notes = "加法")
	@RequestMapping(value="/demo", method = RequestMethod.GET)
	public String provider(){
//		int j = 1/0;
		return "i am "+ port;
	}

}
