package com.ev.emsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ev.emsystem.dto.Venue;
import com.ev.emsystem.repository.VenueRepository;

@Repository
public class VenueDao {

	@Autowired
	private VenueRepository repository;

	public Venue saveVenue(Venue venue) {
		return repository.save(venue);
	}

	public Venue updateVenue(Venue venue) {
		return repository.save(venue);
	}

	public Optional<Venue> getVenueById(int id) {
		return repository.findById(id);

	}

	public void deleteVenue(Venue venue) {
		repository.delete(venue);

	}

}
