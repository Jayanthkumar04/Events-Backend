package com.jay.sessions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.sessions.entity.Role;
import com.jay.sessions.entity.User;
import com.jay.sessions.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepo repo;
	
	
	@Override
	public User addUser(User user) {
		
		if(user == null) throw new RuntimeException("user is null");
		
		repo.save(user);
		
		return user;
		
	}

	@Override
	public User updateUser(User user) {
		
		 if (user == null || user.getUserId() == null) {
		        throw new RuntimeException("User or User ID is null");
		    }

		    User existingUser = repo.findById(user.getUserId())
		            .orElseThrow(() -> new RuntimeException("User not found"));

		    if (user.getName() != null) {
		        existingUser.setName(user.getName());
		    }

		    if (user.getContactNumber() != null) {
		        existingUser.setContactNumber(user.getContactNumber());
		    }

		    if (user.getEmailId() != null) {
		        existingUser.setEmailId(user.getEmailId());
		    }

		    if (user.getRole() != null) {
		        existingUser.setRole(user.getRole());
		    }

		    return repo.save(existingUser);
		
		
	}

	@Override
	public void deleteUser(Long userId) {
		 if (!repo.existsById(userId)) {
		        throw new RuntimeException("User not found");
		    }
		    repo.deleteById(userId);
	}

	@Override
	public User getUserById(Long userId) {
		return repo.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));
	}

	@Override
	public User changeRole(Long userId, Role role) {
		User user = getUserById(userId);
	    user.setRole(role);
	    return repo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
	
		  return repo.findAll();
	}

	
	
}
