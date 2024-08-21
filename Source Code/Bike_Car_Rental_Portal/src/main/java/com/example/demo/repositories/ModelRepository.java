
package com.example.demo.repositories;

import com.example.demo.entities.Model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
	List<Model> findByModelNameIgnoreCase(String modelName);
}