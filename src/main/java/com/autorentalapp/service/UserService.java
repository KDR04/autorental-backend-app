package com.autorentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autorentalapp.models.User;
import com.autorentalapp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	


	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	public User registerUser(User user) {
		return userRepository.registerUser(user);
	}
	
	public Boolean userLogin(User input) {
		List<User> allUsers = userRepository.getAllUsers();
		
		if (allUsers != null && !allUsers.isEmpty()) {
			return allUsers
			.stream()
			.parallel()
			.filter(user -> user.getEmail().equals(input.getEmail()) && user.getPassword().equals(input.getPassword()))
			.findAny()
			.isPresent();
		}
		return Boolean.FALSE;
	}
}
