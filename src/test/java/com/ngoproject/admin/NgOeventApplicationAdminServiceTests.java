package com.ngoproject.admin;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ngoproject.model.Event;
import com.ngoproject.model.NGOUser;
import com.ngoproject.repository.EventRepository;
import com.ngoproject.repository.UserRepository;
import com.ngoproject.services.AdminService;

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
		NGOUser user = adminService.getUserById(1);
		System.out.println("User = " + user);

	}

	public void testFindByEmail() {
		NGOUser user = adminService.findByEmail("m@gmail.com");
		System.out.println("User = " + user);

	}

	
//	  @Test public void testDeleteUserById() { adminService.deleteUserById(2);
//	  
//	  }
	 

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
	
//	  @Test public void testDeleteEventById() { adminService.deleteEventById(2);
//	  
//	  }
	 

}