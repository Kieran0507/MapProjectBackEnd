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

import com.qa.demo.domain.Map;
import com.qa.demo.service.MapService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

@ActiveProfiles("Test")
public class MapControllerUnitTest {

	@Autowired
	private MapController controller;
	
	@MockBean
	private MapService service;
	
	Map oMap = new Map("Customs");
	Map idMap = new Map(1l, "Customs");
	
	@Test
	void testCreate(){

		
		Mockito.when(this.service.create(oMap)).thenReturn(idMap);
		
		assertEquals(this.controller.create(oMap),new ResponseEntity<Map>(idMap, HttpStatus.CREATED));
		
		
	}

	@Test
	void testViewById()  {
		
		
		Mockito.when(this.service.viewById(1l)).thenReturn(idMap);
		assertEquals(this.controller.viewById(1l), new ResponseEntity<Map>(idMap, HttpStatus.ACCEPTED));
	}
	@Test
	void testViewAll()  {
		List<Map> map = new ArrayList<Map>();
		map.add(idMap);
		
		
		Mockito.when(this.service.viewAll()).thenReturn(map);
		assertEquals(this.controller.viewAll(), new ResponseEntity<List<Map>>(map, HttpStatus.OK));
		
	}
	@Test
	void testUpdate()  {
		Map map = new Map(1l,"interchange");
		
		
		Mockito.when(this.service.update(1l, map)).thenReturn(map);
		assertEquals(this.controller.update(1l, map), new ResponseEntity<Map>(map, HttpStatus.ACCEPTED));
	}
	@Test
	void testDelete()  {
		Mockito.when(this.service.delete(1l)).thenReturn(true);
		assertEquals(this.controller.delete(1l), new ResponseEntity<Map>(HttpStatus.NO_CONTENT));
	}
}
