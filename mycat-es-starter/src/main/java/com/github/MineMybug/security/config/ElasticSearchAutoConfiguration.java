/**   
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>    
* @date 2018年11月6日  
* @version 1.0  
*/
package com.github.MineMybug.security.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.MineMybug.security.property.ElasticSearchProperties;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author ruanhang
 * @date 2018年11月6日
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(ElasticSearchProperties.class)
public class ElasticSearchAutoConfiguration implements DisposableBean {

	private TransportClient transportClient;
	@Resource
	private ElasticSearchProperties elasticSearchProperties;

	@Bean
	@ConditionalOnMissingBean(TransportClient.class)
	public TransportClient transportClient() {
		log.debug("=======" + elasticSearchProperties.getClusterName());
		log.debug("=======" + elasticSearchProperties.getClusterNodes());
		log.debug("=======" + elasticSearchProperties.getUserName());
		log.debug("=======" + elasticSearchProperties.getPassword());
		log.info("开始建立es连接");
		transportClient = new PreBuiltXPackTransportClient(settings());
		TransportAddress[] transportAddresses = Arrays.stream(elasticSearchProperties.getClusterNodes().split(","))
				.map(t -> {
					String[] addressPortPairs = t.split(":");
					String address = addressPortPairs[0];
					Integer port = Integer.valueOf(addressPortPairs[1]);
					try {
						return new InetSocketTransportAddress(InetAddress.getByName(address), port);
					} catch (UnknownHostException e) {
						log.error("", e);
						throw new RuntimeException("连接ElasticSearch失败", e);
					}
				}).collect(Collectors.toList()).toArray(new TransportAddress[0]);
		transportClient.addTransportAddresses(transportAddresses);
		return transportClient;
	}

	private Settings settings() {
		return Settings.builder().put("cluster.name", elasticSearchProperties.getClusterName())
				.put("xpack.security.user",
						elasticSearchProperties.getUserName() + ":" + elasticSearchProperties.getPassword())
				.build();
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		log.info("开始销毁Es的连接");
		if (transportClient != null) {
			transportClient.close();
		}
	}

}
