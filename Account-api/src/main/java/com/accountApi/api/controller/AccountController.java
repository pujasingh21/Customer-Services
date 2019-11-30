package com.accountApi.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountApi.api.modal.Account;
import com.accountApi.api.service.AccountServices;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountServices service;
	
	@PostMapping("/")
	public ResponseEntity<Account> saveAccount(@Valid @RequestBody Account account)
	{
		Account accouninfo = service.saveAccountDetails(account);
		return new ResponseEntity<>(accouninfo,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Account>> fetchAccountDetails()
	{
		List<Account> accountsDetails=service.fetchAccountDetails();
		return new ResponseEntity<>(accountsDetails,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> fetchAccountDetails( @PathVariable("id") int id)
	{
		Account accountDeatils=service.fetchAccountDetails(id);
		return new ResponseEntity<>(accountDeatils,HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<Account> updateAccount(@Valid @RequestBody Account account)
	{
		Account accountInfo=service.updateAccount(account);
		return new ResponseEntity<>(accountInfo,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")	
	public ResponseEntity<Account> deleteById(@PathVariable("id") int id)		
	{
		service.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
