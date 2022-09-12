package com.ngoproject.admin;


import com.ngoproject.model.Event;
import com.ngoproject.model.NGOUser;
import com.ngoproject.repository.EventRepository;
import com.ngoproject.repository.UserRepository;
import com.ngoproject.services.AdminService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NgOeventApplicationAdminServiceTests {

	
	@Mock
	UserRepository userRepo;
	
	@InjectMocks
    @Autowired
	private AdminService adminService;
	
	@Mock
	EventRepository eventRepo;
	
	@Test
	public void testGetUser() {
		List<NGOUser> users = adminService.listAllUser();
		System.out.println("Users = " + users);
	}
	
	@Test
	public void testGetUserById() {
		NGOUser user = adminService.getUserById(2);
		System.out.println("User = " + user);

	}

	@Test
	public void testDeleteUserById() {
		adminService.deleteUserById(5);
		
	}
	
	 @Test
		public void testGetEvent() {
			List<Event> events = adminService.listAllEvent();
			System.out.println("Events = " + events);
		}

		@Test
		public void testGetEventById() {
			Event event = adminService.getEventById(1);
			System.out.println("Events = " + event);

		}
		
		@Test
		public void testDeleteEventById() {
			adminService.deleteEventById(2);
			
		}




}