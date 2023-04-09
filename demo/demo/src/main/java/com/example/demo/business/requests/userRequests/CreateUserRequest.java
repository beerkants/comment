package com.example.demo.business.requests.userRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    @NotEmpty
    @NotNull
    @NotBlank
    private String name;
    @NotEmpty
    @NotNull
    @NotBlank
    private String surName;
    @NotEmpty
    @NotNull
    @NotBlank
    private String email;
    @NotEmpty
    @NotNull
    @NotBlank
    private String userName;
    @NotEmpty
    @NotNull
    @NotBlank
    private String passwd;
}
