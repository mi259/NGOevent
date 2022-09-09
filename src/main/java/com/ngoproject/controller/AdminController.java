package com.ngoproject.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ngoproject.model.Event;
import com.ngoproject.model.User;
import com.ngoproject.services.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/")
	public String Talks() {

		return "Hello ,This is NGO Event Project !!";

	}

	@GetMapping("/admin/user")
	public List<User> getUser() {

		return adminService.listAllUser();
	}
	
	@GetMapping("/admin/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		try {
			User user = adminService.getUserById(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*@PostMapping("/admin/user1")
	public ResponseEntity<String> addUser1(@RequestBody User user) {
		adminService.addUser(user);
	}*/
	
	@PostMapping("/admin/user")
	public void addUser(@RequestBody User user) {
		adminService.addUser(user);
	}
	
	@GetMapping("/admin/event")
	public List<Event> getEvent() {

		return adminService.listAllEvent();
	}
	
	@PostMapping("/admin/event")
	public void addEvent(@RequestBody Event event) {
		adminService.addEvent(event);
	}
}
