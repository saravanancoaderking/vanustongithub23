package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Customerpayments;

@SuppressWarnings("rawtypes")
@Repository

public interface CustomerpaymentsRepository extends JpaRepository<Customerpayments,Long> {

}
