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

import com.ev.emsystem.dto.EventHall;
import com.ev.emsystem.service.EventHallService;
import com.ev.emsystem.util.ResponseStructure;

@RestController
@RequestMapping("eventhall")
public class EventHallController {

	@Autowired
	private EventHallService service;

	@PostMapping
	public ResponseEntity<ResponseStructure<EventHall>> saveEventHall(@RequestBody EventHall eventHall) {
		return service.saveEventHall(eventHall);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<EventHall>> updateEventHall(@RequestBody EventHall eventHall) {
		return service.updateEventHall(eventHall);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<EventHall>> getEventHallById(@RequestParam int id) {
		return service.getEventHallById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<EventHall>> deleteEventHallById(@PathVariable int id) {
		return service.deleteEventHallById(id);
	}

}
