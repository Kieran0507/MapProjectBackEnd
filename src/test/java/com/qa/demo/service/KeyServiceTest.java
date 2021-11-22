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

import com.qa.demo.domain.DoorKey;
import com.qa.demo.domain.Map;
import com.qa.demo.repo.DoorKeyRepo;

@SpringBootTest
@ActiveProfiles("Test")
public class KeyServiceTest {

	@MockBean
	private DoorKeyRepo repo;
	
	@Autowired
	private DoorKeyService service;
	
	private DoorKey key = new DoorKey("Marked Room", false, new Map(1l,"Customs"));
	private DoorKey idKey = new DoorKey(1l, "Marked Room", false, new Map(1l,"Customs"));
	
	@Test
	void createTest() {
		Mockito.when(this.repo.saveAndFlush(key)).thenReturn(idKey);
		
		assertEquals(idKey, this.service.create(key));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(key);
	}
	@Test
	void viewAllTest() {
		List<DoorKey> keys = new ArrayList<DoorKey>();
		keys.add(idKey);
		
		Mockito.when(this.repo.findAll()).thenReturn(keys);
		
		assertEquals(keys, this.service.viewAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
		
	}
	@Test
	void viewByIdTest() {
		Optional<DoorKey> output = Optional.of(idKey);
		Mockito.when(this.repo.findById(1l)).thenReturn(output);
		
		assertEquals(idKey, this.service.viewById(1l));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1l);
	}
	@Test
	void updateTest() {
		Optional<DoorKey> output = Optional.of(idKey);
		Mockito.when(this.repo.findById(1l)).thenReturn(output);
		Mockito.when(this.repo.saveAndFlush(idKey)).thenReturn(idKey);
		
		assertEquals(idKey, this.service.update(1l, key));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1l);
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(idKey);
	}
	@Test
	void deleteTest() {
		Long input = 1l;
		
		
		Mockito.when(this.repo.existsById(input)).thenReturn(false);
		
		assertTrue(this.service.delete(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(input);
	}

}
