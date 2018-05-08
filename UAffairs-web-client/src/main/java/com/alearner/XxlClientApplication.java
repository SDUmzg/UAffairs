package com.alearner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuxueli 2018-03-22 23:41:47
 */
@EnableAutoConfiguration
@SpringBootApplication
public class XxlClientApplication {

	public static void main(String[] args) {
        SpringApplication.run(XxlClientApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}




}