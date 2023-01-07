package com.ev.emsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ev.emsystem.dto.EventDetails;
import com.ev.emsystem.service.EventDetailsService;
import com.ev.emsystem.util.ResponseStructure;


@RestController
@RequestMapping("eventdetails")
public class EventDetailsController {

	@Autowired
	private EventDetailsService evService;


	
	@PostMapping
	public ResponseEntity<ResponseStructure<EventDetails>> saveEventDetails(@RequestBody EventDetails eventDetails,@RequestParam int userId){
		return evService.saveEventDetails(eventDetails,userId);
	}


	@PutMapping
	public ResponseEntity<ResponseStructure<EventDetails>> updateEventDetails(@RequestBody EventDetails eventDetails){
		return evService.updateEventDetailsById(eventDetails);
	}


	@GetMapping
	public ResponseEntity<ResponseStructure<EventDetails>> getEventDetailsById(@RequestParam int id){
		return evService.getEventDetailsById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<EventDetails>> deleteEventDetailsById(@PathVariable int id){
		return evService.deleteEventDetailsById(id);
	}


}
