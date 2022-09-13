package com.ngoproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngoproject.model.Event;
import com.ngoproject.model.NGOUser;
import com.ngoproject.model.Registration;
import com.ngoproject.repository.EventRepository;
import com.ngoproject.repository.RegistrationRepository;
import com.ngoproject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	EventRepository eventRepo;

	@Autowired
	RegistrationRepository regRepo;
	
	
	
public NGOUser getUserById(int id) {
		
		return userRepo.findById(id).get();
	}
	
	
	
	public List<Event> listAllEvent() {
		
		return eventRepo.findAllevent("T");
	}

	public Event getEventById(int id) {

		return eventRepo.findById(id).get();
	}


	public void addRegistration(Registration reg) {
		regRepo.save(reg);
		
	}


	public List<Registration> listAllRegistraton() {

		
		return regRepo.findAll();
	}



	public NGOUser findAllByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findAllByEmail(email);
	}



	public Event findEventByname(String name) {
		// TODO Auto-generated method stub
		return eventRepo.findByName(name);
	}









	

	
	

	

	

	
	

	

}
