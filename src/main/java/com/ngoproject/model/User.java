package com.ngoproject.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER")
@Getter
@Setter
public class User implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERID")
    private Integer userId;
    
    @Column(name = "FIRSTNAME")
    private String firstname;
    
    @Column(name = "LASTNAME")
    private String lastName;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "CONTACTNO")
    private Long contactNo;
    
    @Column(name = "ROLE")
    private String role;

    
  
	/*@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Event> event;*/

}
