package com.prepavenger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prepavenger.entities.DpClass;

public interface DpRepo extends JpaRepository<DpClass, Integer> {

}
