package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.QaProductMaster;
import com.medeil.domain.QcProductMaster;

@Repository
public interface QcProductMasterRepository extends JpaRepository<QcProductMaster, Integer> {

	List<QcProductMaster> findByQcStatus(int i);



//	List<QcProductMaster> findByQcStatus(String status);

//	List<QcProductMaster> findAllByQaflag(int i);

//	List<QcProductMaster> findByQcStatus(String status);

}
