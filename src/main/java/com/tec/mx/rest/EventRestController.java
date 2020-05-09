package com.tec.mx.rest;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tec.mx.entity.Event;
import com.tec.mx.repository.EventsRepository;

@RestController
public class EventRestController {
	
	@Resource
	private EventsRepository eventsRepository;
	
	@PostMapping("/api/events")
	public ResponseEntity<Object> newEvent(@Valid @RequestBody Event newEvent, Errors errors) {
		if (errors.hasErrors()) {
	        return new ResponseEntity<Object>("Missing mandatory field", HttpStatus.BAD_REQUEST);
		}
	    Event eventInfo = eventsRepository.save(newEvent);
		return new ResponseEntity<Object>(eventInfo, HttpStatus.OK);
	}
	
	@GetMapping("/api/events/{id}")
	public ResponseEntity<Object> getEventById(@PathVariable(value = "id") 
							@PositiveOrZero(message = "Id must be greater or equal to 0") Long id) {
		if (id <= 0) {
	        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		Optional<Event> eventFound = eventsRepository.findById(id);
		
	    return new ResponseEntity<Object>(eventFound, HttpStatus.OK);
		
	}	
	
}
