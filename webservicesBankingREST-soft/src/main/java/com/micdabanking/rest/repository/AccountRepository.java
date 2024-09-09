package com.micdabanking.rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.micdabanking.rest.entity.Account;

public interface AccountRepository extends CrudRepository<Account, s>{

	List<Account> findByName(String name);
	
}