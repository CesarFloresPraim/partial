package com.tec.mx.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<Object> newEvent(@Valid @RequestBody Event newEvent) {
		Event eventInfo = eventsRepository.save(newEvent);
		return new ResponseEntity<Object>(eventInfo, HttpStatus.OK);
	}
	
}
