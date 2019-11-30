package com.accountApi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountApi.api.modal.Account;

@Repository
public interface accountRepository extends JpaRepository<Account, Integer>{

}
