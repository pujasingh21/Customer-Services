package com.accountApi.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;
import com.accountApi.api.exception.DataBaseConnectionException;
import com.accountApi.api.modal.Account;
import com.accountApi.api.repository.accountRepository;
import com.accountApi.api.exception.AccountNotFoundException;

@Service
public class AccountServices {

	@Autowired
	private accountRepository repo;

	public Account saveAccountDetails(Account account) {
		Account accountInfo = new Account();
		try {
			accountInfo = repo.save(account);
		} catch (CannotCreateTransactionException e) {
			throw new DataBaseConnectionException("Database server connection failure ", e);
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account not found", e);
		} catch (Exception e) {
			throw new AccountNotFoundException("Exception in Account @Post endpoint", e);
		}

		return accountInfo;
	}

	
	public List<Account> fetchAccountDetails() {
		List<Account> accountsDetails = new ArrayList<Account>();
		try {
			accountsDetails=repo.findAll();
		} catch (CannotCreateTransactionException e) {
			throw new DataBaseConnectionException("Database server connection failure ", e);
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account not found", e);
		} catch (Exception e) {
			throw new AccountNotFoundException("Exception in Account @Get endpoint", e);
		}

		return accountsDetails;
	}

	
	public Account fetchAccountDetails(int id) {
		Account accountDetails = new Account();
		try {
			accountDetails = repo.findById(id).orElseThrow(null);
		} catch (CannotCreateTransactionException e) {
			throw new DataBaseConnectionException("Database server connection failure ", e);
		} catch (EmptyResultDataAccessException e) {
			throw new AccountNotFoundException("Account id{} not found", e);
		} catch (Exception e) {
			throw new AccountNotFoundException("Exception in Account @GetById Endpint", e);
		}

		return accountDetails;
	}

	
	public Account updateAccount(Account account) {
		Account accountInfo = new Account();
		try {
			accountInfo = repo.save(account);
		} catch (CannotCreateTransactionException e) {
			throw new DataBaseConnectionException("Database server connection failure ", e);
		} catch (AccountNotFoundException e) {
			throw new AccountNotFoundException("Account not found", e);
		} catch (Exception e) {
			throw new AccountNotFoundException("Exception in Account @Put endpoint", e);
		}
		return accountInfo;
	}

	
	public void deleteById(int id) {
		try {
			repo.deleteById(id);
		} catch (CannotCreateTransactionException e) {
			throw new DataBaseConnectionException("Database server connection failure", e);
		} catch (EmptyResultDataAccessException e) {
			throw new AccountNotFoundException("Account id{} not found", e);
		} catch (Exception e) {
			throw new AccountNotFoundException("Exception in Account @Delete Endpoint", e);
		}

	}

}
