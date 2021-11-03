package com.prepavenger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prepavenger.entities.ArrayClass;

public interface ArrayRepo extends JpaRepository<ArrayClass, Integer> {
	
	
}
