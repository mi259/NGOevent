package com.ngoproject.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ngoproject.model.Event;
import com.ngoproject.model.NGOUser;

import com.ngoproject.services.AdminService;
import com.ngoproject.services.ImageService;

@RestController

public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	private ImageService imageService;

	@GetMapping("/admin/user")
	public List<NGOUser> getUser() {

		return adminService.listAllUser();
	}

	@GetMapping("/admin/user/{id}")
	public ResponseEntity<NGOUser> getUserById(@PathVariable int id) {
		try {
			NGOUser user = adminService.getUserById(id);
			return new ResponseEntity<NGOUser>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<NGOUser>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/admin/user/email/{email}")
	public ResponseEntity<NGOUser> findByEmail(@PathVariable String email) {
		try {
			NGOUser user = adminService.findByEmail(email);
			return new ResponseEntity<NGOUser>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<NGOUser>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/admin/user/{id}")
	public void deleteUserById(@PathVariable int id) {
		adminService.deleteUserById(id);
	}

	

	@GetMapping("/admin/event")
	public List<Event> getEvent() {

		return adminService.listAllEvent();
	}

	@GetMapping("/admin/event/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable int id) {
		try {
			Event event = adminService.getEventById(id);
			return new ResponseEntity<Event>(event, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/admin/event")
	public void addEvent(@RequestBody Event event) {
		adminService.addEvent(event);
	}
	
	@PostMapping(path = "/admin/uploadimage/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void uploadImage(@PathVariable int id, @RequestParam("file") MultipartFile file) {
		imageService.uploadImage(id, file);
	}

	@PutMapping("/admin/event/{id}")
	public ResponseEntity<Event> updateEventById(@RequestBody Event event, @PathVariable int id) {
		try {

			event.setEventId(id);
			adminService.addEvent(event);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/admin/event/{id}")
	public void deleteEventById(@PathVariable int id) {
		adminService.deleteEventById(id);
	}

}
