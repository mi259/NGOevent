package com.ngoproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image {

	@Id
	@GeneratedValue
	private Integer id;
	private String imagePath;
	private String imageFileName;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "eventId", referencedColumnName = "eventId")
	private Event event;

}
