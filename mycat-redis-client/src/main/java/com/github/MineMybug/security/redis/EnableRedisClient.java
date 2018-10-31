/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月31日  
* @version 1.0  
*/
package com.github.MineMybug.security.redis;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.github.MineMybug.security.redis.config.RedisConfiguration;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年10月31日  
*/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(RedisConfiguration.class)
public @interface EnableRedisClient {

}
