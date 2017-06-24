package com.abhishek.sb.repository;

import com.abhishek.sb.entities.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
