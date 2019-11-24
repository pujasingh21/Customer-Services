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
<<<<<<< HEAD
//	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
=======
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3

	@Autowired
	private CustomerService service;

<<<<<<< HEAD
	@PostMapping("/customer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer data) {

		Customer customer = service.addCustomerData(data);

		return new ResponseEntity<>(customer, HttpStatus.OK);

	}

	@GetMapping("/customers")
=======
	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer data) {

		service.addCustomerData(data);

		return new ResponseEntity<>(data, HttpStatus.OK);

	}

	@GetMapping("/getCustomer")
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3
	@ResponseBody
	public List<Customer> getCustomer() {

		List<Customer> data = service.getCustomersData();

		return data;
	}

<<<<<<< HEAD
	@GetMapping("customer/{id}")
=======
	@GetMapping("getCustomer/{id}")
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3
	@ResponseBody
	public Optional<Customer> getCustomerById(@Valid @PathVariable("id") int id) {

		Optional<Customer> customer = service.getCustomerDataById(id);
		return customer;

	}

<<<<<<< HEAD
	@PutMapping("/customer")
=======
	@PutMapping("/updateCustomer")
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3

	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) {

		customer = service.updateCustomer(customer);

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

<<<<<<< HEAD
	@DeleteMapping("/customer/{id}")
=======
	@DeleteMapping("/deleteCustomer/{id}")
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3
	public ResponseEntity<Customer> deleteCustomerById(@Valid @PathVariable("id") int id) {

		service.deleteCustomerById(id);

		return new ResponseEntity<>(HttpStatus.OK);

	}

<<<<<<< HEAD
	@DeleteMapping("/customers")
=======
	@DeleteMapping("/deleteCustomers")
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3
	public ResponseEntity<Customer> deleteCustomers(Customer customer) {

		service.deleteCustomer(customer);

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
