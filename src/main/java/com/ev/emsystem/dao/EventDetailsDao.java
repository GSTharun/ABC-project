package com.ev.emsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ev.emsystem.dto.EventDetails;
import com.ev.emsystem.repository.EventDetailsRepository;

@Repository
public class EventDetailsDao {
	@Autowired
	private EventDetailsRepository repository;

	public EventDetails saveEventDetails(EventDetails eventDetails) {
		return repository.save(eventDetails);
	}

	public EventDetails updateEventDetails(EventDetails eventDetails) {
		return repository.save(eventDetails);
	}

	public Optional<EventDetails> getEventDetailsById(int id) {
		return repository.findById(id);
	}

	public void deleteEventDetails(EventDetails eventDetails) {
		repository.delete(eventDetails);
	}
}
