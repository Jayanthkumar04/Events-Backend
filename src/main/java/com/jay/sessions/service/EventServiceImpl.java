package com.jay.sessions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.sessions.entity.Event;
import com.jay.sessions.entity.User;
import com.jay.sessions.repo.EventRepo;
import com.jay.sessions.repo.UserRepo;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private UserRepo userRepo;

    // CREATE EVENT
    @Override
    public Event addEvent(Event event, Long userId) {

        if (event == null) {
            throw new RuntimeException("Event is null");
        }

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        event.setUser(user);
        return eventRepo.save(event);
    }

    // PATCH UPDATE EVENT
    @Override
    public Event updateEvent(Event event) {

        if (event == null || event.getEventId() == null) {
            throw new RuntimeException("Event or Event ID is null");
        }

        Event existingEvent = eventRepo.findById(event.getEventId())
                .orElseThrow(() -> new RuntimeException("Event not found"));

        if (event.getEventName() != null) {
            existingEvent.setEventName(event.getEventName());
        }

        if (event.getPrice() != null) {
            existingEvent.setPrice(event.getPrice());
        }

        if (event.getEventDate() != null) {
            existingEvent.setEventDate(event.getEventDate());
        }

        if (event.getLocation() != null) {
            existingEvent.setLocation(event.getLocation());
        }

        if (event.getMoreInfo() != null) {
            existingEvent.setMoreInfo(event.getMoreInfo());
        }

        return eventRepo.save(existingEvent);
    }

    // DELETE / CANCEL EVENT
    @Override
    public void cancelEvent(Long eventId) {

        if (!eventRepo.existsById(eventId)) {
            throw new RuntimeException("Event not found");
        }

        eventRepo.deleteById(eventId);
    }

    // READ ALL EVENTS
    @Override
    public List<Event> showAllEvents() {
        return eventRepo.findAll();
    }

    // READ EVENT BY ID
    @Override
    public Event showEventById(Long eventId) {
        return eventRepo.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }
}
