package com.prepavenger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prepavenger.entities.GreedyClass;

public interface GreedyRepo extends JpaRepository<GreedyClass, Integer> {

}
