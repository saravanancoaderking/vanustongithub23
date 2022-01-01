package com.medeil.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.Drug;
import com.medeil.domain.Empdept;
import com.medeil.domain.Empdivision;
import com.medeil.domain.Employee;
import com.medeil.domain.Empsubdept;
import com.medeil.domain.Empsubdivision;
import com.medeil.repository.EmpdeptRepository;
import com.medeil.repository.EmpdivisionRepository;
import com.medeil.repository.EmployeeRepository;
import com.medeil.repository.EmpsubdivisionRepository;
import com.medeil.repository.EmpsupdeptRepository;

@SuppressWarnings("rawtypes")
@Service
public class EmployeeServices {
	static Employee employeeRecord;

	@PersistenceContext
	private EntityManager em;
	Query query;
	private static Logger logger = LogManager.getLogger();
	@Autowired
	EmployeeRepository employeeRepository;
	List list = null;
	// padmini
	@Autowired
	private EmpdeptRepository empdeptRepository;

	@Autowired
	private EmpsubdivisionRepository empsubdivisionRepository;

	@Autowired
	private EmpdivisionRepository empdivisionRepository;

	@Autowired
	private EmpsupdeptRepository empsupdeptRepository;

	public List getCompany(int comp) throws Exception {
		return employeeRepository.getCompany(comp);
	}

	public List getBranch(int brnch) throws Exception {
		return employeeRepository.getBranch(brnch);
	}

	// padmini
	public List dropdownDept(int compid, int branchid, int locname, int locrefid) throws Exception {
		// list = null;
		// try {
		// list = employeeRepository.deptname(compid, branchid, locname, locrefid);

		// } catch (Exception e) {
		// logger.error("Exception in Method : dropdownDept() " + e);
		// }
		return employeeRepository.deptname(compid, branchid, locname, locrefid);
	}

	// padmini
	public List dropdownsubDept(int compid, int branchid, int locname, int locrefid, int deptrefid) throws Exception {
		// list = null;
		// try {
		// list = employeeRepository.subdeptname(compid, branchid, locname, locrefid,
		// deptrefid);

		// } catch (Exception e) {
		// logger.error("Exception in Method : dropdownsubDept() " + e);
		// }
		return employeeRepository.subdeptname(compid, branchid, locname, locrefid, deptrefid);
	}

	// padmini
	public List dropdowndivision(int compid, int branchid, int locname, int locrefid, int deptrefid, int subrefid)
			throws Exception {
		// list = null;
		// try {
		// list = employeeRepository.divisionname(compid, branchid, locname, locrefid,
		// deptrefid, subrefid);

		// } catch (Exception e) {
		// logger.error("Exception in Method : dropdownsubDept() " + e);
		// }
		return employeeRepository.divisionname(compid, branchid, locname, locrefid, deptrefid, subrefid);
	}

	// padmini
	public List dropdownsubdivision(int compid, int branchid, int locname, int locrefid, int deptrefid, int subrefid,
			int divisionrefid) throws Exception {
		// list = null;
		// try {
		// list = employeeRepository.subdivisionname(compid, branchid, locname,
		// locrefid, deptrefid, subrefid,
		// divisionrefid);

		// } catch (Exception e) {
		// logger.error("Exception in Method : dropdownsubDept() " + e);
		// }
		return employeeRepository.subdivisionname(compid, branchid, locname, locrefid, deptrefid, subrefid,
				divisionrefid);
	}

	// padmini
	public List dropdowndiv(int compid, int branchid, int locname, int locrefid) {
		list = null;
		try {
			list = employeeRepository.divname(compid, branchid, locname, locrefid);

		} catch (Exception e) {
			logger.error("Exception in Method : dropdownDept() " + e);
		}
		return list;
	}

