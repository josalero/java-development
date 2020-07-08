package com.josalero.articles.springwiremockendpointtest.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

public final class FakeDataGenerator 
{
	private final static Faker faker = new Faker();
	
	private final static ObjectMapper mapper = new ObjectMapper();
	
	private static String writersAsJSON;
	
	public final static Writer getFakeWriter()
	{
		List<Article> articles = IntStream.range(0, 5).boxed().map(i -> getFakeArticle()).collect(Collectors.toList());
		
		return new Writer(faker.number().randomDigitNotZero(), faker.book().author(), articles);
	}
	
	public final static Article getFakeArticle()
	{
		List<String> metadataKeys = IntStream.range(0, 5).boxed().map(i -> faker.university().name()).collect(Collectors.toList());
		
		return new Article(faker.number().randomDigitNotZero(), faker.book().title(), metadataKeys, metadataKeys.stream().collect(Collectors.joining(";", "[", "]")));
	}
	
	public final static String getFakeWritersAsJSON(int numberOfWriters) throws JsonProcessingException 
	{
		if (!Optional.ofNullable(writersAsJSON).isPresent()) 
		{
			List<Writer> writers = IntStream.range(0, numberOfWriters).boxed().map(i -> getFakeWriter()).collect(Collectors.toList());
			writersAsJSON = mapper.writeValueAsString(writers);
		}
		
		return writersAsJSON;
	}

}
