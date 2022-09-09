package com.ngoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngoproject.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

}
