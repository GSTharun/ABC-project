package com.ev.emsystem.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EventHall {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventhallid;
	@NotNull
	private String name;
	@NotNull
	private String location;
	@NotNull
	private long phone;

	@OneToMany
	List<EventDetails> evDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
}
