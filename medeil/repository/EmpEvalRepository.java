package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.EmpEval;

@SuppressWarnings("rawtypes")
@Repository
public interface EmpEvalRepository extends JpaRepository<EmpEval, Long> {

}
