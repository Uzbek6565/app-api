package com.example.appapi.repository;

import com.example.appapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByPhoneNumber(Integer phoneNumber);
    boolean existsByPhoneNumberAndIdNot(Integer phoneNumber, Integer id);
}
