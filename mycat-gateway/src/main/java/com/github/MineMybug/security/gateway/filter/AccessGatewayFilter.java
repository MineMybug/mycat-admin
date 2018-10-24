/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月24日  
* @version 1.0  
*/
package com.github.MineMybug.security.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年10月24日  
*/
public class AccessGatewayFilter implements GlobalFilter{

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		return null;
	}

}
