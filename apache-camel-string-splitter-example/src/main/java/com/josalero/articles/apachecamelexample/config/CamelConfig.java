package com.josalero.articles.apachecamelexample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationCamelContext.xml")
public class CamelConfig 
{

}
