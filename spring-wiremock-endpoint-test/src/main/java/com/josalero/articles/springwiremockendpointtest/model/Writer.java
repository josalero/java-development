package com.josalero.articles.springwiremockendpointtest.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Writer 
{
	@Getter 
	@Setter
	@EqualsAndHashCode.Exclude
	private Integer id;	
	
	@Getter 
	@Setter
	@NonNull
	private String name;
	
	@Getter 
	@Setter
	@NonNull
	private List<Article> articles;
	
}
