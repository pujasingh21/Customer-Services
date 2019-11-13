package com.customerApi.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.customerApi.api.modals.Customer;
import com.customerApi.api.repositories.CustomerRepository;


@Service
public class CustomerDeleteService {
	
	public static final Logger logger=LoggerFactory.getLogger(CustomerDeleteService.class) ;

	@Autowired
	CustomerRepository repo ;
	
	
	
	public boolean deleteCustomerById(int id)
	{
		Customer customer = new Customer();
		boolean status = false;
			
		logger.info("Inside delete service:"+customer);
		try {
			if(id!=0)
			{
				
				repo.deleteById(id);			
				logger.info("Customer with id: "+id+" has been deleted successfully");
				status= true;
			}
			else
			{
				logger.info("Enter valid cutomer id");
				status= false;
			}
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		
		
		return status;
	}
	
	public boolean deleteCustomer(Customer record)
	{
		boolean status=false;
		try {	
		if(record!=null)
			{
				
				repo.delete(record);;
				logger.info("All Customer has been deleted successfully");
				status= true;
			}
			else
			{
				logger.info("Invalid record");
				status= false;
			}
		}catch(NullPointerException e)
		{
			e.printStackTrace();
		}
			return status;
		
	}
}
