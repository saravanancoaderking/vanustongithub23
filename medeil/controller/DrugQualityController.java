package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.QaProductMaster;
import com.medeil.domain.QcProductMaster;
import com.medeil.service.DrugQualityService;
import com.medeil.service.Impl.DrugQualityServiceImpl;

@RestController
@RequestMapping("api")
public class DrugQualityController {

	private DrugQualityService drugQualityService;
	private DrugQualityServiceImpl drugQualityServiceImpl;

	@Autowired
	public DrugQualityController(DrugQualityService drugQualityService, DrugQualityServiceImpl drugQualityServiceImpl) {
		super();
		this.drugQualityService = drugQualityService;
		this.drugQualityServiceImpl = drugQualityServiceImpl;
	}

	/**
	 * @param qcProductMaster
	 * @return
	 * @throws Exception
	 */
	@PostMapping("create-qc")
	public boolean createQc(@RequestBody QcProductMaster qcProductMaster) throws Exception {
		return drugQualityService.createQc(qcProductMaster);
	}

	/**
	 * @return
	 * @throws Exception
	 */
	@GetMapping("getAllQcList")
	public List<QcProductMaster> getAllQcList() throws Exception {
		return drugQualityService.getAllQcList();
	}

	/**
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@GetMapping("getSelectedQc/{id}")
	public QcProductMaster getSelectedQcList(@PathVariable Integer id) throws Exception {
		return drugQualityService.getSelectedQcList(id);
	}

	@GetMapping("updateQc/{id}/{qcStatus}")
	public boolean updateQc(@PathVariable Integer id,@PathVariable Integer qcStatus) throws Exception {
		return drugQualityService.updateQc(id, qcStatus);
	}
	

	 @Scheduled(fixedDelay = 5000)
	@GetMapping(value = "qc-approval-to-qa-sync")
	public void syncQa() {
		drugQualityServiceImpl.syncQa();
	}


	/**
	 * @param qaProductMaster
	 * @return
	 * @throws Exception
	 */
	@PostMapping("create-qa")
	public boolean createQa(@RequestBody QcProductMaster qaProductMaster) throws Exception {
		return drugQualityService.createQa(qaProductMaster);
	}

	/**
	 * @return
	 * @throws Exception
	 */
	@GetMapping("getAllQaList")
	public List<QaProductMaster> getAllQaList() throws Exception {
		return drugQualityService.getAllQaList();
	}

	/**
	 * @param status
	 * @return
	 * @throws Exception
	 */
	@GetMapping("getSelectedQa/{id}")
	public QaProductMaster getSelectedQaList(@PathVariable Integer id) throws Exception {
		return drugQualityService.getSelectedQaList(id);
	}
	
	@GetMapping("updateQa/{id}/{qcStatus}")
	public boolean updateQa(@PathVariable Integer id,@PathVariable Integer qcStatus) throws Exception {
		return drugQualityService.updateQa(id, qcStatus);
	}
	


	 @Scheduled(fixedDelay = 6000)
	@GetMapping(value = "sync-vanuston-product-master")
	public void syncVanustonProductMaster() {
		drugQualityServiceImpl.syncVanustonProductMaster();
	}

	/**
	 * @param type
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("deleted-qc-qa")
	public boolean detete(@PathVariable String type, @PathVariable Integer id) throws Exception {
		return drugQualityService.detete(type, id);
	}

}
