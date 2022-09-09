package com.ngoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngoproject.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
