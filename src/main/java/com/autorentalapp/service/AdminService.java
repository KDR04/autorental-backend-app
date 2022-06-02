package com.autorentalapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autorentalapp.models.Admins;
import com.autorentalapp.models.User;
import com.autorentalapp.repository.AdminRepository;
import com.autorentalapp.repository.UserRepository;

@Service
public class AdminService {

	
	@Autowired
	private AdminRepository adminRepo;
	


	public List<Admins> getAllAdmin() {
		return adminRepo.getAllAdmins();
	}
	
	
	public Boolean adminLogin(Admins input) {
		List<Admins> allAdmins = adminRepo.getAllAdmins();
		
		if (allAdmins != null && !allAdmins.isEmpty()) {
			return allAdmins
			.stream()
			.parallel()
			.filter(admin -> admin.getUsername().equals(input.getUsername()) && admin.getPassword().equals(input.getPassword()))
			.findAny()
			.isPresent();
		}
		return Boolean.FALSE;
	}
		

}
