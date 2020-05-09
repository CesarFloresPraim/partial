package com.tec.mx.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="event")
public class Event {
	@Id @GeneratedValue
	@PositiveOrZero(message = "Id must be greater or equal to 0")
	private long id;
	
	@NotBlank(message = "Title is mandatory")
	private String title;
	
	@Size(min = 10, max = 100, message = "Description has to be breif, no more than 100 characters")
	private String description;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate start;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate end;

	public Event() {}
	
	public Event(final long id, final String title, final String description, final LocalDate start, final LocalDate end) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.end = end;
		this.start = start;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}


}
