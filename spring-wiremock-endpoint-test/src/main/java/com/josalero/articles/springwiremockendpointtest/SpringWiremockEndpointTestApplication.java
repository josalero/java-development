package com.josalero.articles.springwiremockendpointtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringWiremockEndpointTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWiremockEndpointTestApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}
