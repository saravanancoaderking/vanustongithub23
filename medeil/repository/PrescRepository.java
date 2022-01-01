package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Prescription;
import com.medeil.domain.SalesDummy;


@Repository
public interface PrescRepository    extends JpaRepository<Prescription, Long>  {
	
	
	
	Prescription save(Prescription pt);

	List findAll();

	Prescription findById(int id);
	
	




	@Query(value = " SELECT   PatientID, PatientFirstName ,LoyaltyFlag   FROM  medc_patientreg.medc_patientbasicinfo       where  LocName=?1 and LocRefID=?2     ", nativeQuery = true)
	List viewCustomers(int lcrid ,int lcrnm);

	
	@Query(value = " SELECT  DoctorID , DoctorName  FROM medc_doctorreg.doctorregistration       where  LocName=?1 and LocRefID=?2     ", nativeQuery = true)
	List viewDoctors(int lcrid ,int lcrnm);
	
	
	
	
	
	
	
	
	
	

	@Query(value = " SELECT cst.BrandName , cst.ProductDrugID , cst.Quantity     FROM   medc_productmaster.medc_custproductmaster  cst      where     cst.BrandName like  %?1%     and    LocName=?2 and LocRefID=?3    ORDER BY     cst.BrandName  LIMIT 10 ", nativeQuery = true)
	List viewProductNames(String name,int lcrid ,int lcrnm);

	@Query(value = " 	SELECT cst.BrandName ,cst.ProductDrugID ,cst.GenericID, cst.Quantity ,cst.mrp,fd.FoodInteraction  ,  cst.Stripperbox    , cst.Quantityperstrip   FROM   medc_productmaster.medc_custproductmaster  cst      left join  medc_productmaster.medc_foodinteraction  fd    on    cst.GenericID=fd.GenericID    where  cst.ProductDrugID  = ?1      and   cst. LocName=?2 and cst.LocRefID=?3  ", nativeQuery = true)
	List viewProductName(int drg,int lcrid ,int lcrnm);
	
	

	
	

	@Query(value = "  SELECT   IFNULL( max(prescid) ,0)  FROM  medc_clinic.medc_prescription   where      LocName=?1 and LocRefID=?2    ", nativeQuery = true)
	Double viewPrescId(Double lcrid ,Double lcrnm);

	@Query(value = "  SELECT    IFNULL(RIGHT(prcno, 7),0)    FROM   medc_clinic.medc_prescription  where   prescid=?1     and   LocName=?2 and LocRefID=?3 ", nativeQuery = true)
	String  viewPrescIncNo( Double id,Double lcrid ,Double lcrnm);

	
	
	
	
	@Query(value = "   SELECT   prescid,prcno,DATE(ClientCDate1)  FROM   medc_clinic.medc_prescription       where   LocName=?1 and LocRefID=?2   and    Status!=5    ", nativeQuery = true)
	List viewPrescAll(int lcrid ,int lcrnm);
	

	@Query(value = "  SELECT  pt.PatientFirstName,dr.DoctorName , pr. prescid,  pr.ClientCDate1  , pr. docrefid, pr. custrefid, pr. age, pr. gender, pr. weight, pr. temperature, pr. blood_sugar, pr. blood_pressure, pr. diagnosis, pr. remarks, pr. consultation_fee, pr. next_visit, pr. del_flag, pr. createdby  , pr.ClientCDate1  as  cldate , pr. prcno, pr. delflag ,DATE(pr.ClientCDate1)  FROM  medc_clinic.medc_prescription pr   left join ( SELECT PatientID,PatientFirstName  FROM medc_patientreg.medc_patientbasicinfo   where   LocName=?2 and  LocRefID=?3 )  pt   on  pt.PatientID=pr.custrefid left join ( SELECT DoctorID,DoctorName FROM  medc_doctorreg.doctorregistration  where   LocName=?2 and  LocRefID=?3 )  dr   on  dr.DoctorID=pr.docrefid    where   pr.PrescId=?1    and    pr.LocName=?2 and    pr.LocRefID=?3 ", nativeQuery = true)
	List viewPresc(int name,int lcrid ,int lcrnm);
	

	
	
	@Query(value = " SELECT InteractionDesc,?3  as prod1 ,?4  as prod2    FROM medc_productmaster.medc_druginteraction  where  GenericID=?1 and  InteractingGenericID=?2  ", nativeQuery = true)
	List checkInteration(int gen1 ,int gen2,String prod1 ,String prod2);
	
	

	@Modifying
	@Transactional
	@Query(value = "update medc_clinic.medc_prescription    set   Status=5   where   prescid=?1   and  LocName=?2 and LocRefID=?3  ", nativeQuery = true)
	int deletePrescription(int id, int lcrid ,int lcrnm);


}
