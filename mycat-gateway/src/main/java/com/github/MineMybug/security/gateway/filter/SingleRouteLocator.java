/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月19日  
* @version 1.0  
*/
package com.github.MineMybug.security.gateway.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**   
* <p>Description: 
* 	1. r.path(“/test/prefix/**”)表示自定义了访问前缀，在真正的Gateway进行路由转发的时候，会用过f.stripPrefix(2)把前缀去掉
*   2. filter(new SingleFilter()，表示把自定义的Filter加到Filter链里面执行，注意一点是自定义GlobalFilter不需要加进去
*   3. uri(“lb://SC-CONSUMER”)表示Spring Cloud Gateway对spring.application.name等于MYCAT-CONSUMER源服务应用中的URL进行协议适配转发。
* </p>  
* @author ruanhang  
* @date 2018年10月19日  
*/
@Configuration
public class SingleRouteLocator {
	
	@Bean
	public RouteLocator singleRouteLocators(RouteLocatorBuilder builder){
		return builder.routes().
				route(r -> r.path("/api/**")
						.filters(f -> f.stripPrefix(1)
                                .filter(new SingleFilter())
                                .addResponseHeader("X-Response-test", "test"))
                        .uri("lb://MYCAT-CONSUMER")
                        .order(0)
                        .id("mycat-consumer")
				)
				.build();
	}

}
