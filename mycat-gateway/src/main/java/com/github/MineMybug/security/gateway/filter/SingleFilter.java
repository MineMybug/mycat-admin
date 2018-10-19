/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月19日  
* @version 1.0  
*/
package com.github.MineMybug.security.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**   
* <p>
* 1.Description:自定义GatewayFilter对路由转发的处理时长统计 
* 2.相当于一个filter过滤器，可以访问的url 进行横向切割     应用于安全，超时等
* 3.gatewayFilter 一般用于单体路由或者一组路由   
* 
* 4.本例子统计某个或者某种路由的处理时长 
* 
* </p>  
* @author ruanhang  
* @date 2018年10月19日  
*/
@Configuration
@Slf4j
public class SingleFilter implements GatewayFilter,Ordered {

	private static final String COUNT_START_TIME = "countStartTime";
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

		exchange.getAttributes().put(COUNT_START_TIME, System.currentTimeMillis());
		return chain.filter(exchange).then(
				Mono.fromRunnable(()->{
					Long startTime = exchange.getAttribute(COUNT_START_TIME);
					Long endTime = System.currentTimeMillis() - startTime;
					if(startTime != null){
						log.info(exchange.getRequest().getURI().getRawPath() + ": " + endTime + "ms");
					}
		}));
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

}
