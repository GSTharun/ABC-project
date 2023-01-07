package com.ev.emsystem.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ev.emsystem.dto.Agent;
import com.ev.emsystem.repository.AgentRepository;
import com.google.common.annotations.VisibleForTesting;

@Repository
public class AgentDao {

	@Autowired
	private AgentRepository agentRepository;

	@VisibleForTesting
	public Agent saveAgent(Agent agent) {
		return agentRepository.save(agent);
	}

	public Agent updateAgent(Agent agent) {
		return agentRepository.save(agent);
	}

	public Optional<Agent> getAgentById(int id) {
		return agentRepository.findById(id);
	}

	public void deleteAgent(Agent agent) {
		agentRepository.delete(agent);
	}

}
