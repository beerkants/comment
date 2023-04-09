package com.example.demo.business.concretes;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.UserService;
import com.example.demo.business.requests.userRequests.CreateUserRequest;
import com.example.demo.business.requests.userRequests.UpdateUserRequest;
import com.example.demo.business.responses.userResponses.GetAllUsersResponse;
import com.example.demo.business.responses.userResponses.GetOneUsersResponse;
import com.example.demo.business.rules.UserBusinessRules;
import com.example.demo.core.utilities.mappers.modelMapper.ModelMapperService;
import com.example.demo.dataAccess.UserRepository;
import com.example.demo.entities.User;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private UserRepository userRepository;
    private ModelMapperService modelMapperService;
    private UserBusinessRules userBusinessRules;

    @Override
    public String createUser(CreateUserRequest request) {

        User user = this.modelMapperService.forRequest()
        .map(request,User.class);
        this.userRepository.save(user);
        return "Başarılı";
    }
    
    @Override
    public String deleteUser(Long id) {
        
        userBusinessRules.checkIfExistsId(id);
        this.userRepository.deleteById(id);
        return "basarılı";
    }

    @Override
    public List<GetAllUsersResponse> getAllUsers() {
        this.userBusinessRules.checkIfExistsUser();
        List<User> users = this.userRepository.findAll();
        List<GetAllUsersResponse> response = users.stream()
            .map(user-> this.modelMapperService.forResponse()
                .map(user, GetAllUsersResponse.class)).toList();
        return response;
    }

    @Override
    public GetOneUsersResponse getById(Long id) {
        this.userBusinessRules.checkIfExistsId(id);
        User user = this.userRepository.findById(id).get();

        GetOneUsersResponse response = this.modelMapperService.forResponse().map(user,GetOneUsersResponse.class);
        return response;
    }

    @Override
    public String updateUser(Long id, UpdateUserRequest request) {

        userBusinessRules.checkIfExistsId(id);
        User user = this.userRepository.findById(id).get();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPasswd(request.getPasswd());
        user.setSurName(request.getSurName());
        user.setUserName(request.getUserName());
        this.userRepository.save(user);
        return "Güncellendi.";
    }
    
}
