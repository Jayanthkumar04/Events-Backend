package com.jay.sessions.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.sessions.entity.Event;

public interface EventRepo extends JpaRepository<Event,Long> {

	
	
}
