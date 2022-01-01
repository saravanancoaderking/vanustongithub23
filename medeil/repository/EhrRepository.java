package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Ehr;

@Repository
public interface EhrRepository extends JpaRepository<Ehr, Integer> {

}
