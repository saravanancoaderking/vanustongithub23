package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.CustomerDelivery;

@SuppressWarnings("rawtypes")
@Repository
public interface CustomerdeliveryRepositoy extends JpaRepository<CustomerDelivery, Long>{

}
