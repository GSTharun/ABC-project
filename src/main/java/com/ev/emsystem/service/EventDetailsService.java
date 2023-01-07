package com.ev.emsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ev.emsystem.dao.EventDetailsDao;
import com.ev.emsystem.dao.UserDao;
import com.ev.emsystem.dto.EventDetails;
import com.ev.emsystem.dto.User;
import com.ev.emsystem.util.ResponseStructure;

@Service
public class EventDetailsService {
	@Autowired
	private EventDetailsDao evDetailsDao;
	
	@Autowired
	UserDao userDao;

	public ResponseEntity<ResponseStructure<EventDetails>> saveEventDetails(EventDetails eventDetails,int userId) {
		Optional<User> optional=userDao.getUserById(userId);
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		User user2;
		if(optional.isPresent()) {
			user2=optional.get();
		}else {
			user2=null;
		}
		if(user2!=null) {
			user2.getEventDetails().add(eventDetails);
			responseStructure.setStatus(HttpStatus.CREATED.value());
			responseStructure.setMessage("saved");
			responseStructure.setData(evDetailsDao.saveEventDetails(eventDetails));
			userDao.updateUser(user2);
		}else {
			throw null;
		}
		
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<EventDetails>> updateEventDetailsById(EventDetails eventDetails) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		Optional<EventDetails> optional = evDetailsDao.getEventDetailsById(eventDetails.getEventId());
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(evDetailsDao.updateEventDetails(eventDetails));

		} else {
			throw null;
		}
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<EventDetails>> getEventDetailsById(int id) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		Optional<EventDetails> optional = evDetailsDao.getEventDetailsById(id);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("received");
			responseStructure.setData(optional.get());

		} else {
			throw null;
		}
		return responseEntity;

	}

	public ResponseEntity<ResponseStructure<EventDetails>> deleteEventDetailsById(int id) {
		ResponseStructure<EventDetails> responseStructure = new ResponseStructure<EventDetails>();
		ResponseEntity<ResponseStructure<EventDetails>> responseEntity = new ResponseEntity<ResponseStructure<EventDetails>>(
				responseStructure, HttpStatus.OK);
		Optional<EventDetails> optional = evDetailsDao.getEventDetailsById(id);
		if (optional.isPresent()) {
			evDetailsDao.deleteEventDetails(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(optional.get());
			return responseEntity;
		}
		throw null;
	}
}
