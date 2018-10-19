/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月19日  
* @version 1.0  
*/
package com.github.MineMybug.security.fallback;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.MineMybug.security.fiegnclient.IProviderFeign;

import lombok.extern.slf4j.Slf4j;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年10月19日  
*/
@Component
@Slf4j
public class IProviderFeignFallback implements IProviderFeign{

	@Override
	public String provider() {
		log.error("调用{}异常{}","provider",null);
		return "sorry, it's error!";
	}

}
