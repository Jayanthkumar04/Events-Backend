package com.jay.sessions.service;

import java.util.List;

import com.jay.sessions.entity.Role;
import com.jay.sessions.entity.User;

public interface UserService {

	public User addUser(User user);
	
	
	public User updateUser(User user);
	
	
	public void deleteUser(Long userId);
	
	
	public User getUserById(Long userId);
	
	
	public List<User> getAllUsers();
	
	
	public User changeRole(Long userId,Role role);
	
}
