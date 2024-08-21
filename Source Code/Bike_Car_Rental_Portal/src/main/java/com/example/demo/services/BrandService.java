package com.example.demo.services;

import com.example.demo.entities.Brand;
import com.example.demo.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Brand saveBrand(Brand brand) {
        return brandRepository.save(brand);
    }
}
