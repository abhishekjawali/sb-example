package com.abhishek.sb.controller;

import com.abhishek.sb.domain.CustomerDomain;
import com.abhishek.sb.entities.Customer;
import com.abhishek.sb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<Collection<Customer>> getCustomers() {
        return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{customerId}")
    public ResponseEntity<Customer> findOneCustomer(@PathVariable Long customerId) {
        return new ResponseEntity<>(customerService.findOne(customerId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer>  createCustomer(CustomerDomain customerDomain) {
        Customer customer = null;
        try {
            customer = customerService.createCustomer(customerDomain);
        } catch(Exception e) {
            System.out.println("error in creating customer");
            e.printStackTrace();
        }
        if(null!= customer) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
