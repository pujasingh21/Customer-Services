package com.customerApi.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.customerApi.api.modals.Customer;
import com.customerApi.api.services.CustomerService;

@RestController
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService service;
	  
	    @PostMapping(path = "/saveCustomer", consumes = "application/json", produces = "application/json")
    	public String saveCustomer(@RequestBody Customer data) {
		logger.info("Post customer Rquest started");
		boolean status = service.addCustomerData(data);
		logger.info("Post customer Rquest complted");
		if (status) {
			return "Success";
		} else {
			return "Fail";

		}

	}

	@GetMapping("/getCustomer")
	@ResponseBody
	public List<Customer> getCustomer() {

		logger.info("Get customer Rquest started");
		List<Customer> data = service.getCustomersData();
		logger.info("Get customer Rquest Completed");

		return data;

	}

	@GetMapping("getCustomer/{id}")
	@ResponseBody
	public String getCustomerById(@PathVariable("id") int id) {

		logger.info("Get customerById Rquest started");
		String customer = service.getCustomerDataById(id);
		logger.info("Get customerById Rquest Completed");

		return customer;

	}

	@PutMapping("/updateCustomer")

	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {
		logger.info("Put customer Rquest started");

		customer = service.updateCustomer(customer);

		logger.info("Put customer Rquest completed");
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") int id) {
		logger.info("deleteCustomerById delete request started: " + id);

		boolean result = service.deleteCustomerById(id);
		logger.info("Record deletion status : " + result);

		return result ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		/*
		 * if (result) { return new ResponseEntity<>(HttpStatus.OK); } else { return new
		 * ResponseEntity<>(HttpStatus.BAD_REQUEST); }
		 */
	}

	@DeleteMapping("/deleteCustomers")
	public ResponseEntity<Customer> deleteCustomers(Customer customer) {
		logger.info("Redirect to delete service");

		boolean result = service.deleteCustomer(customer);

		return result ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		/*
		 * if (result) { return new ResponseEntity<>(HttpStatus.OK); } else { return new
		 * ResponseEntity<>(HttpStatus.BAD_REQUEST); }
		 */

	}

}
