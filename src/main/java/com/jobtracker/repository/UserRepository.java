package com.jobtracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobtracker.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Repository methods for User entity


    Optional<User> findByUsername(String username);
    

    

    }


