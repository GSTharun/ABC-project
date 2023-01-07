package com.ev.emsystem.service;

import java.util.Optional;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ev.emsystem.dao.UserDao;
import com.ev.emsystem.dto.User;
import com.ev.emsystem.util.ResponseStructure;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public static final Logger logger= Logger.getLogger(UserService.class);

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseEntity<ResponseStructure<User>> responseEntity;

		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data saved");
		logger.debug("data saved");
		responseStructure.setData(userDao.saveUser(user));
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.CREATED);

	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		ResponseEntity<ResponseStructure<User>> responseEntity;
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		Optional<User> optional = userDao.getUserById(user.getUserid());
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data updated");
			responseStructure.setData(userDao.saveUser(user));
			logger.info("update");
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);

		}
		throw null;
	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		ResponseEntity<ResponseStructure<User>> responseEntity;
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		Optional<User> optional = userDao.getUserById(id);
		if (optional.isPresent()) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data found");
			responseStructure.setData(optional.get());
			logger.debug("debug user by id ");
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);

		}
		throw null;
	}

	public ResponseEntity<ResponseStructure<User>> deleteUserById(int id) {
		ResponseEntity<ResponseStructure<User>> responseEntity;
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		Optional<User> optional = userDao.getUserById(id);
		if (optional.isPresent()) {
			userDao.deleteUser(optional.get());

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Deleted");
			responseStructure.setData(optional.get());
			logger.warn("data deleted");
			return new ResponseEntity<ResponseStructure<User>>(responseStructure, HttpStatus.OK);
		}

		throw null;
	}

}
