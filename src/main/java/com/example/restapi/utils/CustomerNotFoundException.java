package com.example.restapi.utils;

public class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException(String message) {
        super(message);
    }
}
