package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medeil.domain.ServiceProductmaster;

@Repository
public interface ServiceProductmasterRepository extends JpaRepository<ServiceProductmaster, Integer> {

	List<ServiceProductmaster> findByCountryidAndCompanyidAndBranchidAndLocnameAndLocrefid(Integer countryid,
			Integer companyid, Integer branchid, Integer locname, Integer locrefid);

}
