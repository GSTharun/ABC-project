package com.ev.emsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ev.emsystem.dto.User;
import com.ev.emsystem.repository.UserRepository;


@Repository
public class UserDao {
	@Autowired
	private UserRepository userRepository;

	
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
		

	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

}