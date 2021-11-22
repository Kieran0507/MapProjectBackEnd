package com.qa.demo.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.qa.demo.domain.DoorKey;
import com.qa.demo.domain.Map;
import com.qa.demo.service.DoorKeyService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

@ActiveProfiles("Test")
public class DoorKeyControllerUnitTest {

	@Autowired
	private DoorKeyController controller;
	
	@MockBean
	private DoorKeyService service;
	
	DoorKey key = new DoorKey("Marked Room", false, new Map(1l,"Customs"));
	DoorKey idKey = new DoorKey(1l, "Marked Room", false, new Map(1l,"Customs"));
	
	@Test
	void testCreate() {
		Mockito.when(this.service.create(key)).thenReturn(idKey);
		assertEquals(this.controller.create(key), new ResponseEntity<DoorKey>(idKey , HttpStatus.CREATED)); 
	}
	@Test
	void testViewById() {
		Mockito.when(this.service.update(1l, key)).thenReturn(idKey);
		assertEquals(this.controller.update(1l, key), new ResponseEntity<DoorKey>(idKey, HttpStatus.ACCEPTED));
		
	}
	@Test
	void testViewAll() {
		List<DoorKey> keys = new ArrayList<DoorKey>();
		keys.add(idKey);
		
		Mockito.when(this.service.viewAll()).thenReturn(keys);
		assertEquals(this.controller.viewAll(), new ResponseEntity<List<DoorKey>>(keys, HttpStatus.OK));
	}
	@Test
	void testUpdate() {
		Mockito.when(this.service.update(1l, key)).thenReturn(idKey);
		assertEquals(this.controller.update(1l, key), new ResponseEntity<DoorKey>(idKey, HttpStatus.ACCEPTED));
	}
	@Test
	void testDelete() {
		Mockito.when(this.service.delete(1l)).thenReturn(true);
		assertEquals(this.controller.delete(1l), new ResponseEntity<>(HttpStatus.NO_CONTENT));
	}

}
