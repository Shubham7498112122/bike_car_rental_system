package com.example.demo.repositories;

import com.example.demo.entities.Vehicle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	@Query("SELECT v FROM Vehicle v WHERE v.model.modelName LIKE %:modelName%")
    List<Vehicle> findByModelNameContaining(@Param("modelName") String modelName);
	List<Vehicle> findByOwnerOwnerId(int ownerId);
}
