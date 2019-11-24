package com.customerApi.api.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.exception.JDBCConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;
=======
import org.springframework.stereotype.Service;
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3

import com.customerApi.api.exception.CustomerNotFoundException;
import com.customerApi.api.modals.Customer;
import com.customerApi.api.repositories.CustomerRepository;

@Service
public class CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository customerRepo;

<<<<<<< HEAD
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
=======
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
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3

	}

	public List<Customer> getCustomersData() {
		List<Customer> allCustomer = null;

		try {
			allCustomer = customerRepo.findAll();
			Optional.of(allCustomer);

<<<<<<< HEAD
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
=======
		} catch (JDBCConnectionException e) {
			logger.error("Database connection error" + e);

		} catch (Exception e) {
			logger.error("Database connection error " + e);
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3
		}

		return allCustomer;
	}

	public Optional<Customer> getCustomerDataById(int id) {

		Optional<Customer> customer = null;
		try {
			customer = customerRepo.findById(id);
<<<<<<< HEAD
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

=======

		} catch (JDBCConnectionException e) {
			logger.error("Database connection error" + e);

		} catch (Exception e) {
			logger.error("Customer {} not found " + e);
		}

		if (!customer.isPresent()) {

			throw new CustomerNotFoundException("id-" + id);

		}
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3
		logger.info("Customer Record ID {}" + id);
		return customer;

	}

	public void deleteCustomerById(int id) {
		Optional<Integer> custmerId = null;
		try {
			custmerId = Optional.ofNullable(id);
<<<<<<< HEAD

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
=======
			if (!custmerId.isPresent()) {

				logger.info("Enter valid cutomer id" + id);
				throw new CustomerNotFoundException("id-" + id);
			}
			customerRepo.deleteById(id);
		} catch (JDBCConnectionException e) {
			logger.error("Database connection error" + e);

		} catch (Exception e) {
			logger.error("Customer {} not found " + e);
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3
		}

	}

	public void deleteCustomer(Customer record) {
		Optional<Customer> customer = Optional.ofNullable(record);

		try {
			if (!customer.isPresent()) {

				logger.info("Enter valid cutomer record");
<<<<<<< HEAD
				throw new CustomerNotFoundException("Customers record not found");
=======
				throw new CustomerNotFoundException("No customer record found");
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3

			}
			customerRepo.delete(record);

			logger.trace("All Customers have been deleted successfully");
<<<<<<< HEAD
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
=======
		} catch (JDBCConnectionException e) {
			logger.error("Database connection error" + e);

		} catch (Exception e) {
			logger.error("Customers have not been deleted " + e);
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3
		}

	}

	public Customer updateCustomer(Customer data) {
<<<<<<< HEAD
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
=======
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
>>>>>>> d420947cdb09f4f696ee057b9392c79fbb730ce3
	}

}
