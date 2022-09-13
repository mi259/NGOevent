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

@Data
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
    
    @NotNull
	@Size(min = 2, message = "Event Name should have atleast 2 characters")
    @Column(name = "EVENTNAME")
    private String evnetName;
    
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
      
    @Column(name = "ADDRESS")
    private String address;
    
    @NotNull(message = "Contact no is Required")
    @Column(name = "CONTACTNO")
    private Integer contactNo;
 
    @NotNull(message = "Total adult quentity is Required")
    @Column(name = "TotalADULT")
    private int totalAdult;
    
    
    @NotNull(message = "Total Child quentity is Required")
    @Column(name = "TOTALCHILD")
    private int totalChild;
    
    @Column(name = "TOTALPRICE")
    private Double totalPrice;
    
    
   // @OneToOne
  //  @JoinColumn(name="uid", referencedColumnName =  "userId")
    private Integer userid;
    
  //  @OneToOne
 //   @JoinColumn(name="eid", referencedColumnName =  "eventId")
    private Integer eventid;
    
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
