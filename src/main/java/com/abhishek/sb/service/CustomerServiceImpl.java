package com.abhishek.sb.service;

import com.abhishek.sb.domain.CustomerDomain;
import com.abhishek.sb.entities.Customer;
import com.abhishek.sb.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public Customer createCustomer(CustomerDomain customerDomain) {
       Customer customer = new Customer();
       customer.setName(customerDomain.getName());
       customer.setAge(customerDomain.getAge());

       customer = customerRepo.save(customer);

       return customer;
}

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Collection<Customer> findAll() {
        return (Collection<Customer>) customerRepo.findAll();

    }

    @Override
    public Customer findOne(Long customerId) {
        return customerRepo.findOne(customerId);
    }
}
