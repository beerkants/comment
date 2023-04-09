package com.example.demo.business.abstracts;

import com.example.demo.business.requests.userRequests.CreateUserRequest;
import com.example.demo.business.requests.userRequests.UpdateUserRequest;
import com.example.demo.business.responses.userResponses.GetAllUsersResponse;
import com.example.demo.business.responses.userResponses.GetOneUsersResponse;

import java.util.List;

public interface UserService {


    String createUser(CreateUserRequest request);
    String deleteUser(Long id);
    List<GetAllUsersResponse> getAllUsers();
    GetOneUsersResponse getById(Long id);
    String updateUser(Long id,UpdateUserRequest request);

    
}
