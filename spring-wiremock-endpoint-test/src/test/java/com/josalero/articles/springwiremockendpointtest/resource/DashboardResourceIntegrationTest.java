package com.josalero.articles.springwiremockendpointtest.resource;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.http.entity.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.josalero.articles.springwiremockendpointtest.SpringWiremockEndpointTestApplication;
import com.josalero.articles.springwiremockendpointtest.model.FakeDataGenerator;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = { WireMockInitializer.class }, classes = { TestConfig.class,
		SpringWiremockEndpointTestApplication.class })
@AutoConfigureMockMvc
public class DashboardResourceIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WireMockServer wireMockServer;

	@AfterEach
	public void afterEach() 
	{
		this.wireMockServer.resetAll();
	}

	@Test
	public void getWriters_ValidRequest_ShouldReturnWriters() throws Exception 
	{
		wireMockServer.stubFor(get(WireMock.urlEqualTo("/writers"))
		    .willReturn(aResponse()
		    .withStatus(HttpStatus.OK.value())
		    .withHeader("content-type", "application/json")
		    .withBody(FakeDataGenerator.getFakeWritersAsJSON(3))));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/dashboard/writers").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", Matchers.hasSize(3)));
	}
	
	@Test
	public void getWriters_ValidRequest_ShouldReturnNoWriters() throws Exception 
	{
		wireMockServer.stubFor(get(WireMock.urlEqualTo("/writers"))
		    .willReturn(aResponse()
		    .withStatus(HttpStatus.NO_CONTENT.value())
		    .withHeader("content-type", "application/json")));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/dashboard/writers").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNoContent());
	}

}
