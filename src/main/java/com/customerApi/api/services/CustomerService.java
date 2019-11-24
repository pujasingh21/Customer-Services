package com.customerApi.api.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.JDBCConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;

import com.customerApi.api.exception.CustomerNotFoundException;
import com.customerApi.api.modals.Customer;
import com.customerApi.api.repositories.CustomerRepository;

@Service
public class CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepo;

	public Customer addCustomerData(Customer data) {

		Customer customer = new Customer();

		try {

			customer = customerRepo.save(data);
			if (!Optional.ofNullable(customer).isPresent()) {

				logger.error("Customer {}" + customer);
				throw new CustomerNotFoundException(" Customer not saved-");
			}

		} catch (CannotCreateTransactionException e) {

			throw new CustomerNotFoundException("Database Connectivity Error", e);
		}  catch (Exception e) {
			logger.error("Customer {} record has not saved Successfully " + e);
			throw new CustomerNotFoundException("Exception in Customer post service", e);
		}

		return customer;

	}

	public List<Customer> getCustomersData() {
		List<Customer> allCustomer = null;

		try {
			allCustomer = customerRepo.findAll();
			Optional.of(allCustomer);

		} catch (CannotCreateTransactionException e) {
			logger.error("Database connection error" + e);
			throw new CustomerNotFoundException("Database Connectivity Error", e);

		} 
		
		catch (CustomerNotFoundException e) {
			logger.error("Customers record not found" + e);
			throw new CustomerNotFoundException("Customer records not found", e);
		} 
		
		catch (Exception e) {
			logger.error("Exception in Get Customers " + e);
			throw new CustomerNotFoundException("Exception in Get Customers Request", e);
		}

		return allCustomer;
	}

	public Optional<Customer> getCustomerDataById(int id) {

		Optional<Customer> customer = null;
		try {
			customer = customerRepo.findById(id);
			if (!customer.isPresent()) {

				throw new CustomerNotFoundException("Customer id{} not found ");

			}
		} catch (CannotCreateTransactionException e) {
			logger.error("Database connection error" + e);
			throw new CustomerNotFoundException("Database Connectivity Error", e);

		} catch (CustomerNotFoundException e) {

			throw new CustomerNotFoundException("Customer id{} not found", e);

		}

		catch (Exception e) {
			logger.error("Customer {} not found " + e);
			throw new CustomerNotFoundException("Exception in get Customer Request", e);
		}

		logger.info("Customer Record ID {}" + id);
		return customer;

	}

	public void deleteCustomerById(int id) {
		Optional<Integer> custmerId = null;
		try {
			custmerId = Optional.ofNullable(id);

			customerRepo.deleteById(id);
			if (!custmerId.isPresent()) {

				logger.info("Enter valid cutomer id" + id);
				throw new CustomerNotFoundException("Customer id{} not found-");
			}

		} catch (CannotCreateTransactionException e) {
			logger.error("Database connection error" + e);
			throw new CustomerNotFoundException("Database Connectivity Error", e);
		}

		catch (EmptyResultDataAccessException e) {
			logger.error("Customer id{} not found" + e);
			throw new CustomerNotFoundException("Customer id{} not found", e);
		}

		catch (Exception e) {
			logger.error("Customer {} not found " + e);
			throw new CustomerNotFoundException("Exception in Customer deletion", e);
		}

	}

	public void deleteCustomer(Customer record) {
		Optional<Customer> customer = Optional.ofNullable(record);

		try {
			if (!customer.isPresent()) {

				logger.info("Enter valid cutomer record");
				throw new CustomerNotFoundException("Customers record not found");

			}
			customerRepo.delete(record);

			logger.trace("All Customers have been deleted successfully");
		} catch (CannotCreateTransactionException e) {
			logger.error("Database connection error" + e);
			throw new CustomerNotFoundException("Database Connectivity Error", e);
		} 
		
		catch (EmptyResultDataAccessException e) {
			logger.error("Customers record is empty" + e);
			throw new CustomerNotFoundException("Customer record is empty", e);
		} 
		
		catch (Exception e) {
			logger.error("Customers have not been deleted " + e);
			throw new CustomerNotFoundException("Exception in customers deletion", e);
		}

	}

	public Customer updateCustomer(Customer data) {
		Customer customer = new Customer();
		try {
			if (!Optional.ofNullable(data).isPresent()) {
				throw new CustomerNotFoundException("Customer record not found");
			}
			customer = customerRepo.save(data);

		} catch (CannotCreateTransactionException e) {
			logger.error("Database connection error" + e);
			throw new CustomerNotFoundException("Database Connectivity Error", e);
		}

		catch (CustomerNotFoundException e) {
			logger.error("Customer not found" + e);
			throw new CustomerNotFoundException("Customer not found", e);
		}

		catch (Exception e) {
			logger.error("Customer has not updated " + e);
			throw new CustomerNotFoundException("Exception in customer update", e);
		}

		return customer;
	}

}
