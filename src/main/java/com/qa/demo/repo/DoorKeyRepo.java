package com.qa.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.demo.domain.DoorKey;

@Repository
public interface DoorKeyRepo extends JpaRepository<DoorKey, Long>{

	

}
