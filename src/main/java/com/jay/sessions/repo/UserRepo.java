package com.jay.sessions.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.sessions.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
