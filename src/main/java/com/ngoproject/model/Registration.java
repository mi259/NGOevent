package com.ngoproject.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.TrueFalseType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import com.ngoproject.model.NGOUser;

@Entity
@Table(name = "REGISTRATION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Registration implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGID")
    private Integer regId;
    
    @Column(name = "EVENTNAME")
    private String evnetName;
    
    @Column(name = "FIRSTNAME")
    private String firstname;
    
    @Column(name = "LASTNAME")
    private String lastName;
    
    @Column(name = "EMAIL")
    private String email;
      
    @Column(name = "ADDRESS")
    private String address;
    
    @Column(name = "CONTACTNO")
    private Integer contactNo;
 
    
    @Column(name = "TotalADULT")
    private int totalAdult;
    
    @Column(name = "TOTALCHILD")
    private int totalChild;
    
   // @OneToOne
  //  @JoinColumn(name="uid", referencedColumnName =  "userId")
    private int userid;
    
  //  @OneToOne
 //   @JoinColumn(name="eid", referencedColumnName =  "eventId")
    private int eventid;
    
	/*    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name ="UID", referencedColumnName = "USERID")
		private User user;*/
	    
	  /*  @JsonBackReference
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name ="UID", referencedColumnName = "USERID")
		private User user; */
	    
/*
	    @JsonManagedReference
		@OneToMany(mappedBy = "event", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	    private List<User> user;
	    */

}
