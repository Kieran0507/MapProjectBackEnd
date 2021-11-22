package com.qa.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.demo.domain.DoorKey;
import com.qa.demo.domain.Map;
import com.qa.demo.service.DoorKeyService;

@CrossOrigin

@RestController
@RequestMapping("/key")
public class DoorKeyController {

	private DoorKeyService service;

	public DoorKeyController(DoorKeyService service) {
		
		this.service = service;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<DoorKey> create(@RequestBody DoorKey key){
		System.out.println(key.getMap());
		System.out.println(key);
		return new ResponseEntity<DoorKey>(this.service.create(key), HttpStatus.CREATED);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<DoorKey>> viewAll(){
		return new ResponseEntity<List<DoorKey>>(this.service.viewAll(), HttpStatus.OK);
	}
	
	@GetMapping("/viewById/{id}")
	public ResponseEntity<DoorKey> viewById(@PathVariable Long id){
		return new ResponseEntity<DoorKey>(this.service.viewById(id), HttpStatus.ACCEPTED);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<DoorKey> update(@PathVariable Long id,@RequestBody DoorKey key) {
		return new ResponseEntity<DoorKey>(this.service.update(id, key), HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map> delete(@PathVariable Long id) {
		return (this.service.delete(id)) ? new ResponseEntity<Map>(HttpStatus.NO_CONTENT) : new ResponseEntity<Map>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	

}
