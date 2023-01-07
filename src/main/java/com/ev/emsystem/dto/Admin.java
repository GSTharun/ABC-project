package com.ev.emsystem.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminid;
	@NotNull
	private String name;
	@NotNull
	private long phoneno;
	@NotNull
	private String email;
	@NotNull
	private String password;

	@OneToMany(cascade = CascadeType.ALL)
	private List<EventHall> eventHalls;
}
