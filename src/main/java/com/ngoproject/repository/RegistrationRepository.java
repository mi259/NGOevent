package com.ngoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngoproject.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
