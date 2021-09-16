package com.example.appapi.controller;

import com.example.appapi.entity.Customer;
import com.example.appapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public String add(){
        return customerService.add();
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Integer id){
        return customerService.getById();
    }

    @PutMapping("/{id}")
    public String edit(@PathVariable Integer id, @RequestBody Customer customer){
        return customerService.edit(id, customer);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return customerService.delete(id);
    }
}
