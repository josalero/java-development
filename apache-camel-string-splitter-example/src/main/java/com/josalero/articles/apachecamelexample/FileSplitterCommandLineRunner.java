package com.josalero.articles.apachecamelexample;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FileSplitterCommandLineRunner implements CommandLineRunner {

	@Autowired
	CamelContext camelContext;
	
	@Override
	public void run(String... args) throws Exception 
	{
		ProducerTemplate producer = camelContext.createProducerTemplate();
		producer.sendBody("direct:start", "This is a Apache Camel Example");	
	}

}
