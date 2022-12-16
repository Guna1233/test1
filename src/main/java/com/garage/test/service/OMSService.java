package com.garage.test.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garage.test.model.Customers;
import com.garage.test.repository.OMSRespository;

@Service
public class OMSService {
	
	@Autowired
	OMSRespository omsRespository;

	public Long getOrders(UUID uuid) {
		// TODO Auto-generated method stub
		return omsRespository.getordercount(uuid);
	}

	public void newOrder(String name) throws Exception{
		// TODO Auto-generated method stub
		
		Customers customers = omsRespository.getCustomer(name);
		long ordercount = customers.getOrdercount();
		if(ordercount==9 ) {
			omsRespository.updateOrderCategory(ordercount+1 , "gold" , customers.getName());
		}
		else if (ordercount==19) {
			omsRespository.updateOrderCategory(ordercount+1 , "platinum" , customers.getName());
		}
		else {
			omsRespository.updateOrderCount(ordercount+1 , customers.getName());
		}
		
	}
	
	

}
