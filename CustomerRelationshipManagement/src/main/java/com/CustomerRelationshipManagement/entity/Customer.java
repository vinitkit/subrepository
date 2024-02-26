package com.CustomerRelationshipManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name" )
	private String firstName;
	
	@Column(name = "last_name" )
	private String lastName;
	
	private String email;
	
	@Column(name = "mobile_number" )
	private String mobileNumber;

	private int age;
}
