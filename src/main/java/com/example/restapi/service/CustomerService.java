package com.example.restapi.service;

import com.example.restapi.dto.CustomerInput;
import com.example.restapi.dto.CustomerOutput;
import com.example.restapi.model.Customer;
import com.example.restapi.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<CustomerOutput> getCustomerById(int id) {
        return customerRepository.findById(id)
                .map(this::mapOutput);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

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
