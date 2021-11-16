package com.qa.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.demo.domain.Map;
import com.qa.demo.exceptions.MapNotFoundException;
import com.qa.demo.repo.MapRepo;

@Service
public class MapService {

	private MapRepo repo;

	public MapService(MapRepo repo) {
		
		this.repo = repo;
	}
	
	public Map create(Map map) {
		return this.repo.saveAndFlush(map);
	}
	
	public List<Map> viewAll(){
		return this.repo.findAll();
	}
	
	public Map viewById(Long id) {
		return this.repo.findById(id).orElseThrow(MapNotFoundException::new);
	}
	
	public Map update(Long id, Map map) {
		Map exist = this.repo.findById(id).get();
		exist.setName(map.getName());
		
		return this.repo.saveAndFlush(exist);
	}
	
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	

}
