package com.medeil.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.QaProductMaster;
import com.medeil.domain.QcProductMaster;
import com.medeil.domain.VanustonProductMaster;
import com.medeil.repository.DrugRepository;
import com.medeil.repository.QaProductMasterRepository;
import com.medeil.repository.QcProductMasterRepository;
import com.medeil.repository.VanustonProductMasterRepository;
import com.medeil.service.DrugQualityService;

@Service
public class DrugQualityServiceImpl implements DrugQualityService {

	private QcProductMasterRepository qcProductMasterRepos;
	private DrugRepository drugRepository;
	private ModelMapper mapper;
	private VanustonProductMasterRepository vanustonProductMasterRepo;
	private QaProductMasterRepository qaProductMasterRepo;

	@Autowired
	public DrugQualityServiceImpl(QcProductMasterRepository qcProductMasterRepos, DrugRepository drugRepository,
			ModelMapper mapper, VanustonProductMasterRepository vanustonProductMasterRepo,
			QaProductMasterRepository qaProductMasterRepo) {
		super();
		this.qcProductMasterRepos = qcProductMasterRepos;
		this.drugRepository = drugRepository;
		this.mapper = mapper;
		this.vanustonProductMasterRepo = vanustonProductMasterRepo;
		this.qaProductMasterRepo = qaProductMasterRepo;
	}

	@Override
	public boolean createQc(QcProductMaster qcProductMaster) throws Exception {
//		String genericName = drugRepository.getGenericName(qcProductMaster.getGenericid());
//		qcProductMaster.setGeneric_name(genericName);
//		String oldSON = drugRepository.UniformProductCode(qcProductMaster.getCompanyid(), qcProductMaster.getBranchid(),
//				qcProductMaster.getLocname(), qcProductMaster.getLocrefid());
//		String oldInco = oldSON.substring(oldSON.length() - 6, oldSON.length());
//		Long newInco = Long.parseLong(oldInco) + 1;
//		String newSoNo = StringUtils.leftPad(newInco.toString(), 6, "0");
//		String checkuniformcode = "EMSPH" + newSoNo;
//		qcProductMaster.setUniformproductcode(checkuniformcode);
		qcProductMaster.setQcStatus(0);
		qcProductMasterRepos.save(qcProductMaster);
		return true;
	}

	@Override
	public List<QcProductMaster> getAllQcList() throws Exception {
		return qcProductMasterRepos.findAll();
	}

	@Override
	public QcProductMaster getSelectedQcList(Integer id) throws Exception {
		return qcProductMasterRepos.findById(id).get();
	}

	@Override
	public boolean updateQc(Integer id, Integer qcStatus) throws Exception {
		QcProductMaster qcProduct = qcProductMasterRepos.findById(id).get();
		if (qcProduct != null) {
			qcProduct.setQcStatus(qcStatus);
			qcProductMasterRepos.save(qcProduct);
		} else {
			return false;
		}
		return true;
	}

	@Override
	public boolean createQa(QcProductMaster qaProductMaster) throws Exception {
		QaProductMaster qaProductMaster2 = mapper.map(qaProductMaster, QaProductMaster.class);

		qaProductMasterRepo.save(qaProductMaster2);
		// qcProductMasterRepos.delete(qaProductMaster);
		return true;
	}

	@Override
	public List<QaProductMaster> getAllQaList() throws Exception {
		return qaProductMasterRepo.findAll();
	}

	@Override
	public QaProductMaster getSelectedQaList(Integer id) throws Exception {
		return qaProductMasterRepo.findById(id).get();
	}

	/**
	 * to sync qa approval data
	 */
	public void syncVanustonProductMaster() {
		List<QaProductMaster> productMaster = qaProductMasterRepo.findByQaStatus(1);
		if (!productMaster.isEmpty()) {
			List<VanustonProductMaster> vanustonProductMasters = new ArrayList<VanustonProductMaster>();
			for (QaProductMaster qcProductMaster : productMaster) {
				VanustonProductMaster master = mapper.map(qcProductMaster, VanustonProductMaster.class);
				vanustonProductMasters.add(master);
			}
			vanustonProductMasterRepo.saveAll(vanustonProductMasters);
			qaProductMasterRepo.deleteAll(productMaster);
		}
	}

	@Override
	public boolean detete(String type, Integer id) throws Exception {
		if (type.equalsIgnoreCase("qc")) {
			qcProductMasterRepos.deleteById(id);
			return true;

		} else if (type.equalsIgnoreCase("qa")) {
			qaProductMasterRepo.deleteById(id);
			return true;
		}
		return false;
	}

	public void syncQa() {
		List<QcProductMaster> qc = qcProductMasterRepos.findByQcStatus(1);
		List<QaProductMaster> qa = new ArrayList<QaProductMaster>();
		if (!qc.isEmpty()) {
			for (QcProductMaster qcloop : qc) {
				QaProductMaster master = mapper.map(qcloop, QaProductMaster.class);
				master.setQaStatus(qcloop.getQcStatus());
				qa.add(master);
			}
			qaProductMasterRepo.saveAll(qa);
			qcProductMasterRepos.deleteAll(qc);

		}

	}

	@Override
	public boolean updateQa(Integer id, Integer qaStatus) throws Exception {
		QaProductMaster qaProduct = qaProductMasterRepo.findById(id).get();
		if (qaProduct != null) {
			qaProduct.setQaStatus(qaStatus);
			qaProductMasterRepo.save(qaProduct);
		} else {
			return false;
		}
		return true;
	}

}
