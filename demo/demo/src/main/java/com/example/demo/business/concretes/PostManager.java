package com.example.demo.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.PostService;
import com.example.demo.business.abstracts.UserService;
import com.example.demo.business.requests.postRequests.CreatePostRequest;
import com.example.demo.business.responses.postResponses.GetAllPostsResponse;
import com.example.demo.business.responses.postResponses.GetOnePostResponse;
import com.example.demo.business.rules.UserBusinessRules;
import com.example.demo.core.utilities.mappers.modelMapper.ModelMapperService;
import com.example.demo.dataAccess.PostRepository;
import com.example.demo.dataAccess.UserRepository;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostManager implements PostService {

    private PostRepository postRepository;
    private ModelMapperService modelMapperService;
    private UserBusinessRules userBusinessRules;
    private UserService userService;
    private UserRepository userRepository;
    @Override
    public String createPost(CreatePostRequest request ) {
        userBusinessRules.checkIfExistsId(request.getUserId());

        Post post = this.modelMapperService.forRequest().map(request,Post.class);
        this.postRepository.save(post);
        return request.getPostContent();
    }

    @Override
    public List<GetAllPostsResponse> getAllPosts(Long userId) {
        if(Objects.nonNull(userId)) {
            userBusinessRules.checkIfExistsId(userId);
            User user = this.userRepository.findById(userId).get();
            System.out.println(user.getName());
            Long id = userId;
            List<Post> posts = this.postRepository.findAllByUserEquals(user);
            List<GetAllPostsResponse> response = posts.stream().map(post-> this.modelMapperService.forResponse()
                .map(post,GetAllPostsResponse.class)).toList();
            return response;
        }
        List<Post> posts = this.postRepository.findAll();
        List<GetAllPostsResponse> response = posts.stream()
            .map(post-> this.modelMapperService.forResponse().map(post,GetAllPostsResponse.class)).toList();
        
        return response;
    }

    @Override
    public GetOnePostResponse getOnePost(Long id) {
        
        Post post = this.postRepository.findById(id).get();
        GetOnePostResponse response = this.modelMapperService.forResponse().map(post, GetOnePostResponse.class);
        return response;
    }
    
}
