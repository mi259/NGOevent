package com.ngoproject.user;

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

	@Test
	public void getUserById() {
		NGOUser user = userRepo.findById(1).get();
		System.out.println("User = " + user);

	}

	@Test
	public void getEvent() {
		List<Event> events = eventRepo.findAllevent("t");
		System.out.println("Events = " + events);
	}

	@Test
	public void getEventById() {
		Event event = eventRepo.findById(1).get();
		System.out.println("Events = " + event);

	}

	@Test
	public void addUseraddRegistration() {

		Registration reg = new Registration();

		reg.setFirstname("sena");
		reg.setLastName("miller");
		reg.setEmail("s@gmail.com");
		reg.setAddress("NJ");
		reg.setContactNo(2012455667);
		reg.setEvnetName("Sql teaching session");
		reg.setTotalAdult(2);
		reg.setTotalChild(2);
		reg.setEventid(1);
		reg.setUserid(1);
		reg.setTotalPrice(180.00);
		regRepo.save(reg);
	}

}
