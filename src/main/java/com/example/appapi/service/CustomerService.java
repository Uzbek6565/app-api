package com.example.appapi.service;

import com.example.appapi.entity.Customer;
import com.example.appapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String add() {
        return null;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer getById() {
        
    }

    public String edit(Integer id, Customer customer) {
    }

    public String delete(Integer id) {
    }
}
