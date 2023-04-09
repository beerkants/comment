package com.example.demo.business.requests.userRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {


    private String name;
    private String surName;
    private String userName;
    private String passwd;
    private String email;
    
}
