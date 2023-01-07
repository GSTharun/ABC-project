package com.ev.emsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ev.emsystem.dto.Agent;

public interface AgentRepository extends JpaRepository<Agent, Integer> {

}
