package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.PatientAlert;

@SuppressWarnings("rawtypes")
@Repository
public interface PatientAlertRepository extends JpaRepository<PatientAlert, Long> {

	//Get Companies
	@Query(value = "SELECT companyid,companyname from medc_companyreg.medc_companyinfomation", nativeQuery = true)
	List getCompanies();

	
	//Get Branches
	@Query(value = "SELECT branchid,branchname from medc_branchreg.medc_branchinfomation  WHERE  CompanyRefID= :id ", nativeQuery = true)
	List getBranches(@Param("id") int id);

	
	//Get Shops
	@Query(value = "SELECT ShopID,ShopName from medc_storereg.medc_shopinformation WHERE  branchid= :id ", nativeQuery = true)
	List getShops(@Param("id") int id);

	
	//Get WareHouse
	@Query(value = "SELECT warehouseid,warehousename from medc_warehousereg.medc_warehouseinfo where branchid=:id", nativeQuery = true)
	List getWareHouse(@Param("id") int id);

	
	//Get Shops
	@Query(value = "SELECT hospitalid,hospitalname from medc_hospitalreg.hospitalregistration WHERE  branchrefid= :id ", nativeQuery = true)
	List getHospital(@Param("id") int id);

	
	//Get Employee by Company
	@Query(value = "SELECT PatientID,PatientFirstName  from medc_patientreg.medc_patientbasicinfo WHERE  CompanyRefID = :compid", nativeQuery = true)
	List getCompanyPatient(@Param("compid") int compid);
	

	//Get Employee by Branch
	@Query(value = "SELECT PatientID,PatientFirstName  from medc_patientreg.medc_patientbasicinfo WHERE  CompanyRefID=:compid  and BranchRefID= :brnchid", nativeQuery = true)
	List getBranchPatient(@Param("compid") int compid, @Param("brnchid") int brnchid);

	
	//Get Employee by Shop and Hospital and Warehouses
	@Query(value = "SELECT PatientID,PatientFirstName  from medc_patientreg.medc_patientbasicinfo WHERE  CompanyRefID=:compid  and BranchRefID= :brnchid and LocName=:locid", nativeQuery = true)
	List getFirmPatient(@Param("compid") int compid, @Param("brnchid") int brnchid, @Param("locid") int locid);

	//Get 
	@Query(value = "SELECT mobile,email  from medc_patientreg.medc_patientbasicinfo WHERE  patientid= :pid and (status=0 or status=1)", nativeQuery = true)
	List getPatientInfo(@Param("pid") int pid);
	
	

	@Query(value = "SELECT pi.patientfirstname,pi.patientlastname,pa.message,cp.companyname,br.branchname,pi.address1,pi.address2,"
			+ "(SELECT locationname from medc_adminsecurity.medc_locationref loc where loc.id=pa.locname) as Locname,COALESCE(IFNULL(sh.shopname,''),IFNULL(wh.warehousename,''),IFNULL(hp.hospitalname,''))AS name "
			+ "from medc_patientreg.medc_patientalert pa left join  medc_patientreg.medc_patientbasicinfo pi on pa.patientid= pi.patientid "
			+ "left join medc_companyreg.medc_companyinfomation cp on cp.companyid=pa.companyrefid "
			+ "left join medc_branchreg.medc_branchinfomation br on br.branchid=pa.locrefid "
			+ "left join medc_storereg.medc_shopinformation sh on sh.locname=pa.locname and pa.locrefid=sh.shopid "
			+ "left join medc_hospitalreg.hospitalregistration hp on hp.locname=pa.locname and pa.locrefid=hp.hospitalid "
			+ "left join medc_warehousereg.medc_warehouseinfo wh on wh.locname=pa.locname and pa.locrefid=wh.warehouseid WHERE pa.CompanyRefID=:comp and pa.BranchRefID=:brnch and pa.LocName=:loc and pa.LocRefID=:locref order by pi.patientid desc", nativeQuery = true)
	public List viewPatientAlert(@Param("comp") int comp,@Param("brnch") int brnch,@Param("loc") int loc,@Param("locref") int locref);
	
	
	
	/*--------------------------------------------------------------------------------------------------------*/

}
