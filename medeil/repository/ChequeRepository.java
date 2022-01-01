package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medeil.domain.Cheque;


public interface ChequeRepository extends JpaRepository<Cheque, Long>{

}
