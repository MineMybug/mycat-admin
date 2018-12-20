/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年12月20日  
* @version 1.0  
*/
package com.github.MineMybug.security.sharding.table.config;

import java.util.Collection;

import org.springframework.stereotype.Component;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

/**   
* <p>Description:自定义分片算法 </p>  
* @author ruanhang  
* @date 2018年12月20日  
*/
@Component
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long>{

	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
		for (String tableName : availableTargetNames) {
			if (tableName.endsWith(shardingValue.getValue() % 4 + "")) {
				return tableName;
			}
		}
		throw new IllegalArgumentException();
	}
	
	

}
