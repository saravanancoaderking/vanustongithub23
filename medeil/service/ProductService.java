package com.medeil.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Product;
import com.medeil.repository.ProductRepository;

@SuppressWarnings("rawtypes")
@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	@SuppressWarnings("unchecked")
	public ResponseEntity<Product> postProduct(Product product) throws Exception {
		// try {
		repository.save(product);
		return ResponseEntity.created(null).body(product);
		// } catch (DataIntegrityViolationException e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.getRootCause().getMessage());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// } catch (Exception e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.toString());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);

		// }
	}

	public List productlist() throws Exception {
		return repository.Productlist();

	}

//	public boolean isProductExist(int cid, String pname) {
//		Integer chk = repository.isProductExist(cid, pname);
//		System.out.println("checking  " + chk);
//		if (chk == 0) {
//			return true;
//		}
//		return false;
//	}

	public List Country() throws Exception {
		System.out.println("hi");
		return repository.Country();
	}

	public Set<String> productDropdown() throws Exception {
		List<Product> findAll = repository.findAll();
		HashSet<String> productList = new HashSet<String>();
		findAll.forEach(p -> {
			productList.add(p.getProductname());
		});
		return productList;
	}

	// Pharmacist Register (Schedule)
	// Raja

	public List getprodschedule() throws Exception {
		System.out.println("Schedule Service");
		return repository.schedule();

	}

	public List getsched(Integer scheduleid, String fromdate, String todate, Integer companyid, Integer locrefid)
			throws Exception {

		if (scheduleid == 0) {
			System.out.println("allscdhule");
			List x = repository.allschedule(fromdate, todate, companyid, locrefid);
			return x;
		} else {
			System.out.println("selectedscdhule");
			return repository.scheduledata(scheduleid, fromdate, todate, companyid, locrefid);

		}
	}
	
	
	public List getallsched(Integer companyid,Integer branchid, Integer locname, Integer locrefid) {
		return repository.getshecdulelist(companyid,branchid,locname,locrefid);
	}

}
