package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Damage_stock;

@Repository
public interface DamagestockProductRepository extends JpaRepository<Damage_stock, Long> {
	// DesingRaja
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_stock.medc_mainstock SET qty=((qty)-(:Damagedqty)),damageqty=((damageqty)+(:Damagedqty)),damagedestroystatus=1  WHERE drugproductid =:Stkproductrefid AND batchno =:Batchnumber AND companyrefid=:Companyrefid AND branchrefid =:Branchrefid AND locname =:Locname AND locrefid =:Locrefid", nativeQuery = true)
	public void updatemainstock(@Param("Stkproductrefid") int Stkproductrefi, @Param("Batchnumber") int Batchnumber,
			@Param("Damagedqty") Integer Damagedqty, @Param("Companyrefid") int Companyrefid,
			@Param("Branchrefid") int Branchrefid, @Param("Locname") int Locname, @Param("Locrefid") int Locrefid);

	//Raja
	public Damage_stock findByStkproductrefidAndBatchnumberAndCompanyrefidAndBranchrefidAndLocnameAndLocrefid(
			Integer stkproductrefid, Integer batchnumber, Integer companyrefid, Integer branchrefid, Integer locname,
			Integer locrefid);

}
