package com.ev.emsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.emsystem.dto.Venue;

public interface VenueRepository extends JpaRepository<Venue, Integer> {

}
