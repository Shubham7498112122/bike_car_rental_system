package com.example.demo.services;

import com.example.demo.entities.Model;
import com.example.demo.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }
    public List<Model> getModelsByName(String modelName) {
        return modelRepository.findByModelNameIgnoreCase(modelName);
    }
}
