package com.ev.emsystem.controller;

import javax.websocket.server.PathParam;

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

import com.ev.emsystem.dto.Ticket;
import com.ev.emsystem.service.TicketService;
import com.ev.emsystem.util.ResponseStructure;



@RestController
@RequestMapping("ticket")
public class TicketControlller {

	@Autowired
	private TicketService ticketService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(@RequestBody Ticket ticket) {

		return ticketService.saveTicket(ticket);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(@RequestBody Ticket ticket) {

		return ticketService.updateTicketById(ticket);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<Ticket>> getTicketByid(@RequestParam int id) {

		return ticketService.getTicketById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicketById(@PathVariable int id) {

		return ticketService.deleteTicketById(id);

	}

}
