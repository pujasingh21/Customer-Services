package com.customerApi.api.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customerApi.api.exception.CustomerNotFoundException;
import com.customerApi.api.modals.Customer;
import com.customerApi.api.repositories.CustomerRepository;

@Service
public class CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepo;

	public boolean addCustomerData(Customer customer) {
		boolean status = false;
		try {

			logger.trace("Running post customer service");
			customerRepo.save(customer);
			logger.debug("Customer First Name {}, last name {}, sign-in in", customer.getFirstName(),
					customer.getLastName());
			status = true;
		} catch (NullPointerException e) {
			logger.error("Entered customer record is empty: " + e);
		}

		return status;

	}

	public List<Customer> getCustomersData() {
		logger.trace("Running get customer service :");
		return customerRepo.findAll();
	}

	public String getCustomerDataById(int id) {
		logger.trace("Running get customerById service :");
		Optional<Customer> customer = customerRepo.findById(id);

		if (!customer.isPresent()) {

			logger.error("Customer ID {}" + id);
			throw new CustomerNotFoundException("id-" + id);

		} else {
			logger.info("Customer ID {}" + id);
			return customerRepo.findById(id).toString();
		}

	}

	public boolean deleteCustomerById(int id) {
		Customer customer = new Customer();
		boolean status = false;

		logger.info("Inside delete service:" + customer);
		try {
			if (id != 0) {

				customerRepo.deleteById(id);
				logger.info("Customer ID {}, deleted", id);
				status = true;
			} else {
				logger.info("Enter valid cutomer id");
				status = false;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return status;
	}

	public boolean deleteCustomer(Customer record) {
		boolean status = false;
		try {
			if (record != null) {

				customerRepo.delete(record);
				;
				logger.trace("All Customer has been deleted successfully");
				status = true;
			} else {
				logger.warn("Invalid record");
				status = false;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return status;

	}

	public Customer updateCustomer(Customer data) {
		logger.debug("Customer First Name {}, last name {}, updated", data.getFirstName(), data.getLastName());
		customerRepo.save(data);
		logger.trace("Customer record updated successfully");
		return data;
	}

}
