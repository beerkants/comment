package com.example.demo.business.responses.postResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOnePostResponse {


    private Long id;
    private String postContent;
    private Long userId;
    
}
