package com.josalero.articles.apachecamelchooseexample.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Users 
{

	private List<User> users;

	@JsonCreator
	public Users(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUsers() 
	{
		return users;
	}
	
}
