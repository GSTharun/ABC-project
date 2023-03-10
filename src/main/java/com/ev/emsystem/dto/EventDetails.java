package com.ev.emsystem.dto;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class EventDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventId;
	@NotNull
	private String eventTitle;
	@NotNull
	private String address;
	@NotNull
	private String eventDate;
	@NotNull
	private int eventTime;
	@NotNull
	private int duration;
	@NotNull
	private String foodRefreshment;
	@NotNull
	private String equipment;
	@NotNull
	private String entertainment;

	/*
	 * @ManyToOne private User user;
	 */
	
	
	@ManyToOne
	private Agent agent;

	/*
	 * @JsonIgnore
	 * 
	 * @ManyToOne(cascade = CascadeType.ALL) private EventHall evHall;
	 */

}
