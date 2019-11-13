package com.customerApi.api.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.customerApi.api.services.CustomerFetchService;



@RestController
public class CustomergetController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomergetController.class); 
	
	
	@Autowired
	private CustomerFetchService customerFetchService;
	
	@GetMapping("/getCustomer")
	@ResponseBody
	public String getCustomer()
	{
		logger.info("Sending request to service layer");
		String data = customerFetchService.getCustomersData();		
		return data;		
		
	}
	@GetMapping("getCustomer/{id}")
	@ResponseBody
	public String getCustomerById(@PathVariable("id") int id)
	{
		logger.info("Redirect to service layer"+id);
		String customer = customerFetchService.getCustomerDataById(id);
		return customer;
	}

}
