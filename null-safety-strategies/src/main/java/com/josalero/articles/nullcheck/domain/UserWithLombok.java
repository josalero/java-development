package com.josalero.articles.nullcheck.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
public class UserWithLombok 
{

	@Getter 
	@Setter
	@NonNull
	private Long id;	
	
	@Getter 
	@Setter
	@NonNull
	private String name;
}
