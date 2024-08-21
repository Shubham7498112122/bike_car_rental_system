package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> getCustomerById(int customerId) {
        return customerRepository.findById(customerId);
    }
    public Customer getCustomerByUserId(int userId) {
        return customerRepository.findByLoginUserId(userId);
    }
}