	// padmini
	public boolean isExistdept(Integer compid, Integer branchid, Integer locname, Integer locrefid, String name)
			throws Exception {
		boolean flag = false;
		// try {
		String reName = employeeRepository.checkExistdept(compid, branchid, locname, locrefid, name.trim());
		if (name.equalsIgnoreCase(reName)) {
			flag = true;
		} else {
			flag = false;
		}
		// } catch (Exception ex) {
		// logger.error("Exception in Method : checkExistRole : " + ex);
		// }
		return flag;
	}

	// padmini
	public boolean isExistsubdept(Integer compid, Integer branchid, Integer locname, Integer locrefid, String name)
			throws Exception {
		boolean flag = false;
		// try {

		int reName = employeeRepository.checkExistsubdept(compid, branchid, locname, locrefid, name);

		if (reName != 0) {

			flag = true;
		} else {

			flag = false;
		}
		// } catch (Exception ex) {
		// logger.error("Exception in Method : isExistsubdept : " + ex);
		// }
		return flag;
	}

	// padmini
	public boolean isExistdivision(Integer compid, Integer branchid, Integer locname, Integer locrefid, String name)
			throws Exception {
		boolean flag = false;
		// try {

		int reName = employeeRepository.checkExistdivision(compid, branchid, locname, locrefid, name);

		if (reName != 0) {

			flag = true;
		} else {

			flag = false;
		}
		// } catch (Exception ex) {
		// logger.error("Exception in Method : isExistsubdept : " + ex);
		// }
		return flag;
	}

	// padmini
	public boolean isExistsubdivision(Integer compid, Integer branchid, Integer locname, Integer locrefid, String name)
			throws Exception {
		boolean flag = false;
		// try {

		int reName = employeeRepository.checkExistsubdivision(compid, branchid, locname, locrefid, name);

		if (reName != 0) {

			flag = true;
		} else {

			flag = false;
		}
		// } catch (Exception ex) {
		// logger.error("Exception in Method : isExistsubdept : " + ex);
		// }
		return flag;
	}

	// padmini
	public boolean CreatedeptRec(Empdept empdept) throws Exception {
		boolean deptflag = false;
		// try {
		empdeptRepository.save(empdept);
		deptflag = true;
		// } catch (Exception exp) {
		// logger.error("Exception In Method : CreatedeptRec() : " + exp);
		// }
		return deptflag;

	}

	// padmini
	public boolean CreateSubdeptRec(Empsubdept empsubdept) throws Exception {
		boolean subdeptflag = false;
		// try {
		empsupdeptRepository.save(empsubdept);
		subdeptflag = true;
		// } catch (Exception exp) {
		// logger.error("Exception In Method : CreateSubdeptRec() : " + exp);
		// }
		return subdeptflag;

	}

	// padmini
	public boolean CreatedivRec(Empdivision empdivision) throws Exception {
		boolean divflag = false;
		// try {
		empdivisionRepository.save(empdivision);
		divflag = true;
		// } catch (Exception exp) {
		// logger.error("Exception In Method : CreatedivRec() : " + exp);
		// }
		// System.out.println(divflag);
		return divflag;
	}

	// padmini
	public boolean CreatesubdivRec(Empsubdivision empsubdivision) throws Exception {
		boolean subdivflag = false;
		// try {
		empsubdivisionRepository.save(empsubdivision);
		subdivflag = true;
		// } catch (Exception exp) {
		// logger.error("Exception In Method : CreatesubdivRec() : " + exp);
		// }
		return subdivflag;

	}

	// Boopalan 150519 mobileno
	public List viewEmployee(int compid, int branchid, int locname, int locrefid) throws Exception {
		// list = null;
		// try {
		// list = employeeRepository.viewEmployee(compid, branchid, locname, locrefid);

		// } catch (Exception e) {
		// logger.error("Exception in Method : deleteEmployee() " + e);
		// }
		return employeeRepository.viewEmployee(compid, branchid, locname, locrefid);
	}

