package com.customerApi.api.controllers;

import java.util.List;
import java.util.Optional;

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
//	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService service;

	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer data) {

		Customer customer = service.addCustomerData(data);

		return new ResponseEntity<>(customer, HttpStatus.OK);

	}

	@GetMapping("/customers")
	@ResponseBody
	public List<Customer> getCustomer() {

		List<Customer> data = service.getCustomersData();

		return data;
	}

	@GetMapping("customer/{id}")
	@ResponseBody
	public Optional<Customer> getCustomerById(@Valid @PathVariable("id") int id) {

		Optional<Customer> customer = service.getCustomerDataById(id);
		return customer;

	}

	@PutMapping("/customer")

	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {

		customer = service.updateCustomer(customer);

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@Valid @PathVariable("id") int id) {

		service.deleteCustomerById(id);

		return new ResponseEntity<>(HttpStatus.OK);

	}

	@DeleteMapping("/customers")
	public ResponseEntity<Customer> deleteCustomers(Customer customer) {

		service.deleteCustomer(customer);

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
