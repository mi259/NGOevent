package com.ngoproject.user;


import com.ngoproject.model.Event;
import com.ngoproject.model.NGOUser;
import com.ngoproject.repository.EventRepository;
import com.ngoproject.repository.RegistrationRepository;
import com.ngoproject.repository.UserRepository;
import com.ngoproject.services.AdminService;
import com.ngoproject.services.UserService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NgOeventApplicationUserServiceTests {

	
	@Mock
	UserRepository userRepo;
	
	@InjectMocks
    @Autowired
	private UserService userService;
	
	@Mock
	EventRepository eventRepo;
	
	@Mock
	RegistrationRepository regRepo;
	
	
	@Test
	public void testGetUserById() {
		NGOUser user = userService.getUserById(2);
		System.out.println("User = " + user);

	}

	
	
	 @Test
		public void testGetEvent() {
			List<Event> events = userService.listAllEvent();
			System.out.println("Events = " + events);
		}

		@Test
		public void testGetEventById() {
			Event event = userService.getEventById(1);
			System.out.println("Events = " + event);

		}
		
		@Test
		public void testListAllRegistraton() {
			userService.listAllRegistraton();
			
		}




}