package com.virtualpairprogrammers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PositionreceiverApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositionreceiverApplication.class, args);
	}
	
	@Bean
	public EurekaInstanceConfigBean eurekaInstanceConfigBean(InetUtils utils) 
	{
	   EurekaInstanceConfigBean instance = new EurekaInstanceConfigBean(utils);
	   AmazonInfo info = AmazonInfo.Builder.newBuilder().autoBuild("eureka");
	   instance.setHostname(info.get(AmazonInfo.MetaDataKey.publicHostname));
	   instance.setIpAddress(info.get(AmazonInfo.MetaDataKey.publicIpv4));
	   instance.setDataCenterInfo(info);
	   instance.setNonSecurePort(8080);
	   return instance;
	}
	
}
