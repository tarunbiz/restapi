package com.example.restapi.controller;

import com.example.restapi.dto.CustomerInput;
import com.example.restapi.dto.CustomerOutput;
import com.example.restapi.model.Customer;
import com.example.restapi.repository.CustomerRepository;
import com.example.restapi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/user")
public class DemoController {

    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    public DemoController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOutput> getCustomer(@PathVariable int id) {

       return customerRepository.findById(id)
        .map(customer -> ResponseEntity.status(HttpStatus.OK)
                .body(customerService.mapOutput(customer)))
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

//        return ResponseEntity.status(HttpStatus.OK).body(customerOutput);
    }

    @PostMapping
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerInput customerInput) {

        Customer customer = customerService.mapCustomer(customerInput);
        Customer customerSaved = customerRepository.save(customer);
        CustomerOutput customerOutput = customerService.mapOutput(customerSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(customerOutput);
    }
}
