package com.ev.emsystem.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Agent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int agentid;
	@NotNull
	private String agentname;
	@NotNull
	private String agentemail;
	@NotNull
	private long phone;
	
	@OneToMany(mappedBy = "agent")
	private List<EventDetails> details;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Staff> staffs;

}
