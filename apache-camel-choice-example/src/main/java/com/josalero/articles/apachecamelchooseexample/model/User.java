package com.josalero.articles.apachecamelchooseexample.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User 
{
	private final Long id;
	private final String name;

	@JsonCreator
	public User(@JsonProperty("id") Long id, @JsonProperty("name")  String name) 
	{
		this.id = id;
		this.name = name;
	}
	
	public Long getId() 
	{
		return id;
	}
	public String getName() 
	{
		return name;
	}
	
	@Override
	public String toString() {
		
		return String.format("User[id=%s, name=%s]", id, name);
	}

}
