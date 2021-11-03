package com.prepavenger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prepavenger.entities.GraphClass;

public interface GraphRepo  extends JpaRepository<GraphClass, Integer>{

}
