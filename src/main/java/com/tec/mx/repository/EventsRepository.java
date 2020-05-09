package com.tec.mx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tec.mx.entity.Event;


@Repository
public interface EventsRepository extends JpaRepository<Event, Long> {

}