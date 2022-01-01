package com.medeil.service;

import java.util.List;

import com.medeil.domain.QaProductMaster;
import com.medeil.domain.QcProductMaster;

public interface DrugQualityService {

	// create qc & update qc
	boolean createQc(QcProductMaster qcProductMaster) throws Exception;
	
	boolean updateQc(Integer id, Integer qcStatus) throws Exception;

    //get all qc
	List<QcProductMaster> getAllQcList() throws Exception;

    //selected qc
	QcProductMaster getSelectedQcList(Integer id) throws Exception;

	// create qa & update qa
	boolean createQa(QcProductMaster qaProductMaster) throws Exception;

	// get all qa
	List<QaProductMaster> getAllQaList() throws Exception;

	// selected qa
	QaProductMaster getSelectedQaList(Integer status) throws Exception;

	// dalete qc and qa reject data
	boolean detete(String type, Integer id) throws Exception;

	boolean updateQa(Integer id, Integer qcStatus)throws Exception;

	

}
