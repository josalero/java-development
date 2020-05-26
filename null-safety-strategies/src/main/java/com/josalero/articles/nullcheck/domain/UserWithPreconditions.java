package com.josalero.articles.nullcheck.domain;

import java.util.Objects;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserWithPreconditions 
{

	@Getter 
	private Long id;	
	
	@Getter 
	private String name;

	public void setId(Long id) 
	{
		Objects.requireNonNull(id);
		this.id = id;
	}
	
	public void setName(String name) 
	{
		Objects.requireNonNull(name);
		this.name = name;
	}
	
}