	public List viewEmployeeByID(int compid, int branchid, int locname, int locrefid) throws Exception {
		// list = null;
		// try {
		// list = employeeRepository.viewEmployeeByID(compid, branchid, locname,
		// locrefid);

		// } catch (Exception e) {
		// logger.error("Exception in Method : deleteEmployee() " + e);
		// }
		return employeeRepository.viewEmployeeByID(compid, branchid, locname, locrefid);
	}

	public Employee editEmployee(int id) throws Exception {
		// Employee emp = null;
		// try {
		// emp = employeeRepository.findById(id);
		// } catch (Exception e) {
		// logger.error("Exception in Method : editEmployee() " + e);
		// }

		return employeeRepository.findById(id);
	}

	@Transactional
	public Employee updateEmployee(Employee employ) {
		Employee emp = null;
		try {
			emp = employeeRepository.save(employ);
		} catch (Exception e) {
			logger.error("Exception in Method : updateEmplyee() " + e);
		}
		return emp;
	}

	public Integer deleteEmployee(int empId) throws Exception {
		// Integer ob = null;
		// try {
		// ob = employeeRepository.deleteEmployee(empId);
		// } catch (Exception e) {
		// logger.error("Exception in Method : deleteEmployee() " + e);
		// }
		return employeeRepository.deleteEmployee(empId);

	}

	/*------------------------------------------------------------------------------------*/
	public List getEmpCompany(int empID) throws Exception {
		Employee emp = employeeRepository.findById(empID);
		return employeeRepository.getEmpCompany(emp.getCompanyid());
	}

	public List getEmpBranch(int empID) throws Exception {
		Employee emp = employeeRepository.findById(empID);
		return employeeRepository.getEmpBranch(emp.getBranchid());
	}

	public List getEmpFirm(int empID) throws Exception {

		Employee emp = employeeRepository.findById(empID);
		List empFirm = null;
		// try {
		if (emp.getLocname() == 1) {
			empFirm = employeeRepository.getEmpShop(emp.getLocrefid());
		}
		if (emp.getLocname() == 2) {

			empFirm = employeeRepository.getEmpWareHouse(emp.getLocrefid());
		}
		if (emp.getLocname() == 3) {
			empFirm = employeeRepository.getEmpHospital(emp.getLocrefid());

		}
		// } catch (Exception e) {
		// // System.out.print("Exception in" + e);
		// }
		return empFirm;
	}

	public List getLocationName(int empID) throws Exception {
		return employeeRepository.getLocationName(empID);
	}

	public List getEmpShop(int empID) throws Exception {
		Employee emp = employeeRepository.findById(empID);
		return employeeRepository.getEmpShop(emp.getLocrefid());

	}

	public List getUserShop(int id) throws Exception {
		return employeeRepository.getEmpShop(id);
	}

	public List getEmpWarehouse(int empID) throws Exception {
		Employee emp = employeeRepository.findById(empID);
		return employeeRepository.getEmpWareHouse(emp.getLocrefid());

	}

	public List getUserWarehouse(int id) throws Exception {
		return employeeRepository.getEmpWareHouse(id);
	}

	public List getEmpHospital(int empID) {
		Employee emp = employeeRepository.findById(empID);
		return employeeRepository.getEmpHospital(emp.getLocrefid());

	}

	public List getUserHospital(int id) throws Exception {
		return employeeRepository.getEmpHospital(id);
	}

	public List getCompanies() throws Exception {
		return employeeRepository.getCompanies();
	}

	public List getBranches(int compId) throws Exception {
		return employeeRepository.getBranches(compId);
	}

	public List getEmpFirm(int locid, int locref) throws Exception {
		List list = null;
		// try {
		if (locid == 1) {
			list = employeeRepository.getEmpShop(locref);
		}
		if (locid == 2) {
			list = employeeRepository.getEmpWareHouse(locref);
		}
		if (locid == 3) {
			list = employeeRepository.getEmpHospital(locref);
		}

		// } catch (Exception e) {
		// }
		return list;
	}

