package com.ngoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ngoproject.model.NGOUser;
import com.ngoproject.model.Registration;


@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

	
	
	
	
	
}
