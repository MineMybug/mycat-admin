/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月23日  
* @version 1.0  
*/
package com.github.MineMybug.security.gateway.swaggerConfig;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年10月23日  
*/
@Component
public class SwaggerHeaderFilter extends AbstractGatewayFilterFactory {
	
	private static final String HEADER_NAME = "X-Forwarded-Prefix";

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            if (!StringUtils.endsWithIgnoreCase(path, SwaggerProvider.API_URI)) {
                return chain.filter(exchange);
            }

            String basePath = path.substring(1, path.lastIndexOf(SwaggerProvider.API_URI));

            ServerHttpRequest newRequest = request.mutate().header(HEADER_NAME, basePath).build();
            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
            return chain.filter(newExchange);
        };
    }

}
