/**
 * 
 */
package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Employee;

/**
 * @author Manik
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findById(int id);

	// public static final String view = "select *from
	// medc_employee.medc_employeedetails WHERE STATUS!=2";

	@Query(value = "SELECT companyid,companyname FROM medc_companyreg.medc_companyinfomation WHERE CompanyID= :comp", nativeQuery = true)
	List getCompany(@Param("comp") int comp);

	@Query(value = "SELECT branchid,branchname from medc_branchreg.medc_branchinfomation WHERE  branchid= :id ", nativeQuery = true)
	List getBranch(@Param("id") int id);

	// Boopalan 150519 mobileno
	@Query(value = "SELECT emp.employeeID,cmp.companyname,brn.branchname,loc.locationname,concat(IFNULL(shp.shopname,''),IFNULL(whr.warehousename,''),IFNULL(hsp.hospitalname,''))AS name,emp.empfirstname,emplastname,ecd.empmobileno,ede.departmentname,emp.desgination,esde.subdepartmentname,edi.divisionname,esdi.subdivisionname  from medc_employee.medc_employeedetails emp "
			+ " left join medc_adminsecurity.medc_locationref loc on loc.id=emp.locname left join medc_employee.medc_empcontactdetails ecd on ecd.employeeid = emp.employeeID "
			+ " left join medc_storereg.medc_shopinformation shp on shp.shopid=emp.locrefid and emp.locname='1' "
			+ " left join medc_warehousereg.medc_warehouseinfo whr on whr.warehouseid=emp.locrefid and emp.locname='2' "
			+ " left join medc_hospitalreg.hospitalregistration hsp on hsp.hospitalid=emp.locrefid and emp.locname='3' "
			+ " left join medc_companyreg.medc_companyinfomation cmp on cmp.companyid=emp.companyid "
			+ " left join medc_branchreg.medc_branchinfomation brn on brn.branchid=emp.branchid"
			+ " left join medc_employee.medc_empdepartment ede on ede.deptid=emp.deptrefid"
			+ " left join medc_employee.medc_empsubdepartment esde on esde.subdeptid=emp.subdeptrefid"
			+ " left join medc_employee.medc_empdivision edi on edi.divisionid=emp.divisionid"
			+ " left join medc_employee.medc_empsubdivision esdi on esdi.subdivisionid=emp.subdivisionid"
			+ " WHERE emp.companyid=:compid and emp.branchid=:branchid and emp.locname=:locname and emp.locrefid=:locrefid and  emp.status=0 order by emp.employeeID desc ", nativeQuery = true)
	public List viewEmployee(@Param("compid") int compid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid);

	@Query(value = "SELECT employeeID,cmp.companyname,brn.branchname,loc.locationname,concat(IFNULL(shp.shopname,''),IFNULL(whr.warehousename,''),IFNULL(hsp.hospitalname,''))AS name,emp.empfirstname,emplastname,emp.department,emp.division,emp.desgination  from medc_employee.medc_employeedetails emp "
			+ "left join medc_adminsecurity.medc_locationref loc on loc.id=emp.locname "
			+ "left join medc_storereg.medc_shopinformation shp on shp.shopid=emp.locrefid and emp.locname='1' "
			+ "left join medc_warehousereg.medc_warehouseinfo whr on whr.warehouseid=emp.locrefid and emp.locname='2' "
			+ "left join medc_hospitalreg.hospitalregistration hsp on hsp.hospitalid=emp.locrefid and emp.locname='3' "
			+ "left join medc_companyreg.medc_companyinfomation cmp on cmp.companyid=emp.companyid "
			+ "left join medc_branchreg.medc_branchinfomation brn on brn.branchid=emp.branchid WHERE emp.companyid=:compid and emp.branchid= :branchid and emp.locname= :locname and emp.locrefid= :locrefid and emp.status=0 order by employeeID desc", nativeQuery = true)
	public List viewEmployeeByID(@Param("compid") int compid, @Param("branchid") int branchid,
			@Param("locname") int locref, @Param("locrefid") int locid);

	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_employee.medc_employeedetails set Status='2' WHERE EmployeeID= :empId", nativeQuery = true)
	Integer deleteEmployee(@Param("empId") int empId);

	@Query(value = "SELECT companyid,companyname from medc_companyreg.medc_companyinfomation", nativeQuery = true)
	List getCompanies();

	@Query(value = "SELECT branchid,branchname from medc_branchreg.medc_branchinfomation  WHERE  CompanyRefID= :id ", nativeQuery = true)
	List getBranches(@Param("id") int id);

	@Query(value = "SELECT ShopID,ShopName from medc_storereg.medc_shopinformation WHERE  branchid= :id ", nativeQuery = true)
	List getShops(@Param("id") int id);

	@Query(value = "SELECT warehouseid,warehousename from medc_warehousereg.medc_warehouseinfo where branchid=:id", nativeQuery = true)
	List getWareHouse(@Param("id") int id);

	@Query(value = "SELECT hospitalid,hospitalname from medc_hospitalreg.hospitalregistration WHERE  branchrefid= :id ", nativeQuery = true)
	List getHospital(@Param("id") int id);

	@Query(value = "SELECT companyid,companyname from medc_companyreg.medc_companyinfomation WHERE  CompanyID= :id ", nativeQuery = true)
	List getEmpCompany(@Param("id") int id);

	@Query(value = "SELECT branchid,branchname from medc_branchreg.medc_branchinfomation WHERE  branchid= :id ", nativeQuery = true)
	List getEmpBranch(@Param("id") int id);

	@Query(value = "SELECT LocName from medc_employee.medc_employeedetails WHERE  employeeid= :empID ", nativeQuery = true)
	List getLocationName(@Param("empID") int empID);

	@Query(value = "SELECT ShopID,ShopName from medc_storereg.medc_shopinformation WHERE  ShopID= :id ", nativeQuery = true)
	List getEmpShop(@Param("id") int id);

	@Query(value = "SELECT WarehouseID,Warehousename from medc_warehousereg.medc_warehouseinfo WHERE  warehouseid= :id ", nativeQuery = true)
	List getEmpWareHouse(@Param("id") int id);

	@Query(value = "SELECT HospitalID,Hospitalname from medc_hospitalreg.hospitalregistration WHERE  HospitalID= :id ", nativeQuery = true)
	List getEmpHospital(@Param("id") int id);

	@Query(value = "SELECT  empfirstname FROM medc_employee.medc_employeedetails where empfirstname=:emp and status!=2", nativeQuery = true)
	String isExistEmployee(@Param("emp") String emp);

	@Query(value = "SELECT count(*) FROM medc_employee.medc_employeedetails WHERE  empfirstname=:empname and employeeid=:empid", nativeQuery = true)
	Integer isEmployeeUpdateExist(@Param("empname") String empname, @Param("empid") String empid);

	// padmini
	@Query(value = "SELECT coalesce(deptid,0) as deid FROM medc_employee.medc_empdepartment WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid and departmentname= :name", nativeQuery = true)
	Integer selectdeptid(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("name") String name);

	// padmini
	@Query(value = "SELECT coalesce(subdeptid,0) as deid FROM medc_employee.medc_empsubdepartment WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid and subdepartmentname= :name", nativeQuery = true)
	Integer selectsupdeptid(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("name") String name);

	// padmini
	@Query(value = "SELECT departmentname FROM medc_employee.medc_empdepartment WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid and departmentname= :name", nativeQuery = true)
	String checkExistdept(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("name") String name);

	// padmini
	@Query(value = "SELECT count(*)  FROM medc_employee.medc_empsubdepartment WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid and subdepartmentname= :name", nativeQuery = true)
	Integer checkExistsubdept(@Param("compid") int compid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("name") String name);

	// padmini
	@Query(value = "SELECT count(*)  FROM medc_employee.medc_empdivision WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid and divisionname= :name", nativeQuery = true)
	Integer checkExistdivision(@Param("compid") int compid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("name") String name);

	// padmini
	@Query(value = "SELECT count(*)  FROM medc_employee.medc_empsubdivision WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid and subdivisionname= :name", nativeQuery = true)
	Integer checkExistsubdivision(@Param("compid") int compid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("name") String name);

	// padmini
	@Query(value = "SELECT deptid,departmentname FROM medc_employee.medc_empdepartment WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid ", nativeQuery = true)
	List deptname(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);

	// padmini
	@Query(value = "SELECT subdeptid,subdepartmentname FROM medc_employee.medc_empsubdepartment WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid  and deptrefid= :deptrefid ", nativeQuery = true)
	List subdeptname(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("deptrefid") int deptrefid);

	// padmini
	@Query(value = "SELECT divisionid,divisionname FROM medc_employee.medc_empdivision WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid  and deptrefid= :deptrefid and subdeptrefid= :subrefid ", nativeQuery = true)
	List divisionname(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("deptrefid") int deptrefid, @Param("subrefid") int subrefid);

	// padmini
	@Query(value = "SELECT subdivisionid,subdivisionname FROM medc_employee.medc_empsubdivision WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid  and deptrefid= :deptrefid and subdeptrefid= :subrefid and divisionrefid= :divisionrefid ", nativeQuery = true)
	List subdivisionname(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid, @Param("deptrefid") int deptrefid, @Param("subrefid") int subrefid,
			@Param("divisionrefid") int divisionrefid);

	// padmini
	@Query(value = "SELECT divisionid,divisionname FROM medc_employee.medc_empdivision WHERE companyrefid= :compid and branchrefid= :branchid  and locname= :locname  and locrefid= :locrefid ", nativeQuery = true)
	List divname(@Param("compid") int compid, @Param("branchid") int branchid, @Param("locname") int locname,
			@Param("locrefid") int locrefid);


	// Boopalan 071119
	@Modifying
	@Transactional
	@Query(value = "update medc_employee.medc_employeedetails set emphoto=:filepath  where CompanyID =:companyid and BranchID=:branchid and LocName=:locname and locrefid =:locrefid and EmployeeCode =:employeeCode ", nativeQuery = true)
	void employeepath(@Param("filepath") String filepath, @Param("companyid") int companyid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("employeeCode") String employeeCode);

	// Boopalan 071119
//	@Query(value = "select emphoto from medc_employee.medc_employeedetails where employeeid=?1 ", nativeQuery = true)
//	String getEmpImage(@Param("empid") int empid);
	
	@Query(value = "select emphoto from medc_employee.medc_employeedetails where employeeid=?1 ", nativeQuery = true)
	String getEmpImage(Integer empid);
	
	@Query(value = "SELECT s.shoplogo FROM medc_storereg.medc_shopinformation s\r\n" + 
			"INNER JOIN medc_adminsecurity.medc_userlogin ul ON s.ShopID = ul.shopid\r\n" + 
			"WHERE ul.SUserID=?1 ", nativeQuery = true)
	String getShopImage(Integer suserid);

	// Boopalan 071119
	@Modifying
	@Transactional
	@Query(value = "update medc_employee.medc_employeedetails em set em.EmpAddress1=?1 , em. mobileno =?2 ,em.email =?3\r\n" + 
			"where em.employeeid =?4", nativeQuery = true)
	int updateEmployeeProfile(@Param("address") String address, @Param("mobileno") String mobileno,
			@Param("email") String email, @Param("employeeid") int employeeid);

	
	// Raja1116
	@Modifying
	@Transactional
	@Query(value = "update medc_employee.medc_employeedetails set emp_sign =:filepath where CompanyID =:companyid and BranchID=:branchid and LocName=:locname and locrefid =:locrefid and EmployeeCode =:employeeCode  ", nativeQuery = true)
	void employeesignpath(@Param("filepath") String filepath, @Param("companyid") int companyid, @Param("branchid") int branchid,
			@Param("locname") int locname, @Param("locrefid") int locrefid, @Param("employeeCode") String employeeCode);
	
	// Puthiran 120221
	@Modifying
	@Transactional
	@Query(value = "update medc_employee.medc_employeedetails set emphoto =:filepath where EmployeeID =:id", nativeQuery = true)
	void UpdateEmpImagePath(@Param("filepath") String filepath,@Param("id") Integer id);

	@Query(value = "SELECT isadmin,isactive FROM medc_adminsecurity.medc_userlogin where suserid=?1", nativeQuery = true)
	List getempadminflag(Integer userid);

	@Query(value = "SELECT IFNULL(EmpRefID,0) FROM medc_adminsecurity.medc_userlogin where suserid=?1", nativeQuery = true)
	Integer CheckEmporOwner(Integer suserid);

	@Query(value ="SELECT 1,emp.EmployeeID,emp.EmpFirstName,emp.empaddress1,emp.email,emp.mobileno,emp.gender,emp.dob,emp.desgination,emp.employeecode\r\n" + 
			"FROM medc_employee.medc_employeedetails emp WHERE emp.EmployeeID=?1", nativeQuery = true)
	List GetEmployeeDetails(Integer empid);
	
	@Query(value ="SELECT 2,s.ShopID,s.ownername,concat(s.address1,',',s.address2) as address,s.emailid,s.mobileno,c.cityname ,st.statename,co.countryname\r\n" + 
			"FROM medc_storereg.medc_shopinformation s\r\n" + 
			"INNER JOIN medc_adminsecurity.medc_userlogin ul ON s.ShopID = ul.shopid\r\n" + 
			"LEFT JOIN medc_fixedsettings.medc_city c ON c.cityid = s.city\r\n" + 
			"LEFT JOIN medc_fixedsettings.medc_state st ON st.stateid = s.state\r\n" + 
			"LEFT JOIN medc_fixedsettings.medc_country co ON co.countryid = s.country\r\n" + 
			"WHERE ul.SUserID=?1", nativeQuery = true)
	List GetShopDetails(Integer suserid);

	@Query(value ="SELECT (COUNT(EmployeeID)+1) FROM medc_employee.medc_employeedetails WHERE CompanyID = ?1 and BranchID=?2 and LocName=?3 and locrefid=?4", nativeQuery = true)
	Object getEmprefid(Integer companyid, Integer branchid, Integer locname, Integer locrefid);

	

	

}
