package com.garage.test.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//INSERT INTO customer (name , Customercategory , ordercount) VALUES ('kavin' , 'regular'  ,'0');

@Entity(name = "customer")@Getter@Setter@NoArgsConstructor@AllArgsConstructor 
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID uuid;
	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "category")
	private String Customercategory;
	
	@Column(name = "ordercount")
	private Long ordercount;
	

}
