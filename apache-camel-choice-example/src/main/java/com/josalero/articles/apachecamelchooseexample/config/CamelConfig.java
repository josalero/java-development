package com.josalero.articles.apachecamelchooseexample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationCamelContext.xml")
public class CamelConfig 
{

}
