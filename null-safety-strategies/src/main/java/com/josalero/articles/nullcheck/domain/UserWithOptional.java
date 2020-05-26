package com.josalero.articles.nullcheck.domain;

import java.util.Optional;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserWithOptional 
{

	@Getter 
	private Long id;	
	
	@Getter 
	private String name;
	
	public void setId(Long id) 
	{
		Optional.ofNullable(id).orElseThrow(() -> new NoDataProvidedException("Id was not provided"));
		this.id = id;
	}
	
	public void setName(String name) 
	{
		Optional.ofNullable(id).orElseThrow(() -> new NoDataProvidedException("Name was not provided"));
		this.name = name;
	}
}
