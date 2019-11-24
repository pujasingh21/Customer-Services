package com.customerApi.api.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.JDBCConnectionException;
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

	public Optional<Integer> addCustomerData(Customer customer) {

		Optional<Integer> customerId = null;

		try {

			Customer cust = customerRepo.save(customer);

			customerId = Optional.of(cust.getId());

		} catch (JDBCConnectionException e) {
			logger.error("Database connection error" + e);

		} catch (Exception e) {
			logger.error("Customer {} record has not saved Successfully " + e);
		}

		if (!customerId.isPresent()) {

			logger.error("Customer ID {}" + customerId);
			throw new CustomerNotFoundException(" Customer id-" + customerId);
		}
		logger.trace("Customer ID {}" + customerId);
		return customerId;

	}

	public List<Customer> getCustomersData() {
		List<Customer> allCustomer = null;

		try {
			allCustomer = customerRepo.findAll();
			Optional.of(allCustomer);

		} catch (JDBCConnectionException e) {
			logger.error("Database connection error" + e);

		} catch (Exception e) {
			logger.error("Database connection error " + e);
		}

		return allCustomer;
	}

	public Optional<Customer> getCustomerDataById(int id) {

		Optional<Customer> customer = null;
		try {
			customer = customerRepo.findById(id);

		} catch (JDBCConnectionException e) {
			logger.error("Database connection error" + e);

		} catch (Exception e) {
			logger.error("Customer {} not found " + e);
		}

		if (!customer.isPresent()) {

			throw new CustomerNotFoundException("id-" + id);

		}
		logger.info("Customer Record ID {}" + id);
		return customer;

	}

	public void deleteCustomerById(int id) {
		Optional<Integer> custmerId = null;
		try {
			custmerId = Optional.ofNullable(id);
			if (!custmerId.isPresent()) {

				logger.info("Enter valid cutomer id" + id);
				throw new CustomerNotFoundException("id-" + id);
			}
			customerRepo.deleteById(id);
		} catch (JDBCConnectionException e) {
			logger.error("Database connection error" + e);

		} catch (Exception e) {
			logger.error("Customer {} not found " + e);
		}

	}

	public void deleteCustomer(Customer record) {
		Optional<Customer> customer = Optional.ofNullable(record);

		try {
			if (!customer.isPresent()) {

				logger.info("Enter valid cutomer record");
				throw new CustomerNotFoundException("No customer record found");

			}
			customerRepo.delete(record);

			logger.trace("All Customers have been deleted successfully");
		} catch (JDBCConnectionException e) {
			logger.error("Database connection error" + e);

		} catch (Exception e) {
			logger.error("Customers have not been deleted " + e);
		}

	}

	public Customer updateCustomer(Customer data) {
		Optional<Customer> customer = Optional.ofNullable(data);
		try {
			if (!customer.isPresent()) {
				throw new CustomerNotFoundException("No customer record found");
			}
			customerRepo.save(data);
			logger.trace("Customer record updated successfully");
		} catch (JDBCConnectionException e) {
			logger.error("Database connection error" + e);

		} catch (Exception e) {
			logger.error("Customer has not updated " + e);
		}

		return data;
	}

}
