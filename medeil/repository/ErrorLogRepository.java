package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.ErrorLog;

@Repository
public interface ErrorLogRepository extends JpaRepository<ErrorLog, Integer> {

}
