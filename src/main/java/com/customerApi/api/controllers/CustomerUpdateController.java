package com.customerApi.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.customerApi.api.modals.Customer;
import com.customerApi.api.services.UpdateCustomerService;




@RestController
public class CustomerUpdateController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerUpdateController.class);
	
	@Autowired
	UpdateCustomerService service;
	
	@PutMapping("/updateCustomer")
	
	public ResponseEntity <Customer> customerUpdate(@RequestBody Customer customer)
	{
		logger.info("Redirect to update service :"+customer);
		
		customer = service.updateCustomer(customer);	
		
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

}
