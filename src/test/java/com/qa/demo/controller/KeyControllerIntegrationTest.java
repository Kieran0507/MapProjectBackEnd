package com.qa.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import com.qa.demo.domain.DoorKey;
import com.qa.demo.domain.Map;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("Test")
@Sql(scripts = {"classpath:MapProject-schema.sql","classpath:MapProject-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class KeyControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		DoorKey key = new DoorKey("104", false, new Map(1l,"customs"));
		String keyAsJSON = this.mapper.writeValueAsString(key);
		RequestBuilder request = post("/key/create").contentType(MediaType.APPLICATION_JSON).content(keyAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		DoorKey keySaved = new DoorKey(2l,"104", false, new Map(1l,"customs"));
		String keySavedAsJSON = this.mapper.writeValueAsString(keySaved);
		
		ResultMatcher checkBody = content().json(keySavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	@Test
	void testCreate2() throws Exception {
		DoorKey key = new DoorKey("104", false, new Map(1l,"customs"));
		String keyAsJSON = this.mapper.writeValueAsString(key);
		RequestBuilder request = post("/key/create").contentType(MediaType.APPLICATION_JSON).content(keyAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		DoorKey keySaved = new DoorKey(2l,"104", false, new Map(1l,"customs"));
		String keySavedAsJSON = this.mapper.writeValueAsString(keySaved);
		
		ResultMatcher checkBody = content().json(keySavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	@Test
	void testDelete() throws Exception {
		RequestBuilder request = delete("/key/delete/1");
		
		ResultMatcher checkStatus = status().isNoContent();
		
		this.mvc.perform(request).andExpect(checkStatus);
	}
	@Test
	void testViewById() throws Exception {
		DoorKey key = new DoorKey(1l, "marked room", false, new Map(1l,"customs"));
		String keyAsJSON = this.mapper.writeValueAsString(key);
		RequestBuilder request = get("/key/viewById/1");
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(keyAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	@Test
	void testViewAll() throws Exception {
		List<DoorKey> key = new ArrayList<DoorKey>();
		key.add(new DoorKey(1l, "marked room", false, new Map(1l,"customs")));
		String mapAsJSON = this.mapper.writeValueAsString(key);
		RequestBuilder request = get("/key/viewAll");
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(mapAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
		
	}
	@Test
	void testUpdate() throws Exception {
		DoorKey key = new DoorKey(1l, "204", false, new Map(1l,"customs"));
		String keyAsJSON = this.mapper.writeValueAsString(key);
		RequestBuilder request = put("/key/update/1").contentType(MediaType.APPLICATION_JSON).content(keyAsJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		DoorKey keySaved = new DoorKey(1l, "204", false, new Map(1l,"customs"));
		String keySavedAsJSON = this.mapper.writeValueAsString(keySaved);
		
		ResultMatcher checkBody = content().json(keySavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

}
