package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medeil.domain.CustomerType;

public interface CustomerTypeRepository extends JpaRepository<CustomerType,Long> {

	CustomerType save(CustomerType ct);
}
