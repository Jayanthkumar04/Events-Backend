package com.jay.sessions.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String name;
	
	private Long contactNumber;
	
	private String emailId;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	
	@JsonManagedReference
	private List<Event> events = new ArrayList<>();
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public User(Long userId, String name, Long contactNumber, String emailId, Role role, List<Event> events) {
		super();
		this.userId = userId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.role = role;
		this.events = events;
	}



	public List<Event> getEvents() {
		return events;
	}



	public void setEvents(List<Event> events) {
		this.events = events;
	}



	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long id) {
		this.userId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", name=" + name + ", contactNumber=" + contactNumber + ", emailId=" + emailId
				+ ", role=" + role + "]";
	}
	
	
}
