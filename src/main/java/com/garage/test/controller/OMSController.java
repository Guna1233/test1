package com.garage.test.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.garage.test.dto.OMSDto;
import com.garage.test.service.OMSService;

@RestController
@RequestMapping("/api/v1/")
public class OMSController {
	
	@Autowired
	OMSService omsService;
	
	@RequestMapping(value = "/orderscount/{id}" , method = RequestMethod.GET)
	public Long getOrders(@PathVariable("id")UUID uuid){
		return omsService.getOrders(uuid);
	}
	
	@RequestMapping(value = "/neworder" , method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> newOrders(@RequestBody OMSDto omsDto){
		try {
			omsService.newOrder(omsDto.getName());
			return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

}
