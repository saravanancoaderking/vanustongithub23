package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.CashManage;

@SuppressWarnings("rawtypes")
@Repository
public interface CashManageRepository extends  JpaRepository<CashManage, Long>{

}
