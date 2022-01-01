package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Closeregister;

@SuppressWarnings("rawtypes")
@Repository
public interface CloseRegisterRepository extends JpaRepository<Closeregister, Long>{

}
