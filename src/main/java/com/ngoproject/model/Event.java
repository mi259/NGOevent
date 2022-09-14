package com.ngoproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "EVENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {

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

	@NotNull
	@Column(name = "EVENTCATEGORY")
	private String category;

	@NotNull(message = "Start date is Required")
	@Column(name = "STARTDATE")
	private String startDate;

	@NotNull(message = "End date is Required")
	@Column(name = "ENDDATE")
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
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "registeredEvents")
	private List<NGOUser> registeredUsers;

}
