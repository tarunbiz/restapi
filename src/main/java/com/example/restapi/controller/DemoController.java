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

    private final CustomerService customerService;

    public DemoController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerOutput> getCustomer(@PathVariable int id) {

        return customerService.getCustomerById(id)
                .map(customerOutput -> ResponseEntity.status(HttpStatus.OK).body(customerOutput))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());

//        return ResponseEntity.status(HttpStatus.OK).body(customerOutput);
    }

    @PostMapping
    public ResponseEntity<?> saveCustomer(@Valid @RequestBody CustomerInput customerInput) {

        Customer customer = customerService.mapCustomer(customerInput);
        Customer customerSaved = customerService.saveCustomer(customer);
        CustomerOutput customerOutput = customerService.mapOutput(customerSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(customerOutput);
    }
}
