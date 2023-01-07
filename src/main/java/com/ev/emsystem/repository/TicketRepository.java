package com.ev.emsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.emsystem.dto.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
