package com.ngoproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@GetMapping("/")
	public String NGOevent() {

		return "Hello ,This is NGO Event Project !!";

	}
}
