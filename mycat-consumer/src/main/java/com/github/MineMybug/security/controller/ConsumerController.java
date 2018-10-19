/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月19日  
* @version 1.0  
*/
package com.github.MineMybug.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.MineMybug.security.fiegnclient.IProviderFeign;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年10月19日  
*/
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
	@Autowired
	private IProviderFeign iProviderFeign;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		return iProviderFeign.provider();
	}

}
