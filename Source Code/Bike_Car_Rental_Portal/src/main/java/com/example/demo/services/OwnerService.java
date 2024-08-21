package com.example.demo.services;

import com.example.demo.entities.Owner;
import com.example.demo.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    // Add this method to find an owner by userId
    public Optional<Owner> getOwnerByUserId(int userId) {
        return ownerRepository.findAll().stream()
                .filter(owner -> owner.getUser().getUserId() == userId)
                .findFirst();
    }
}
