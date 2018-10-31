package com.github.MineMybug.security.job.excutor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jieshun.jsrm.EnableRedisClient;

@SpringBootApplication
@EnableRedisClient
@MapperScan("com.xxl.job.executor.mapper")
public class XxlJobExecutorApplication {

	public static void main(String[] args) {
        SpringApplication.run(XxlJobExecutorApplication.class, args);
	}

}