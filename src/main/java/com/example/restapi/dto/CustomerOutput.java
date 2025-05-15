package com.example.restapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerOutput {

    private int id;
    private String name;
    private String email;
    private String message;

}
