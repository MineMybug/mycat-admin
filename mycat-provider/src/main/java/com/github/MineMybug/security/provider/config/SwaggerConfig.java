/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月23日  
* @version 1.0  
*/
package com.github.MineMybug.security.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author ruanhang
 * @date 2018年10月23日
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).
				apiInfo(apiInfo()).host("localhost:5001/api/provider")
				.select()
				// 自行修改为自己的包路径
				.apis(RequestHandlerSelectors.basePackage("com.github.MineMybug.security.provider.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("api文档")
				.description("restfun 风格接口")
				// 服务条款网址
				// .termsOfServiceUrl("http://blog.csdn.net/forezp")
				.version("1.0")
				// .contact(new Contact("帅呆了", "url", "email"))
				.build();
	}

}
