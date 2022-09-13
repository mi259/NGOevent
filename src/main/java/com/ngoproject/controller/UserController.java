package com.ngoproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ngoproject.exception.ResourceNotFoundException;

import com.ngoproject.model.Event;
import com.ngoproject.model.NGOUser;
import com.ngoproject.model.Registration;
import com.ngoproject.repository.EventRepository;
import com.ngoproject.repository.UserRepository;
import com.ngoproject.services.AdminService;
import com.ngoproject.services.UserService;

@RestController
public class UserController {

	
	
	
	@Autowired
	UserService userService;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<NGOUser> getUserById(@PathVariable int id) {
		try {
			NGOUser user = userService.getUserById(id);
			return new ResponseEntity<NGOUser>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<NGOUser>(HttpStatus.NOT_FOUND);
		}
	}
	
		
	@GetMapping("/user/event/")
	public List<Event> getEvent() {

		return userService.listAllEvent();
	}
	

	
	@GetMapping("/user/event/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable int id) {
		try {
			Event event = userService.getEventById(id);
			return new ResponseEntity<Event>(event, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/user/event/registration")
	public List<Registration> getRegistration() {

		return userService.listAllRegistraton();
	}
	
	
	/*@PostMapping("/user/event/registration")
	public void addRegistration(@Valid @RequestBody Registration reg) {
		userService.addRegistration(reg);
	}*/
	
	@RequestMapping(value = "/user/event/registration", method = RequestMethod.POST)
	public void creatUserAccount(@RequestBody Registration reg) {
		
		NGOUser user = userService.findAllByEmail(reg.getEmail());
		Event event = userService.findEventByname(reg.getEvnetName());
		Integer uid = user.getUserId();
		Integer eid = event.getEventId();
		
		Double adultprice = event.getAdultPrice();
		Double childprice = event.getChildPrice();
		
		Double totaladultprice =( (reg.getTotalAdult()) * adultprice);
		Double totalchildprice =( (reg.getTotalChild()) * childprice);
		
		Double total = totaladultprice + totalchildprice;
		reg.setUserid(uid);
		reg.setEventid(eid);
		
		reg.setTotalPrice(total);
		userService.addRegistration(reg);
	}
	
	@GetMapping("/user/event/name/{name}")
	public ResponseEntity<Event> findEventByname(@PathVariable String name) {
		try {
			Event event = userService.findEventByname(name);
			return new ResponseEntity<Event>(event, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}
	}

}
