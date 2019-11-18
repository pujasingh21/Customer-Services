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
				
				Customer cust=customerRepo.save(customer);
				
				customerId =Optional.of(cust.getId());
				
			
				if (!customerId.isPresent()) {

					logger.error("Customer ID {}" + customerId);
					throw new CustomerNotFoundException(" Customer id-" + customerId);
				}
				
				
				
			}catch(JDBCConnectionException e)
			{
				throw new CustomerNotFoundException("id-" + e);
			}
			
			logger.trace("Customer ID {}" + customerId);
			return customerId;
			
	}

	public List<Customer> getCustomersData() {
		
		return customerRepo.findAll();
	}

	public String getCustomerDataById(int id) {
		
		Optional<Customer> customer = customerRepo.findById(id);

		if (!customer.isPresent()) {

			
			throw new CustomerNotFoundException("id-" + id);

		} else {
			logger.info("Customer ID {}" + id);
			return customerRepo.findById(id).toString();
		}

	}

	public void deleteCustomerById(int id) {
		Customer customer = new Customer();
	
		Optional<Integer> custmerId= Optional.ofNullable(id);
		logger.info("Inside delete service:" + customer);
		
			if (custmerId.isPresent()) {

				customerRepo.deleteById(id);
				
				
			} else {
				logger.info("Enter valid cutomer id"+id);
				throw new CustomerNotFoundException("id-" + id);
				
			}
		

		
	}

	public void deleteCustomer(Customer record) {
		Optional<Customer> customer = Optional.ofNullable(record);
		
			if (customer.isPresent()) {

				customerRepo.delete(record);
				
				logger.trace("All Customers have been deleted successfully");
				
			}	
		

	}

	public Customer updateCustomer(Customer data) {
		customerRepo.save(data);
		logger.trace("Customer record updated successfully");
		return data;
	}

}
