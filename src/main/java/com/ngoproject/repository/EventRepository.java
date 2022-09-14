package com.ngoproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ngoproject.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

	@Query(value = "SELECT * FROM event where name = ?", nativeQuery = true)
	Event findByName(String name);

	@Query(value = "SELECT * FROM event where allowregistration=?", nativeQuery = true)
	List<Event> findAllevent(String name);

}
