package com.qa.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.Map;
import com.qa.demo.service.MapService;

@RestController
@RequestMapping("/map")

public class MapController {

	private MapService service;
	
	
	public MapController(MapService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Map> create(@RequestBody Map map){
		return new ResponseEntity<Map>(this.service.create(map), HttpStatus.CREATED);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<Map>> viewAll(){
		return new ResponseEntity<List<Map>>(this.service.viewAll(), HttpStatus.OK);
	}
	
	@GetMapping("/viewById/{id}")
	public ResponseEntity<Map> viewById(@PathVariable Long id){
		return new ResponseEntity<Map>(this.service.viewById(id), HttpStatus.ACCEPTED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Map> update(@PathVariable Long id,@RequestBody Map map) {
		return new ResponseEntity<Map>(this.service.update(id, map), HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map> delete(@PathVariable Long id) {
		return (this.service.delete(id)) ? new ResponseEntity<Map>(HttpStatus.NO_CONTENT) : new ResponseEntity<Map>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
