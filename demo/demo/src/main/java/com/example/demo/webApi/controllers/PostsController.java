package com.example.demo.webApi.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.PostService;
import com.example.demo.business.requests.postRequests.CreatePostRequest;
import com.example.demo.business.responses.postResponses.GetAllPostsResponse;
import com.example.demo.business.responses.postResponses.GetOnePostResponse;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
public class PostsController {

    private PostService postService;

    @PostMapping
    public String createPost(@RequestBody CreatePostRequest request) {
        return this.postService.createPost(request);
    }
    @GetMapping
    public List<GetAllPostsResponse> getAllPosts(@Nullable @RequestParam Long userId) {
        return this.postService.getAllPosts(userId);
    }
    @GetMapping("/{id}")
    public GetOnePostResponse getOnePost(@PathVariable Long id) {
        return this.postService.getOnePost(id);
    }
    
}
