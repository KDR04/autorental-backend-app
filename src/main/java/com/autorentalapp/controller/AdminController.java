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

import com.autorentalapp.models.Admins;
import com.autorentalapp.service.AdminService;

@CrossOrigin
@Controller
public class AdminController {
	
	
	private AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
	@PostMapping("v1/adminLogin")
	public  ResponseEntity<Boolean> adminLogin(@RequestBody Admins admin) {
		System.out.println("comes here in admin post");
		System.out.println(admin.toString());
		Boolean userOutput = adminService.adminLogin(admin);
		if (Objects.nonNull(userOutput)) {
			return new ResponseEntity<>(userOutput, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
