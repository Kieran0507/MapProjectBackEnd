package com.qa.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.demo.domain.Map;
import com.qa.demo.repo.MapRepo;

@SpringBootTest
@ActiveProfiles("Test")
public class MapServiceTest {

	@MockBean
	private MapRepo repo;
	
	@Autowired
	private MapService service;
	
	private Map map = new Map("Customs");
	private Map idMap = new Map(1l, "Customs");
	
	
	@Test
	void createTest() {
		Mockito.when(this.repo.saveAndFlush(map)).thenReturn(idMap);
		
		assertEquals(idMap, this.service.create(map));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(map);
	}
	@Test
	void viewAllTest() {
		List<Map> maps = new ArrayList<Map>();
		maps.add(idMap);
		
		Mockito.when(this.repo.findAll()).thenReturn(maps);
		
		assertEquals(maps, this.service.viewAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
		
	}
	@Test
	void viewByIdTest() {
		Optional<Map> output = Optional.of(idMap);
		Mockito.when(this.repo.findById(1l)).thenReturn(output);
		
		assertEquals(idMap, this.service.viewById(1l));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1l);
	}
	@Test
	void updateTest() {
		Optional<Map> output = Optional.of(idMap);
		Mockito.when(this.repo.findById(1l)).thenReturn(output);
		Mockito.when(this.repo.saveAndFlush(idMap)).thenReturn(idMap);
		
		assertEquals(idMap, this.service.update(1l, map));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1l);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(idMap);
	}
	
	@Test
	public void deleteTest() {
		Long input = 1l;
		
		
		Mockito.when(this.repo.existsById(input)).thenReturn(false);
		
		assertTrue(this.service.delete(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(input);
	}

}
