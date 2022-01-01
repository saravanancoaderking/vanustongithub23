package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Customerotp;

@SuppressWarnings("rawtypes")
@Repository

public interface CustomerotpRepository extends JpaRepository<Customerotp, Long> {

}
