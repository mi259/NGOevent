package com.ngoproject.user;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ngoproject.model.Event;
import com.ngoproject.model.NGOUser;
import com.ngoproject.model.Registration;
import com.ngoproject.repository.EventRepository;
import com.ngoproject.repository.RegistrationRepository;
import com.ngoproject.repository.UserRepository;

@SpringBootTest
class NgOeventApplicationUserTests {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	EventRepository eventRepo;

	@Autowired
	RegistrationRepository regRepo;
	
	
	/*@Test
	public void getUserById() {
		NGOUser user = userRepo.findById(2).get();
		System.out.println("User = " + user);

	}*/

	 @Test
		public void getEvent() {
			List<Event> events = eventRepo.findAll();
			System.out.println("Events = " + events);
		}

	/*	@Test
		public void getEventById() {
			Event event = eventRepo.findById(2).get();
			System.out.println("Events = " + event);

		}*/
	@Test
	public void addUseraddRegistration() {
		
		Registration reg = new Registration();
		
		
		reg.setFirstname("John");
		reg.setLastName("Doe");
		reg.setEmail("jd@gmail.com");
		reg.setAddress("ghh");
		reg.setContactNo(66677);
		reg.setEvnetName("hghhj");
		reg.setTotalAdult(2);
		reg.setTotalChild(2);
		reg.setEventid(1);
		reg.setUserid(1);
		
		
		regRepo.save(reg);
	}


	
}


