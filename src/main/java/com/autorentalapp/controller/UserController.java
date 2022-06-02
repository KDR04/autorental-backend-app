package com.autorentalapp.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.autorentalapp.models.User;
import com.autorentalapp.service.UserService;

@CrossOrigin
@Controller
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		// TODO Auto-generated constructor stub
		this.userService = userService;
	}
	
	@GetMapping("v1/getUsers")
	public  ResponseEntity<List<User>> getAllUsers() {
		System.out.println("comes here");
		List<User> users = userService.getAllUsers();
		System.out.println(users.size() + " in controller layer");
		ResponseEntity<List<User>> resp = new ResponseEntity<>(users, HttpStatus.OK);
		
		return resp;
	}
	
	@PostMapping("v1/registerUser")
	public  ResponseEntity<User> registerUser(@RequestBody User user) {
		System.out.println("comes here in post");
		System.out.println(user.toString());
		User userOutput = userService.registerUser(user);
		if (Objects.nonNull(userOutput)) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("v1/userLogin")
	public  ResponseEntity<Boolean> userLogin(@RequestBody User user) {
		System.out.println("comes here in login post");
//		System.out.println(user.toString());
		Boolean userOutput = userService.userLogin(user);
		if (Objects.nonNull(userOutput)) {
			return new ResponseEntity<>(userOutput, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
