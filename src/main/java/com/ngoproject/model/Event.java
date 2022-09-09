package com.ngoproject.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.TrueFalseType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "EVENT")
@Getter
@Setter
public class Event implements Serializable{

	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "EVENTID")
	    private Integer eventId;
	    
	    @Column(name = "NAME")
	    private String name;
	    
	    @Column(name = "DESCRIPTION")
	    private String description;
	    
	    @Lob    
	    @Column(name="IMAGE")
	    private byte[] imageData;
	    
	    @Column(name = "STARTDATE")
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	    private java.util.Date startDate;
	    
	    @Column(name = "ENDDATE")
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	    private Date endDate;
	    
	 /*   @Column(name = "STARTTIME")
	    @UpdateTimestamp
	    @JsonFormat(pattern="HH:mm:ss.SSS")
	    @DateTimeFormat(pattern="HH:mm:ss" )
	    @Temporal(value=TemporalType.TIME)
	    private java.util.Date startTime;
	    
	    @Column(name = "ENDTIME")
	    @UpdateTimestamp
	    @JsonFormat(pattern="HH:mm:ss.SSS")
	    @DateTimeFormat(pattern="HH:mm:ss" )
	    @Temporal(value=TemporalType.TIME)
	    private java.util.Date endTime; */
	    
	    @Column(name = "LOCATION")
	    private String location;
	    
	    @Column(name = "ALLOWREGISTRATION")
	    private String allowRegistration;
	    
	    @Column(name = "ADULTPRICE")
	    private Double adultPrice;
	    
	    @Column(name = "CHILDPRICE")
	    private Double childPrice;
	    
	   
	    
	    
	    
	    
		
	    @ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="USERID",nullable = true)
		@JsonIgnore
		private User user;

}
