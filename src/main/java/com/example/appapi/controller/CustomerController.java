package com.example.appapi.controller;

import com.example.appapi.entity.Customer;
import com.example.appapi.message.Result;
import com.example.appapi.payload.CustomerDto;
import com.example.appapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /**
     * Creates new customer
     * @param customerDto
     * @return Result
     * receive CustomerDto as json object
     * put validation
     */
    @PostMapping
    public Result add(@Valid @RequestBody CustomerDto customerDto){
        return customerService.add(customerDto);
    }
    /**
     * Returns all the customers
     * @return CUSTOMERS
     */
    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    /**
     * Returns customer by id
     * @param id INTEGER
     * @return CUSTOMER
     */
    @GetMapping("/{id}")
    public Customer getById(@PathVariable Integer id){
        return customerService.getById(id);
    }

    /**
     * Editing the customer by ID
     * @param id
     * @param customerDto
     * @return Result
     * receives ID and CustomerDto as json object from route
     */
    @PutMapping("/{id}")
    public Result edit(@PathVariable Integer id, @RequestBody CustomerDto customerDto){
        return customerService.edit(id, customerDto);
    }

    /**
     * Deleting customer by ID
     * @param id
     * @return Result
     * receives ID from route
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return customerService.delete(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
