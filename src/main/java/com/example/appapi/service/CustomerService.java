package com.example.appapi.service;

import com.example.appapi.entity.Customer;
import com.example.appapi.message.Result;
import com.example.appapi.payload.CustomerDto;
import com.example.appapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Creates new customer
     *
     * @param customerDto
     * @return Result
     * receive CustomerDto as json object
     * put validation
     */
    public Result add(CustomerDto customerDto) {
        if (customerRepository.existsByPhoneNumber(customerDto.getPhoneNumber()))
            return new Result("The phone number already exists", false);
        Customer customer = new Customer();
        customer.setFullName(customerDto.getFullName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setAddress(customerDto.getAddress());
        customerRepository.save(customer);
        return new Result("Customer is created", true);
    }

    /**
     * Returns all the customers
     *
     * @return CUSTOMERS
     */
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    /**
     * Returns customer by id
     *
     * @param id INTEGER
     * @return CUSTOMER
     * If there is not any customer with this ID, returns null
     */
    public Customer getById(Integer id) {
        Optional<Customer> customerById = customerRepository.findById(id);
        return customerById.orElse(null);
    }

    /**
     * Editing the customer by ID
     *
     * @param id
     * @param customerDto
     * @return Result
     * receives ID and CustomerDto as json object
     */
    public Result edit(Integer id, CustomerDto customerDto) {
        if (customerRepository.existsByPhoneNumberAndIdNot(customerDto.getPhoneNumber(), id))
            return new Result("The phone number already exists", false);

        Optional<Customer> customerById = customerRepository.findById(id);
        if (!customerById.isPresent())
            return new Result("Customer not found", false);

        Customer customer = customerById.get();
        customer.setFullName(customerDto.getFullName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer.setAddress(customerDto.getAddress());
        customerRepository.save(customer);
        return new Result("Customer is edited successfully", true);
    }

    /**
     * Deleting customer by ID
     * @param id
     * @return Result
     * receives ID from route
     */
    public Result delete(Integer id) {
        Optional<Customer> customerById = customerRepository.findById(id);
        if (!customerById.isPresent())
            return new Result("Customer not found", false);
        customerRepository.deleteById(id);
        return new Result("Customer is deleted", true);
    }
}
