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

	private String line1;
	private String line2;
	private String city;
	private String zip;
	
	public Event() {}
	
	public Event(final long id, final String title, final String description, final LocalDate start, final LocalDate end,
			final String line1, final String line2, final String city, final String zip) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.end = end;
		this.start = start;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.zip = zip;
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

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
