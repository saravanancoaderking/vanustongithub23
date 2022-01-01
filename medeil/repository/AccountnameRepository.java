package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.AccountName;

@Repository
public interface AccountnameRepository extends JpaRepository<AccountName, Long>{

	boolean existsByAccountname(String accountname);

	AccountName findByAccountname(String accountname);

}