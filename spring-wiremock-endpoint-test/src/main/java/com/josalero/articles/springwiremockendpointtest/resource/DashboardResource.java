package com.josalero.articles.springwiremockendpointtest.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.josalero.articles.springwiremockendpointtest.model.Writer;

@RestController
@RequestMapping("/dashboard")
public class DashboardResource 
{
	@Value("${writers.url}")
	private String writersUrl; 
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public DashboardResource(final RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/writers")
	public ResponseEntity<List<Writer>> getWriters()
	{
		ResponseEntity<List<Writer>> writers = restTemplate.exchange(writersUrl,  HttpMethod.GET, null, new ParameterizedTypeReference<List<Writer>>() {
		});
		
		return Optional.ofNullable(writers)
					   .filter(list -> writers.getStatusCode() == HttpStatus.OK)
					   .map(list -> ResponseEntity.ok().body(writers.getBody()))
					   .orElse(ResponseEntity.noContent().build());
	}
	
	@GetMapping("/writers/{id}/articles")
	public ResponseEntity<List<Writer>> getArticlesByWriter(@PathParam("id") Integer writerId)
	{
		@SuppressWarnings("unchecked")
		List<Writer> writers = (List<Writer>)restTemplate.getForEntity(URI.create(writersUrl + "/" + writerId), Writer.class);
		
		return Optional.ofNullable(writers).map(list-> ResponseEntity.ok().body(list)).orElse(ResponseEntity.notFound().build());
	}
}
