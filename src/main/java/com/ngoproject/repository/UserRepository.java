package com.ngoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ngoproject.model.NGOUser;

@Repository
public interface UserRepository extends JpaRepository<NGOUser, Integer> {

	@Query(value = "select * from user where email = ?", nativeQuery = true)
	NGOUser findAllByEmail(String email);

	@Modifying
	@Transactional
	@Query(value = "update user set firstname=?1 , lastname =?2, email=?3,role=?4 ,password=?5 where userid =?6", nativeQuery = true)
	void updateUserById(String fname, String lname, String email, String role, String password, Integer id);

}
