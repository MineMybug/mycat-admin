package com.github.MineMybug.security.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: ruanhang
 * @data: 2018年10月17日
 */
@EnableEurekaServer
@SpringBootApplication
public class MycatEurekaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MycatEurekaApplication.class, args);
	}

}
