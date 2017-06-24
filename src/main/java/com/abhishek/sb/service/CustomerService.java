package com.abhishek.sb.service;

import com.abhishek.sb.domain.CustomerDomain;
import com.abhishek.sb.entities.Customer;

import java.util.Collection;


public interface CustomerService {

    Collection<Customer> findAll();

    Customer findOne(Long customerId);

    Customer createCustomer(CustomerDomain customerDomain);

}
