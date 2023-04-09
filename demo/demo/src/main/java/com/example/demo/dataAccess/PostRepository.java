package com.example.demo.dataAccess;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Post;
import com.example.demo.entities.User;


public interface PostRepository extends JpaRepository<Post,Long>{
    boolean existsById(Long id);
    List<Post> findAllByUserEquals(User user);
    
}