	public List getShops(int brnch) throws Exception {
		return employeeRepository.getShops(brnch);
	}

	public List getWarehouse(int brnch) throws Exception {
		return employeeRepository.getWareHouse(brnch);
	}

	public List getHospital(int brnch) throws Exception {
		return employeeRepository.getHospital(brnch);
	}

	public boolean isEmployeeExist(String emp) throws Exception {
		boolean isExist = false;
		// try {
		String reVal = employeeRepository.isExistEmployee(emp);
		if (reVal != null) {
			isExist = true;
		} else {
			isExist = false;
		}

		// } catch (Exception e) {
		// logger.error("Exception in Method : isBracnExist() " + e);
		// }

		return isExist;
	}

	public boolean isEmployeeUpdateExist(String empname, String empid) {
		boolean isExist = false;
		try {
			int reVal = employeeRepository.isEmployeeUpdateExist(empname, empid);

			if (reVal == 0) {

				isExist = true;
			} else {

				isExist = false;
			}

		} catch (Exception e) {
			logger.error("Exception in Method : isBracnExist() " + e);
		}

		return isExist;
	}

	// Boopalan 06112019
	public boolean employeeSave(Employee emp) throws Exception {

		employeeRecord = emp;
		String random = "EMP";
		String compFormat = String.format("%07d", employeeRepository.getEmprefid(emp.getCompanyid(), emp.getBranchid(),
				emp.getLocname(), emp.getLocrefid()));
		String label = random + compFormat;
		emp.setEmployeecode(label);
		employeeRepository.save(emp);
		return true;
		// } catch (Exception cause) {
		// logger.error("Exception in (employeeSave)Method : createRecord() " + cause);
		// }

		// return false;

	}

	// Puthiran employee update
	public boolean employeeUpdate(Employee emp) throws Exception {

		// try {
		employeeRecord = emp;
		List empcode = this.getAutoincrement(emp.getCompanyid(), emp.getBranchid(), emp.getLocname(),
				emp.getLocrefid());
		String str = (String) empcode.get(0);
		System.out.print("EmpCode" + str);
		emp.setEmployeecode(str);
		employeeRepository.save(emp);
		return true;
		// } catch (Exception cause) {
		// logger.error("Exception in (employeeSave)Method : createRecord() " + cause);
		// }

		// return false;

	}

	// Boopalan 071119
	public String uploadempphoto(MultipartFile file) throws Exception {
		System.out.println("Image Service");
		String filepath = "Undefined Path";
		// Save the uploaded file to this folder
//Local	String UPLOADED_FOLDER = "C://images//employeeimages//";
		String UPLOADED_FOLDER = "//home//medeilpos//Desktop//images//employeeimages//";
		System.out.println("Save path" + UPLOADED_FOLDER);
//		UPLOADED_FOLDER.getParentFile().mkdirs();
		// Server Path
		// C://Users//Administrator//git//medeil//MedeilBoot//EmployeePhoto//
		if (file.isEmpty()) {
			return filepath;
		}

		try {
			System.out.println("Pass try");

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + employeeRecord.getEmpfirstname() + "_"
					+ employeeRecord.getLocrefid() + "_" + employeeRecord.getEmployeecode() + ".png");
			Files.write(path, bytes);
			System.out.println("path" + path.toString());
			filepath = path.toString();
			System.out.println("file path" + filepath);
			System.out.println("company" + employeeRecord.getCompanyid() + "Branch" + employeeRecord.getBranchid()
					+ "Locname" + employeeRecord.getLocname() + "locrefid" + employeeRecord.getLocrefid()
					+ "employecode" + employeeRecord.getEmployeecode());
			employeeRepository.employeepath(filepath, employeeRecord.getCompanyid(), employeeRecord.getBranchid(),
					employeeRecord.getLocname(), employeeRecord.getLocrefid(), employeeRecord.getEmployeecode());
		} catch (IOException e) {
			throw new IOException(e);
		}

