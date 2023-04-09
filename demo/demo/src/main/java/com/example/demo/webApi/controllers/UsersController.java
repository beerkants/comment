package com.example.demo.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.business.requests.userRequests.CreateUserRequest;
import com.example.demo.business.requests.userRequests.UpdateUserRequest;
import com.example.demo.business.responses.userResponses.GetAllUsersResponse;
import com.example.demo.business.responses.userResponses.GetOneUsersResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    private UserService userService;

    @PostMapping
    public String createUser(@RequestBody CreateUserRequest request) {
        return this.userService.createUser(request);
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return this.userService.deleteUser(id);
    }

    @GetMapping
    public List<GetAllUsersResponse> getAllUsers() {
        return this.userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public GetOneUsersResponse getByIdUser(@PathVariable Long id) {
        return this.userService.getById(id);
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id,@RequestBody UpdateUserRequest request) {
        return this.userService.updateUser(id, request);
    }

    
}
