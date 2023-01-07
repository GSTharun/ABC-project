package com.ev.emsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ev.emsystem.dto.Ticket;
import com.ev.emsystem.repository.TicketRepository;

@Repository
public class TicketDao {

	@Autowired
	private TicketRepository ticketRepository;

	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public Ticket updateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public Optional<Ticket> getTicketById(int id) {
		return ticketRepository.findById(id);
	
	}

	public void deleteTicket(Ticket ticket) {

		ticketRepository.delete(ticket);

	}

}
