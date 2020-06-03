package com.josalero.articles.apachecamelchooseexample;

import java.util.Arrays;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.josalero.articles.apachecamelchooseexample.model.User;
import com.josalero.articles.apachecamelchooseexample.model.Users;

@Component
public class ChoiceCommandLineRunner implements CommandLineRunner {

	@Autowired
	CamelContext camelContext;
	
	@Override
	public void run(String... args) throws Exception 
	{
		ProducerTemplate producer = camelContext.createProducerTemplate();
		User user = new User(1L, "Jose");
		User user1 = new User(1L, "Adrian");
		User user2 = new User(1L, "Aleman");
		Users users = new Users(Arrays.asList(user, user1, user2));
		
		
		producer.sendBody("direct:start", new ObjectMapper().writeValueAsString(users));	
	}

}
