package com.jay.sessions.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;
	
	private String eventName;
	
	private Double price;
	
	private LocalDateTime eventDate;
	
	private String location;
	
	private String moreInfo;

	@ManyToOne
	@JoinColumn(name="userId")
	@JsonBackReference
	private User user;
	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(Long eventId, String eventName, Double price, LocalDateTime eventDate, String location,
			String moreInfo, User user) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.price = price;
		this.eventDate = eventDate;
		this.location = location;
		this.moreInfo = moreInfo;
		this.user = user;
	}
	
	

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDateTime getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", price=" + price + ", eventDate="
				+ eventDate + ", location=" + location + ", moreInfo=" + moreInfo + ", user=" + user.getUserId() + "]";
	}

	
	
	
	
}
