package com.jay.sessions.service;

import java.util.List;

import com.jay.sessions.entity.Event;

public interface EventService {

	
	public Event addEvent(Event event,Long userId);
	
	public Event updateEvent(Event event);
	
	public void cancelEvent(Long eventId);
	
	public List<Event> showAllEvents();
	
	public Event showEventById(Long eventId);
	
}
