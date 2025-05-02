package com.register.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.model.User;

public interface RegisterRepository extends JpaRepository<User, Long> {
    
    public User findByEmail(String email);
    
}