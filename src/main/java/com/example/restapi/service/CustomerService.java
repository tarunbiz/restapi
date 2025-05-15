package com.example.restapi.service;

import com.example.restapi.dto.CustomerInput;
import com.example.restapi.dto.CustomerOutput;
import com.example.restapi.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public CustomerOutput mapOutput(Customer customer) {
        return CustomerOutput.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .message("Customer Saved")
                .build();
    }

    public Customer mapCustomer(CustomerInput customerInput) {
        return Customer.builder()
                .id(customerInput.getId())
                .name(customerInput.getName())
                .email(customerInput.getEmail())
                .build();
    }

}
