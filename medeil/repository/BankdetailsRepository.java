package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medeil.domain.BankDetails;



public interface BankdetailsRepository extends JpaRepository<BankDetails, Long>{

	
	BankDetails findById(Integer id);

	@Query(value = "SELECT bankid,bankname,Accnumber,branch FROM medc_bank.medc_bankdetails where companyrefid =?1 and branchrefid =?2 and shoprefid =?3",nativeQuery = true)
	List bankAccountno(Integer cid, Integer bid, Integer sid);
}
