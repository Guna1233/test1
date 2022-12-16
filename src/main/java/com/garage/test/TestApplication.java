package com.garage.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.garage.test.model.Customers;
import com.garage.test.repository.OMSRespository;

@SpringBootApplication
public class TestApplication implements CommandLineRunner{
	
	@Autowired
	OMSRespository omsRespository;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Customers customers = new Customers();
		customers.setName("kavin");
		customers.setCustomercategory("regular");
		customers.setOrdercount(new Long(0));
		omsRespository.save(customers);
		
	}

}
