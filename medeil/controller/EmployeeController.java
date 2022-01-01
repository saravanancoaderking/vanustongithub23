/**
 * 
 */
package com.medeil.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.Empdept;
import com.medeil.domain.Empdivision;
import com.medeil.domain.Employee;
import com.medeil.domain.Empsubdept;
import com.medeil.domain.Empsubdivision;
//import com.medeil.repository.EmpdeptRepository;
import com.medeil.repository.EmployeeRepository;
import com.medeil.service.EmployeeServices;

/**
 * @author Manik
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class EmployeeController {

	@PersistenceContext
	EntityManager em;

	Query query;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeServices employeeServices;

	@GetMapping(value = "/getUtilityCompany/{comp}")
	public List getCompanyByID(@PathVariable Integer comp) throws Exception {
		return employeeServices.getCompany(comp);
	}

	@GetMapping(value = "/getUtilityBranch/{brnch}")
	public List getBranchByID(@PathVariable Integer brnch) throws Exception {
		return employeeServices.getBranch(brnch);
	}

	// padmini
	@GetMapping(value = "/isExistdept/{compid}/{branchid}/{locname}/{locrefid}/{name}")
	public boolean isExistdept(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable String name) throws Exception {
		return employeeServices.isExistdept(compid, branchid, locname, locrefid, name);
	}

	// padmini
	@GetMapping(value = "/isExistsubdept/{compid}/{branchid}/{locname}/{locrefid}/{name}")
	public boolean isExistsubdept(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable String name) throws Exception {
		return employeeServices.isExistsubdept(compid, branchid, locname, locrefid, name);
	}

	// padmini
	@GetMapping(value = "/isExistdivision/{compid}/{branchid}/{locname}/{locrefid}/{name}")
	public boolean isExistdivision(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable String name) throws Exception {
		return employeeServices.isExistdivision(compid, branchid, locname, locrefid, name);
	}

	// padmini
	@GetMapping(value = "/isExistsubdivision/{compid}/{branchid}/{locname}/{locrefid}/{name}")
	public boolean isExistsubdivision(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable String name) throws Exception {
		return employeeServices.isExistsubdivision(compid, branchid, locname, locrefid, name);
	}

	// padmini
	@GetMapping(value = "/dropdownDept/{compid}/{branchid}/{locname}/{locrefid}")
	public List dropdownDept(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return employeeServices.dropdownDept(compid, branchid, locname, locrefid);
	}

	// padmini
	@GetMapping(value = "/dropdownsubDept/{compid}/{branchid}/{locname}/{locrefid}/{deptrefid}")
	public List dropdownsubDept(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer deptrefid)
			throws Exception {
		return employeeServices.dropdownsubDept(compid, branchid, locname, locrefid, deptrefid);
	}

	// padmini
	@GetMapping(value = "/dropdowndivision/{compid}/{branchid}/{locname}/{locrefid}/{deptrefid}/{subrefid}")
	public List dropdowndivision(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer deptrefid,
			@PathVariable Integer subrefid) throws Exception {
		return employeeServices.dropdowndivision(compid, branchid, locname, locrefid, deptrefid, subrefid);
	}

	// padmini
	@GetMapping(value = "/dropdownsubdivision/{compid}/{branchid}/{locname}/{locrefid}/{deptrefid}/{subrefid}/{divisionrefid}")
	public List dropdownsubdivision(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer deptrefid,
			@PathVariable Integer subrefid, @PathVariable Integer divisionrefid) throws Exception {
		return employeeServices.dropdownsubdivision(compid, branchid, locname, locrefid, deptrefid, subrefid,
				divisionrefid);
	}

	// padmini
	@PostMapping(value = "/CreatedeptRec")
	public boolean CreatedeptRec(@RequestBody Empdept empdept) throws Exception {
		return employeeServices.CreatedeptRec(empdept);
	}

	// padmini
	@PostMapping(value = "/CreateSubdeptRec")
	public boolean CreateSubdeptRec(@RequestBody Empsubdept empsubdept) throws Exception {
		return employeeServices.CreateSubdeptRec(empsubdept);
	}

	// padmini
	@PostMapping(value = "/CreatedivRec")
	public boolean CreatedivRec(@RequestBody Empdivision empdivision) throws Exception {
		// System.out.println(employeeServices.CreatedivRec(empdivision));
		return employeeServices.CreatedivRec(empdivision);
	}

	// padmini
	@PostMapping(value = "/CreatesubdivRec")
	public boolean CreatesubdivRec(@RequestBody Empsubdivision empsubdivision) throws Exception {
		return employeeServices.CreatesubdivRec(empsubdivision);
	}

	// padmini
	@PostMapping(value = "/empcreateRecord")
	public boolean employeeSave(@RequestBody Employee emp) throws Exception {

		employeeServices.employeeSave(emp);
		return true;
	}

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

	// Boopalan 150519 mobileno
	@GetMapping("/viewEmployee/{compid}/{branchid}/{locname}/{locrefid}")
	public List viewEmployee1(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return employeeServices.viewEmployee(compid, branchid, locname, locrefid);
	}

	@GetMapping("/viewEmployeebyid/{compid}/{branchid}/{locname}/{locrefid}")
	public List viewEmployee(@PathVariable Integer compid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return employeeServices.viewEmployeeByID(compid, branchid, locname, locrefid);
	}

	@GetMapping("/editEmployee/{id}")
	public Employee editEmployee(@PathVariable Integer id) throws Exception {
		return employeeServices.editEmployee(id);
	}

	@PostMapping(value = "/updateEmployee")
	public boolean EmployeeupdateEmp(@RequestBody Employee emp) throws Exception {
		// return employeeRepository.save(emp);
		employeeServices.employeeUpdate(emp);
		return true;
	}

	@GetMapping("/deleteEmployee/{id}")
	public Integer deleteEmployee(@PathVariable Integer id) throws Exception {
		return employeeServices.deleteEmployee(id);
	}

	@GetMapping(value = "/getEmpCompanyById/{id}")
	public List getEmpCompany(@PathVariable Integer id) throws Exception {
		return employeeServices.getEmpCompany(id);
	}

	@GetMapping(value = "/getEmpBranchById/{id}")
	public List getEmpBranch(@PathVariable Integer id) throws Exception {
		return employeeServices.getEmpBranch(id);
	}

	// get Employee's By ShopID
	@GetMapping(value = "/getEditEmpFirm/{id}")
	public List getEmpFirm(@PathVariable Integer id) throws Exception {
		return employeeServices.getEmpFirm(id);
	}

	// get Employee's By ShopID
	@GetMapping(value = "/getEmpLocationid/{id}")
	public List getLocationName(@PathVariable Integer id) throws Exception {
		return employeeServices.getLocationName(id);
	}

	// get Employee's By ShopID
	@GetMapping(value = "/getEmpShopById/{id}")
	public List getEmpShop(@PathVariable Integer id) throws Exception {
		return employeeServices.getEmpShop(id);
	}

	// get Employee's By ShopID
	@GetMapping(value = "/getEmpWarehouseById/{id}")
	public List getEmpWarehouse(@PathVariable Integer id) throws Exception {
		return employeeServices.getEmpWarehouse(id);
	}

	// get Employee's By ShopID
	@GetMapping(value = "/getEmpHospitalById/{id}")
	public List getEmpHospital(@PathVariable Integer id) throws Exception {
		return employeeServices.getEmpShop(id);
	}

	// get Employee's Company
	@GetMapping(value = "/getEmpCompany")
	public List getCompany() throws Exception {
		return employeeServices.getCompanies();
	}

//	 get Employee's Branch
	@GetMapping(value = "/getEmpBranch/{id}")
	public List getBranch(@PathVariable Integer id) throws Exception {
		return employeeServices.getBranches(id);
	}

	// get Employee's Shop

	@GetMapping(value = "/getEmpFirm/{loc}/{locref}")
	public List getEmpFirm(@PathVariable Integer loc, @PathVariable Integer locref) throws Exception {
		return employeeServices.getEmpFirm(loc, locref);
	}

	@GetMapping(value = "/getEmpShops/{id}")
	public List getShops(@PathVariable Integer id) throws Exception {
		return employeeServices.getShops(id);
	}

	@GetMapping(value = "/getusershop/{id}")
	public List getUserShops(@PathVariable Integer id) throws Exception {
		return employeeServices.getUserShop(id);
	}

	@GetMapping(value = "/getuserwarehouse/{id}")
	public List getUserWarehouse(@PathVariable Integer id) throws Exception {
		return employeeServices.getUserWarehouse(id);
	}

	@GetMapping(value = "/getuserhospital/{id}")
	public List getUserHospital(@PathVariable Integer id) throws Exception {
		return employeeServices.getUserHospital(id);
	}

	@GetMapping(value = "/getEmpWareHouses/{id}")
	public List getWarehouse(@PathVariable Integer id) throws Exception {
		return employeeServices.getWarehouse(id);
	}

	@GetMapping(value = "/getEmpHospitals/{id}")
	public List getHospital(@PathVariable Integer id) throws Exception {
		return employeeServices.getHospital(id);
	}

	@GetMapping(value = "/isEmployeeExist/{emp}")
	public boolean isEmployeeExist(@PathVariable String emp) throws Exception {
		return employeeServices.isEmployeeExist(emp);
	}

	@GetMapping(value = "/isEmployeeUpdateExist/{empname}/{empid}/{cmpid}/{brnid}/{locid}/{locrefname}")
	public boolean isEmployeeExist(@PathVariable String empname, @PathVariable String empid, @PathVariable String cmpid,
			@PathVariable String brnid, @PathVariable String locid, @PathVariable String locrefname) throws Exception {
		// return
		// employeeServices.isEmployeeUpdateExist(empname,empid,cmpid,brnid,locid,locrefname);
		return true;
	}

	// Boopalan041119 //Puthiran 12/02/21
	@GetMapping(value = "/profileinfo/{suserid}")
	public List Profileinfo(@PathVariable Integer suserid) throws Exception {
		return employeeServices.Profileinfo(suserid);
	}

	/***********
	 * Employee Photo Upload
	 * 
	 * @throws Exception
	 ***************/
	// Boopalan 071119
	@PostMapping(value = "/uploademployeephoto")
	public boolean employeephoto(@RequestPart("file") MultipartFile file) throws Exception {
		System.out.println("image testing..");
		// try {
		employeeServices.uploadempphoto(file);
		System.out.println("return image..");
		return true;
		// } catch (Exception e) {

		// return false;
		// }
	}

	/*********** View Employee Photo ***************/
	// Boopalan 071119	//Puthiran 120221
	@GetMapping(value = "/getsendImage/{suserid}")
	public Map<String, String> getsendImage(@PathVariable Integer suserid) throws IOException {
		Map<String, String> jsonMap = new HashMap<>();
		Integer empid=employeeRepository.CheckEmporOwner(suserid);
		String path="";
		String shemflag="2";
		if(empid > 0) {
			path = employeeRepository.getEmpImage(empid);
			shemflag="1";
		}else {				
			path = employeeRepository.getShopImage(suserid);
			shemflag="2";
		}
		File serverFile = new File(path);
		String encodeImage = Base64.getEncoder().withoutPadding()
				.encodeToString(Files.readAllBytes(serverFile.toPath()));
		System.out.println("saves"+encodeImage);
		jsonMap.put("flag", shemflag);
		jsonMap.put("content", encodeImage);
		return jsonMap;
	}

	@PostMapping(value = "/updateEmployeeProfile")
	public boolean updateEmployeeProfile(@RequestBody Employee emp) throws Exception {
		return employeeServices.updateEmployeeProfile(emp);
	}
	
	@PostMapping("/empimageset-values")
	public Boolean SetEmpImageValues(@RequestBody Employee emp) throws Exception {
		employeeServices.SetEmpImageValues(emp);
		return true;
	}
	
	@PostMapping(value = "/updateempimage")
	public boolean UpdateEmpImage(@RequestPart("file") MultipartFile file) throws Exception {
		System.out.println("image testing..");
		employeeServices.UpdateEmpImage(file);
		System.out.println("return image..");
		return true;
	}

	/***********
	 * Employee Sign Upload
	 * 
	 * @throws Exception
	 ***************/
	// Raja1116
	@PostMapping(value = "/saveemployeesignimage")
	public boolean uploademployeesignphoto(@RequestPart("file") MultipartFile file) throws Exception {
		// try {
		employeeServices.uploademployeesignphoto(file);
		return true;
		// } catch (Exception e) {

		// return false;
		// }
	}
	
	//Puthiran Get Employee Admin Flag
	@GetMapping(value = "/getempadminflag/{userid}")
	public List getempadminflag(@PathVariable Integer userid) throws Exception {
		return employeeServices.getempadminflag(userid);
	}

}
