package com.ev.emsystem.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ev.emsystem.dto.Admin;
import com.ev.emsystem.repository.AdminRepository;


class AdminControllerTest {
	
	@Autowired
	private AdminRepository adminRepository;

	@Test
	@Order(1)
	void testSaveAdmin() {
		
		Admin admin = new Admin();
		admin.setAdminid(2);
		admin.setName("mahesh");
		admin.setEmail("maaa@gmail.com");
		admin.setPassword("444");
		admin.setPhoneno(777);
		adminRepository.save(admin);
		assertNotNull(adminRepository.findById(2));
		
		
	}

	@Test
	@Order(2)
	void testUpdateAdmin() {
		Admin admin = adminRepository.findById(1).get();
		admin.setName("tharun");
		admin.setEmail("tha@gmail.com");
		admin.setPassword("1Yygfghdus");
		adminRepository.save(admin);
		assertNotNull(adminRepository.findById(2));
	}

	@Test
	@Order(3)
	void testGetAdminById() {
		assertNotNull(adminRepository.findById(2));
		
	}

	@Test
	@Order(4)
	void testDeleteAdminById() {
		adminRepository.deleteById(2);
	}

}
