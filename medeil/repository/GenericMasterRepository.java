package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.GenericMaster;

@SuppressWarnings("rawtypes")
@Repository
public interface GenericMasterRepository extends JpaRepository<GenericMaster, Long> {

}
