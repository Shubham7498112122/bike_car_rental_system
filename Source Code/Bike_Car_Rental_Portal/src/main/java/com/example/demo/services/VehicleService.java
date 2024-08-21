package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.entities.Model;
import com.example.demo.entities.Owner;
import com.example.demo.entities.Vehicle;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ModelRepository;
import com.example.demo.repositories.OwnerRepository;
import com.example.demo.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    
    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> getVehicleById(int id) {
        return vehicleRepository.findById(id);
    }
    public List<Vehicle> getVehiclesByModelName(String modelName) {
        return vehicleRepository.findByModelNameContaining(modelName);
    }
    public List<Vehicle> getVehiclesByOwnerId(int ownerId) {
        return vehicleRepository.findByOwnerOwnerId(ownerId);
    }
    public Vehicle updateVehicle(int id, Vehicle vehicleDetails) {
        // Find the existing vehicle
        Vehicle existingVehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        // Update the fields
        existingVehicle.setBuyingYear(vehicleDetails.getBuyingYear());
        existingVehicle.setRegistrationNumber(vehicleDetails.getRegistrationNumber());

        // Update related entities
        Model model = modelRepository.findById(vehicleDetails.getModel().getModelId())
                                     .orElseThrow(() -> new RuntimeException("Model not found"));
        Owner owner = ownerRepository.findById(vehicleDetails.getOwner().getOwnerId())
                                     .orElseThrow(() -> new RuntimeException("Owner not found"));
        Category category = categoryRepository.findById(vehicleDetails.getCategory().getCategoryId())
                                              .orElseThrow(() -> new RuntimeException("Category not found"));

        existingVehicle.setModel(model);
        existingVehicle.setOwner(owner);
        existingVehicle.setCategory(category);

        // Save the updated vehicle
        return vehicleRepository.save(existingVehicle);
    }
    
    public void deleteVehicleById(int id) {
        Vehicle vehicle = vehicleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vehicle not found with id " + id));
        vehicleRepository.delete(vehicle);
    }
}
