/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月19日  
* @version 1.0  
*/
package com.github.MineMybug.security.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.MineMybug.security.fallback.IProviderFeignFallback;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年10月19日  
*/
@FeignClient(value="mycat-provider",fallback=IProviderFeignFallback.class)
public interface IProviderFeign {
	
	@RequestMapping(value="/provider/demo", method= RequestMethod.GET)
	public String provider();

}
