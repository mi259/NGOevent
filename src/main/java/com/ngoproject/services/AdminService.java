package com.ngoproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngoproject.model.Event;
import com.ngoproject.model.User;
import com.ngoproject.repository.EventRepository;
import com.ngoproject.repository.UserRepository;
@Service
public class AdminService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	EventRepository eventRepo;

	public List<User> listAllUser() {
		
		return userRepo.findAll();
	}

	public User getUserById(int id) {
		
		return userRepo.findById(id).get();
	}
	public void addUser(User user) {
		userRepo.save(user);
		
	}
	
	
	
	
	
	public List<Event> listAllEvent() {
		
		return eventRepo.findAll();
	}

	public void addEvent(Event event) {
		 eventRepo.save(event);
		
	}

	
	

	

}
