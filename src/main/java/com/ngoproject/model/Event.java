package com.ngoproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.TrueFalseType;
import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Data
@Entity
@Table(name = "EVENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable{

	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "EVENTID")
	    private Integer eventId;
	    
	    @NotNull
		@Size(min = 2, message = "Event Name should have atleast 2 characters")
	    @Column(name = "NAME")
	    private String name;
	    
	    @NotNull
		@Size(min = 15, message = "Event description should have atleast 15 characters")
	    @Column(name = "DESCRIPTION")
	    private String description;
	    
	       
	    @Column(name="IMAGE")
	    private String image;
	    
	    @NotNull(message = "Start date is Required")
	    @Column(name = "STARTDATE")
	   // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	    private String startDate;
	    
	    @NotNull(message = "End date is Required")
	    @Column(name = "ENDDATE")
		//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	    private String endDate;
	    
	    @NotNull(message = "Start Time is Required")
	    @Column(name = "STARTTIME")
	 	private String startTime;
	    
	    @NotNull(message = "End Time is Required")
	    @Column(name = "ENDTIME")
	 	private String endTime; 
	    
	
	    @NotNull(message = "Location is Required")
	    @Column(name = "LOCATION")
	    private String location;
	    
	    @Column(name = "ALLOWREGISTRATION")
	    private String allowRegistration;
	    
	    @NotNull(message = "Adult price is Required")
	    @Column(name = "ADULTPRICE")
	    private Double adultPrice;
	    
	    @NotNull(message = "Child price is Required")
	    @Column(name = "CHILDPRICE")
	    private Double childPrice;
	    
	    @JsonIgnore
	    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "registeredEvents")
	    private List<NGOUser> registeredUsers;


}
