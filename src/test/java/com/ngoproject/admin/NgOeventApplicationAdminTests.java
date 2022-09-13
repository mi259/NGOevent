package com.ngoproject.admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
	public void getUser() {
		List<NGOUser> users = userRepo.findAll();
		System.out.println("Users = " + users);
	}

	/*	@Test
	public void getUserById() {
		NGOUser user = userRepo.findById(2).get();
		System.out.println("User = " + user);

	}

	@Test
	public void addUser() throws ParseException {

		//DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		//DateFormat formatterTime = new SimpleDateFormat("HH:mm");
		NGOUser user = new NGOUser();

		user.setFirstname("John");
		user.setLastName("Doe");
		user.setEmail("jd@gmail.com");
		
		
		
		user.setPassword("$2a$12$t73OVZSewDhn1CVKTf2pDO1iDM.IOAenM8SfUQxc6Z9oCAEyrNmVu");//123
		user.setRole("User");
		//DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		//DateFormat formatterTime = new SimpleDateFormat("HH:mm");
		
		
		
		
		Event event = new Event();

		event.setAdultPrice(20.00);
		event.setAllowRegistration("T");
		event.setChildPrice(10.00);
		event.setDescription("hjj");
		
		event.setImage("1.jpeg");
		event.setLocation("nj");
		event.setName("fffg");
		event.setDescription("fggfhgjhjhjkjkjkgghgtuytytguygh");
		
		event.setStartDate("2022-09-09");
		event.setEndDate("2022-09-09");
		event.setStartTime("08:00");
		event.setEndTime("09:00");
		
		user.addRegisteredEvent(event);

		userRepo.save(user);
	}
*/

	/*@Test
	public void deleteUserById() {
		 userRepo.deleteById(3);
		
	}
	
	 @Test
	    public void updateUserById(){
		 NGOUser user = userRepo.findById(2).get();
		 	user.setFirstname("Mitali");
			user.setLastName("Italiya");
			user.setEmail("jd@gmail.com");
		
			
			user.setPassword("$2a$12$t73OVZSewDhn1CVKTf2pDO1iDM.IOAenM8SfUQxc6Z9oCAEyrNmVu");//123
			user.setRole("User");
			
		 userRepo.save(user);

			
	    }*/
	 
	 
	 @Test
		public void getEvent() {
			List<Event> events = eventRepo.findAll();
			System.out.println("Events = " + events);
		}

	/*	@Test
		public void getEventById() {
			Event event = eventRepo.findById(6).get();
			System.out.println("Events = " + event);

		}*/
		
		@Test
		public void addEvent() throws ParseException {

			//DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			//DateFormat formatterTime = new SimpleDateFormat("HH:mm");
			Event event = new Event();

			event.setAdultPrice(20.00);
			event.setAllowRegistration("T");
			event.setChildPrice(10.00);
			event.setDescription("hjj");
			
			event.setImage("1.jpeg");
			event.setLocation("nj");
			event.setName("fffg");
			event.setDescription("fggfhgjhjhjkjkjkgghgtuytytguygh");
			
			event.setStartDate("2022-09-09");
			event.setEndDate("2022-09-09");
			event.setStartTime("08:00");
			event.setEndTime("09:00");
			//event.setStartDate(formatter.parse("2022-09-09"));
			//event.setStartTime(formatterTime.parse("08:00"));
		//	event.setEndTime(formatterTime.parse("09:00"));
			
			

		//	user.addRegisteredEvent(event);

			eventRepo.save(event);
		}
		
	/*	@Test
		public void deleteEventById() {
			eventRepo.deleteById(3);
			
		}
		
		 @Test
		    public void updateEventById(){
			 Event event = eventRepo.findById(6).get();
			 event.setAdultPrice(20.00);
				event.setAllowRegistration("T");
				event.setChildPrice(10.00);
				event.setDescription("hjj");
				
				event.setImage("1.jpeg");
				event.setLocation("nj");
				event.setName("IT");
				event.setDescription("fggfhgjhjhjkjkjkgghgtuytytguygh");
				
				event.setStartDate("2022-09-09");
				event.setEndDate("2022-09-09");
				event.setStartTime("08:00");
				event.setEndTime("09:00");
				eventRepo.save(event);

				
		    }
		 */
}


