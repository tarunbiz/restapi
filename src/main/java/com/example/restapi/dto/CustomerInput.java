package com.example.restapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerInput {

//    @NotNull(message = "Id must be supplied")
    private int id;
    @NotBlank(message = "Must not be blank")
    private String name;
    @Email(message = "Must be valid email format")
    private String email;

}
