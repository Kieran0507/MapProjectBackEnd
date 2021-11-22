package com.qa.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.domain.DoorKey;
import com.qa.demo.exceptions.KeyNotFoundException;
import com.qa.demo.repo.DoorKeyRepo;

@Service
public class DoorKeyService {

	private DoorKeyRepo repo;
	
	public DoorKeyService(DoorKeyRepo repo) {


		super(); 


		this.repo = repo;
	}
	
	
	public DoorKey create(DoorKey key) {
		return this.repo.saveAndFlush(key);
	}
	
	public List<DoorKey> viewAll(){
		return this.repo.findAll();
	}
	
	public DoorKey viewById(Long id) {
		return this.repo.findById(id).orElseThrow(KeyNotFoundException::new);
	}
	
	public DoorKey update(Long id, DoorKey key) {
		DoorKey exist = this.repo.findById(id).get();
		exist.setName(key.getName());
		exist.setKeycard(key.isKeycard());
		exist.setMap(key.getMap());
		
		return this.repo.saveAndFlush(exist);
	}
	
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
