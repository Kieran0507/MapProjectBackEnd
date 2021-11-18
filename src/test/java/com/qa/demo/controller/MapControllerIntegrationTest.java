package com.qa.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.domain.Map;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("Test")
@Sql(scripts = {"classpath:MapProject-schema.sql","classpath:MapProject-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class MapControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Map map = new Map("labs");
		String mapAsJSON = this.mapper.writeValueAsString(map);
		RequestBuilder request = post("/map/create").contentType(MediaType.APPLICATION_JSON).content(mapAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Map mapSaved = new Map(2l, "labs");
		String mapSavedAsJSON = this.mapper.writeValueAsString(mapSaved);
		
		ResultMatcher checkBody = content().json(mapSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	@Test
	void testCreate2() throws Exception {
		Map map = new Map("labs");
		String mapAsJSON = this.mapper.writeValueAsString(map);
		RequestBuilder request = post("/map/create").contentType(MediaType.APPLICATION_JSON).content(mapAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Map mapSaved = new Map(2l, "labs");
		String mapSavedAsJSON = this.mapper.writeValueAsString(mapSaved);
		
		ResultMatcher checkBody = content().json(mapSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testViewById() throws Exception {
		Map map = new Map(1l, "customs");
		String mapAsJSON = this.mapper.writeValueAsString(map);
		RequestBuilder request = get("/map/viewById/1");
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(mapAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	@Test
	void testViewAll() throws Exception {
		List<Map> map = new ArrayList<Map>();
		map.add(new Map(1l,"customs"));
		String mapAsJSON = this.mapper.writeValueAsString(map);
		RequestBuilder request = get("/map/viewAll");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(mapAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
	}
	@Test
	void testUpdate() throws Exception {
		Map map = new Map(1l,"interchange");
		String mapAsJSON = this.mapper.writeValueAsString(map);
		RequestBuilder request = put("/map/update/1").contentType(MediaType.APPLICATION_JSON).content(mapAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		Map mapSaved = new Map(1l, "interchange");
		String mapSavedAsJSON = this.mapper.writeValueAsString(mapSaved);
		
		ResultMatcher checkBody = content().json(mapSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	

}
