package com.ev.emsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.emsystem.dto.EventDetails;

public interface EventDetailsRepository extends JpaRepository<EventDetails, Integer> {

}
