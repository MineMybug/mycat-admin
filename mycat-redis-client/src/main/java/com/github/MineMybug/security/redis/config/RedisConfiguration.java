/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年10月31日  
* @version 1.0  
*/
package com.github.MineMybug.security.redis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**   
* <p>Description: </p>  
* @author ruanhang  
* @date 2018年10月31日  
*/
@Configuration
@EnableCaching
@ComponentScan({"com.github.MineMybug.security.redis.clientservice"})
public class RedisConfiguration {
	
	@Bean
    @ConfigurationProperties(prefix="spring.redis.pool")
    public JedisPoolConfig getRedisConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }
 
    @Bean
    @ConfigurationProperties(prefix="spring.redis")
    public JedisConnectionFactory getConnectionFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisPoolConfig config = getRedisConfig();
        factory.setPoolConfig(config);
        return factory;
    }
    
    @Bean
    public StringRedisSerializer getStringRedisSerializer() {
    	return new StringRedisSerializer();
    }
 
    @Bean
    @Primary
    public RedisTemplate redisTemplate() {
        JedisConnectionFactory jedisConnectionFactory = getConnectionFactory();
        StringRedisTemplate template = new StringRedisTemplate(jedisConnectionFactory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(getStringRedisSerializer());
        template.setHashValueSerializer(getStringRedisSerializer());
        template.setDefaultSerializer(getStringRedisSerializer());
        template.setKeySerializer(getStringRedisSerializer());
        template.setHashKeySerializer(getStringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

}
