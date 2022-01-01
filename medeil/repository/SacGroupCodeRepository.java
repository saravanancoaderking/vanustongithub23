package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.SacGroup;

@Repository
public interface SacGroupCodeRepository  extends JpaRepository<SacGroup,Integer>{

}
