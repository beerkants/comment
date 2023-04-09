package com.example.demo.business.responses.userResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOneUsersResponse {


    private String name;
    private String surName;
    private String userName;
    
}
