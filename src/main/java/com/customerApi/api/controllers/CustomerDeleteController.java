package com.customerApi.api.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.customerApi.api.modals.Customer;
import com.customerApi.api.services.CustomerDeleteService;




@Controller
public class CustomerDeleteController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerDeleteController.class);
	
	@Autowired
	CustomerDeleteService service;

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable ("id") int id)
	{
		logger.info("Redirect to delete service "+id);
				
		boolean result = service.deleteCustomerById(id);
		 logger.info("Record delete status : "+result);
		 
		// return result?new ResponseEntity<>(HttpStatus.OK):new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	       if(result)
			{
				return new ResponseEntity<>(HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
	}
	
	@DeleteMapping("/deleteCustomers")
	public ResponseEntity<Customer> deleteCustomers(Customer customer)
	{
		logger.info("Redirect to delete service");
		
		boolean result = service.deleteCustomer(customer);
		
		//return result?new ResponseEntity<>(HttpStatus.OK):new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		if(result)
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		 
		 
	}

}
