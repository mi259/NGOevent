package com.ngoproject.admin;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ngoproject.model.Event;
import com.ngoproject.model.NGOUser;
import com.ngoproject.repository.EventRepository;
import com.ngoproject.repository.UserRepository;

@SpringBootTest
class NgOeventApplicationAdminTests {

	@Autowired
	UserRepository userRepo;

	@Autowired
	EventRepository eventRepo;

	@Test
	public void GetUser() {
		List<NGOUser> users = userRepo.findAll();
		System.out.println("Users = " + users);
	}

	@Test
	public void getUserById() {
		NGOUser user = userRepo.findById(1).get();
		System.out.println("User = " + user);

	}

	@Test
	public void addUser() throws ParseException {

		NGOUser user = new NGOUser();

		user.setFirstname("matilda");
		user.setLastName("bill");
		user.setEmail("m@gmail.com");
		user.setPassword("$2a$12$t73OVZSewDhn1CVKTf2pDO1iDM.IOAenM8SfUQxc6Z9oCAEyrNmVu");// 123
		user.setRole("User");

		Event event = new Event();

		event.setAdultPrice(20.00);
		event.setAllowRegistration("t");
		event.setChildPrice(10.00);
		event.setDescription("Sql teaching session");
		event.setLocation("nj");
		event.setName("sql event");
		event.setCategory("presentation");
		event.setStartDate("2022-10-09");
		event.setEndDate("2022-10-09");
		event.setStartTime("11:00");
		event.setEndTime("12:00");

		user.addRegisteredEvent(event);

		userRepo.save(user);
	}

	@Test
	public void updateUserById() {
		NGOUser user = userRepo.findById(2).get();
		user.setFirstname("Mitali");
		user.setLastName("Italiya");
		user.setEmail("m@gmail.com");

		user.setPassword("$2a$12$t73OVZSewDhn1CVKTf2pDO1iDM.IOAenM8SfUQxc6Z9oCAEyrNmVu");// 123
		user.setRole("User");

		userRepo.updateUserById("Mitali", "Italiya", "mitali@gmail.com", "User",
				"$2a$12$t73OVZSewDhn1CVKTf2pDO1iDM.IOAenM8SfUQxc6Z9oCAEyrNmVu", 2);

	}
	
//	@Test
//	public void deleteUserById() {
//		 userRepo.deleteById(3);
//		
//	}

	@Test
	public void getEvent() {
		List<Event> events = eventRepo.findAll();
		System.out.println("Events = " + events);
	}

	@Test
	public void getEventById() {
		Event event = eventRepo.findById(1).get();
		System.out.println("Events = " + event);

	}

	@Test
	public void addEvent() throws ParseException {

		NGOUser u = new NGOUser();

		u.setFirstname("Sena");
		u.setLastName("miller");
		u.setEmail("s@gmail.com");
		u.setPassword("$2a$12$S7KJfY/kbASbam5RDbgDzuMTY.mhgtO.zKtvrNgTarLoUORCRZvaC");// sena
		u.setRole("User");

		Event e = new Event();

		e.setAdultPrice(30.00);
		e.setAllowRegistration("f");
		e.setChildPrice(25.00);
		e.setDescription("live amazing music");
		e.setLocation("ny");
		e.setName("music consert event");
		e.setCategory("conference");
		e.setStartDate("2022-09-25");
		e.setEndDate("2022-09-25");
		e.setStartTime("20:00");
		e.setEndTime("23:00");

		u.addRegisteredEvent(e);

		userRepo.save(u);

		eventRepo.save(e);
	}

	@Test
	public void updateEventById() {
		Event event = eventRepo.findById(1).get();
		event.setAdultPrice(50.00);
		event.setAllowRegistration("f");
		event.setChildPrice(40.00);
		event.setDescription("live amazing music");
		event.setLocation("ny");
		event.setName("music consert event");
		event.setCategory("conference");
		event.setStartDate("2022-09-25");
		event.setEndDate("2022-09-25");
		event.setStartTime("20:00");
		event.setEndTime("23:00");
		eventRepo.save(event);

	}

//	  @Test public void deleteEventById() { 
//	  eventRepo.deleteById(3);
//
//}

}
