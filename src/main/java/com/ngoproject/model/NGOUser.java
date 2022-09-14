package com.ngoproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "USER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class NGOUser implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USERID")
	private Integer userId;

	@NotNull
	@Size(min = 2, message = "First Name should have atleast 2 characters")
	@Column(name = "FIRSTNAME")
	private String firstname;

	@NotNull
	@Size(min = 2, message = "Last Name should have atleast 2 characters")
	@Column(name = "LASTNAME")
	private String lastName;

	@Email
	@NotBlank
	@Column(name = "EMAIL")
	private String email;

	@NotNull
	@Size(min = 4, message = "Password must be at least 4 characters")
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	private String role;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "events_registered", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "eventid"))
	private List<Event> registeredEvents;

	public void addRegisteredEvent(Event event) {
		if (this.registeredEvents == null) {
			this.registeredEvents = new ArrayList<Event>();
		}

		this.registeredEvents.add(event);
	}

}
