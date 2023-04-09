package com.example.demo.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.example.demo.business.requests.postRequests.CreatePostRequest;
import com.example.demo.business.responses.postResponses.GetAllPostsResponse;
import com.example.demo.business.responses.postResponses.GetOnePostResponse;

public interface PostService {
    

    String createPost(CreatePostRequest request);
    List<GetAllPostsResponse> getAllPosts(Long userId);
    GetOnePostResponse getOnePost(Long id);

}
