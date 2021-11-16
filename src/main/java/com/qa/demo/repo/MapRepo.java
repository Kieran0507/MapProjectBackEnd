package com.qa.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.domain.Map;

@Repository
public interface MapRepo extends JpaRepository<Map, Long>{

	

}
