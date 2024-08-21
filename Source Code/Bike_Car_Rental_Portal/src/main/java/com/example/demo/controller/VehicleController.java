package com.example.demo.controller;

import com.example.demo.entities.Vehicle;
import com.example.demo.entities.Model;
import com.example.demo.entities.Owner;
import com.example.demo.entities.Category;
import com.example.demo.services.VehicleService;
import com.example.demo.repositories.ModelRepository;
import com.example.demo.repositories.OwnerRepository;
import com.example.demo.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable int id) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
        if (vehicle.isPresent()) {
            return ResponseEntity.ok(vehicle.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        Model model = modelRepository.findById(vehicle.getModel().getModelId())
                                     .orElseThrow(() -> new RuntimeException("Model not found"));
        Owner owner = ownerRepository.findById(vehicle.getOwner().getOwnerId())
                                     .orElseThrow(() -> new RuntimeException("Owner not found"));
        Category category = categoryRepository.findById(vehicle.getCategory().getCategoryId())
                                              .orElseThrow(() -> new RuntimeException("Category not found"));//three of them should be present

        vehicle.setModel(model);
        vehicle.setOwner(owner);
        vehicle.setCategory(category);

        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok(savedVehicle);
    }

    @GetMapping("/by-model")
    public List<Vehicle> getVehiclesByModelName(@RequestParam String modelName) {
        return vehicleService.getVehiclesByModelName(modelName);
    }
    @GetMapping("/by-owner/{ownerId}")
    public List<Vehicle> getVehiclesByOwnerId(@PathVariable int ownerId) {
        return vehicleService.getVehiclesByOwnerId(ownerId);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicleDetails) {
        Vehicle updatedVehicle = vehicleService.updateVehicle(id, vehicleDetails);
        return ResponseEntity.ok(updatedVehicle);
   }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable int id) {
        vehicleService.deleteVehicleById(id);
        return ResponseEntity.noContent().build();
    }
}
