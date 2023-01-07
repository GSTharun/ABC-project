package com.ev.emsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ev.emsystem.dao.EventHallDao;
import com.ev.emsystem.dto.Address;
import com.ev.emsystem.dto.EventHall;
import com.ev.emsystem.util.ResponseStructure;

@Service
public class EventHallService {

	@Autowired
	private EventHallDao dao;

	Address address;
	public ResponseEntity<ResponseStructure<EventHall>> saveEventHall(EventHall eventHall) {
		ResponseStructure<EventHall> responseStructure = new ResponseStructure<EventHall>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data Saved");
		eventHall.setAddress(address);
		responseStructure.setData(dao.saveEventHall(eventHall));
		return new ResponseEntity<ResponseStructure<EventHall>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<EventHall>> updateEventHall(EventHall eventHall) {
		ResponseStructure<EventHall> responseStructure = new ResponseStructure<EventHall>();
		Optional<EventHall> optional = dao.getEventHallById(eventHall.getEventhallid());
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data Updated");
			responseStructure.setData(dao.updateEventHall(eventHall));
			return new ResponseEntity<ResponseStructure<EventHall>>(responseStructure, HttpStatus.OK);
		}
		throw null;

	}

	public ResponseEntity<ResponseStructure<EventHall>> getEventHallById(int id) {
		ResponseStructure<EventHall> responseStructure = new ResponseStructure<EventHall>();
		Optional<EventHall> optional = dao.getEventHallById(id);
		if (optional.isPresent()) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data Fetched");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<EventHall>>(responseStructure, HttpStatus.OK);
		}
		throw null;

	}

	public ResponseEntity<ResponseStructure<EventHall>> deleteEventHallById(int id) {
		ResponseStructure<EventHall> responseStructure = new ResponseStructure<EventHall>();
		Optional<EventHall> optional = dao.getEventHallById(id);
		if (optional.isPresent()) {
			dao.deleteEventHall(optional.get());
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Data Deleted");
			responseStructure.setData(optional.get());
			return new ResponseEntity<ResponseStructure<EventHall>>(responseStructure, HttpStatus.OK);
		}
		throw null;
	}

}
