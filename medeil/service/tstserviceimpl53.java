package com.medeil.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Patient;
import com.medeil.repository.PatientRepository;

@Service
public class tstserviceimpl53 {

	private final PatientRepository custRepo;

	@Autowired
	tstserviceimpl53(PatientRepository custRepo) {

		this.custRepo = custRepo;
	}

	@Transactional
	public List viewcustomer() throws Exception {

		return custRepo.findAll();
	}

	@Transactional
	public void saveCustomer() throws Exception {
		Patient cust = new Patient();

		cust.setAddress1("dsdsdsdsdas");

		custRepo.save(cust);

	}

	public void updatecustomer379(Patient cust) throws Exception {
		Patient cust2 = new Patient();
		// cust2=custRepo.findById(3);

		custRepo.save(cust2);
	}

}
