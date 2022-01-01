package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Plan;
@SuppressWarnings("rawtypes")
@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{


}
