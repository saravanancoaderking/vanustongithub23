package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.SacSectionCode;

@Repository
public interface SacSectionRepository  extends JpaRepository<SacSectionCode, Integer>{

}
