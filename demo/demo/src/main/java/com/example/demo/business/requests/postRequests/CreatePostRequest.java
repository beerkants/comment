package com.example.demo.business.requests.postRequests;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {

    @Lob
    @NotEmpty
    @NotNull
    @Size(min = 1)
    private String postContent;

    @NotNull
    private Long userId;
    
}