		return filepath;
	}

	// Boopalan 071119
	@Transactional
	public List getAutoincrement(int compid, int branchid, int locname, int locrefid) throws Exception {
		List ls = null;
		String a1 = "employee";

		// try {
		String q = "Call medc_employee.pro_empautoincrement(?,?,?,?,?)";
		query = em.createNativeQuery(q);
		query.setParameter(1, a1);
		query.setParameter(2, compid);
		query.setParameter(3, branchid);
		query.setParameter(4, locname);
		query.setParameter(5, locrefid);

		ls = query.getResultList();
		System.out.println("SutoIncrement  :" + ls);
		// } catch (Exception e) {
		// System.out.println("getAutoincrements :" + e);
		// }

		return ls;
	}

	// Boopalan 06112019
	public boolean updateEmployeeProfile(Employee emp) throws Exception {

		// try {

		employeeRepository.updateEmployeeProfile(emp.getEmpaddress1(), emp.getMobileno(), emp.getEmail(), emp.getId());
		return true;
		// } catch (Exception cause) {
		// logger.error("Exception in (updateEmployeeProfile)Method :
		// updateEmployeeProfile() " + cause);
		// }

		// return false;

	}

	public boolean SetEmpImageValues(Employee emp) throws Exception {
		boolean empFlag = false;
		employeeRecord = emp;
		return true;
	}

	public String UpdateEmpImage(MultipartFile file) throws Exception {
		System.out.println("Image Service");
		String filepath = "Undefined Path";
//local	String UPLOADED_FOLDER = "C://images//employeeimages//";
		String UPLOADED_FOLDER = "//home//medeilpos//Desktop//images//employeeimages//";
		System.out.println("Save path" + UPLOADED_FOLDER);
		if (file.isEmpty()) {
			return filepath;
		}

		try {
			System.out.println("Pass try");

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + employeeRecord.getEmpfirstname() + "_"
					+ employeeRecord.getLocrefid() + "_" + employeeRecord.getEmployeecode() + ".png");
			Files.write(path, bytes);
			System.out.println("path" + path.toString());
			filepath = path.toString();
			System.out.println("file path" + filepath);
			employeeRepository.UpdateEmpImagePath(filepath, employeeRecord.getId());
		} catch (IOException e) {
			throw new IOException(e);
		}

		return filepath;
	}

	// Boopalan 071119
	public String uploademployeesignphoto(MultipartFile file) throws Exception {
		String filepath = "Undefined Path";
		// Save the uploaded file to this folder
		String UPLOADED_FOLDER = "//home//medeilpos//Desktop//images//employeesignimages//";
		// Server Path
		// C://Users//Administrator//git//medeil//MedeilBoot//EmployeePhoto//
		if (file.isEmpty()) {
			return filepath;
		}

		try {

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + employeeRecord.getEmpfirstname() + "_"
					+ employeeRecord.getLocrefid() + "_sign_" + employeeRecord.getEmployeecode() + ".png");
			Files.write(path, bytes);
			System.out.println(path.toString());
			filepath = path.toString();
			employeeRepository.employeesignpath(filepath, employeeRecord.getCompanyid(), employeeRecord.getBranchid(),
					employeeRecord.getLocname(), employeeRecord.getLocrefid(), employeeRecord.getEmployeecode());
		} catch (IOException e) {
			// e.printStackTrace();
			throw new IOException(e);
		}

		return filepath;
	}

	public List getempadminflag(Integer userid) {
		// TODO Auto-generated method stub
		return employeeRepository.getempadminflag(userid);
	}

	public List Profileinfo(Integer suserid) throws Exception {
		// List empdetails = null;
		Integer empid = employeeRepository.CheckEmporOwner(suserid);
		System.out.print("Employee: " + empid);
		if (empid > 0) {
			return employeeRepository.GetEmployeeDetails(empid);
		} else {
			return employeeRepository.GetShopDetails(suserid);
		}
		// return empdetails;
	}

}
