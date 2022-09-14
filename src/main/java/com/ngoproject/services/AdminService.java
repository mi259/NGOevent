package com.ngoproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoproject.model.Event;
import com.ngoproject.model.NGOUser;
import com.ngoproject.repository.EventRepository;
import com.ngoproject.repository.UserRepository;

@Service

public class AdminService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	EventRepository eventRepo;

	public List<NGOUser> listAllUser() {

		return userRepo.findAll();
	}

	public NGOUser getUserById(int id) {

		return userRepo.findById(id).get();
	}

	public NGOUser findByEmail(String email) {

		return userRepo.findAllByEmail(email);
	}
	
	public void deleteUserById(int id) {

		userRepo.deleteById(id);
	}

	public void addUser(NGOUser user) {
		userRepo.save(user);

	}

	public void updateUser(String fname, String lname, String email, String role, String password, Integer id) {
		userRepo.updateUserById(fname, lname, email, role, password, id);

	}

	

	public List<Event> listAllEvent() {

		return eventRepo.findAll();
	}

	public Event getEventById(int id) {
		
		return eventRepo.findById(id).get();
	}

	public void addEvent(Event event) {
		eventRepo.save(event);

	}

	public void deleteEventById(int id) {
		eventRepo.deleteById(id);
	}

}
