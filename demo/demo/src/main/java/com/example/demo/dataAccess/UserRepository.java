package com.example.demo.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    boolean existsById(Long id);
}
