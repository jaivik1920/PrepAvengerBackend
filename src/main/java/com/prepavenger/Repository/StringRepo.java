package com.prepavenger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prepavenger.entities.StringClass;

public interface StringRepo extends JpaRepository<StringClass, Integer>{

}
