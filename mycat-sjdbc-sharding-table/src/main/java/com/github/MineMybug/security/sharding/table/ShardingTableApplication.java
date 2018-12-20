/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年12月20日  
* @version 1.0  
*/
package com.github.MineMybug.security.sharding.table;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**   
* <p>Description:不分库，只分表 </p>  
* @author ruanhang  
* @date 2018年12月20日  
*/
@MapperScan("com.github.MineMybug.security.sharding.table.repository")
@SpringBootApplication
public class ShardingTableApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShardingTableApplication.class, args);
	}

}
