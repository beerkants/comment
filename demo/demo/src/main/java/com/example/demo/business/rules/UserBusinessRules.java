package com.example.demo.business.rules;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dataAccess.UserRepository;
import com.example.demo.entities.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserBusinessRules {


    private UserRepository userRepository;

    public void checkIfExistsId(Long id) {
        System.out.println("id : " + id);
        if( id < 0 || !userRepository.existsById(id) ) {
            throw new RuntimeException("id bulunamadı");
        }
    }
    public void checkIfExistsUser() {
        List<User> users = this.userRepository.findAll();
        if ( users.size() <= 0 ) {
            throw new RuntimeException("Kullanıcı Bulunamadı.");
        }
    }
    
}
