package com.jay.sessions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jay.sessions.entity.Event;
import com.jay.sessions.service.EventService;

@RestController
@RequestMapping("/events")
@CrossOrigin("http://localhost:4200")
public class EventController {

    @Autowired
    private EventService eventService;

    // CREATE EVENT (userId required)
    @PostMapping("/user/{userId}")
    public Event addEvent(
            @RequestBody Event event,
            @PathVariable Long userId) {

        return eventService.addEvent(event, userId);
    }

    // READ ALL EVENTS
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.showAllEvents();
    }

    // READ EVENT BY ID
    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable Long eventId) {
        return eventService.showEventById(eventId);
    }

    // PATCH UPDATE EVENT
    @PatchMapping("/{eventId}")
    public Event updateEvent(
            @PathVariable Long eventId,
            @RequestBody Event event) {

        event.setEventId(eventId);
        return eventService.updateEvent(event);
    }

    // DELETE / CANCEL EVENT
    @DeleteMapping("/{eventId}")
    public void cancelEvent(@PathVariable Long eventId) {
        eventService.cancelEvent(eventId);
    }
}
