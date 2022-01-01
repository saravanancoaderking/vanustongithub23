package com.medeil.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Packing;
import com.medeil.domain.PackingMaterial;
import com.medeil.domain.PackingProducts;
import com.medeil.repository.PackingRepository;
import com.medeil.repository.PackingmaterialRepository;
import com.medeil.repository.PackingprodRepository;

@SuppressWarnings("rawtypes")
@Service
public class PackingService {
	static List plautoincr;
	@Autowired
	private PackingRepository pckrepo;
	@Autowired
	private PackingprodRepository pckprodrepo;
	@Autowired
	private PackingmaterialRepository packmatrepo;
	Query query;
	@PersistenceContext
	EntityManager em;
	private static Logger logger = LogManager.getLogger();

	public List packingdata(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname,
			Integer pickid) throws Exception {
		return pckrepo.packingdata(companyrefid, branchrefid, locrefid, locname, pickid);
	}

	public List packingfielddata(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname,
			Integer pickid) throws Exception {
		return pckrepo.packingfielddata(companyrefid, branchrefid, locrefid, locname, pickid);
	}

	public List picklist(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname)
			throws Exception {
		return pckrepo.picklist(companyrefid, branchrefid, locrefid, locname);
	}

	public boolean savePacking(Packing packingMain) throws Exception {

		// try {
		getAutoincrement(packingMain.getCompanyrefid(), packingMain.getBranchrefid(), packingMain.getLocname(),
				packingMain.getLocrefid());
		packingMain.setPackingno(plautoincr.get(0).toString());
		pckrepo.save(packingMain);
		pckrepo.updatestatus(packingMain.getCompanyrefid(), packingMain.getBranchrefid(), packingMain.getLocname(),
				packingMain.getLocrefid(), packingMain.getSalesorderrefid());
		// padmini
		pckrepo.updatepacstatus(packingMain.getCompanyrefid(), packingMain.getBranchrefid(), packingMain.getLocname(),
				packingMain.getLocrefid(), packingMain.getSalesinvoiceno());
		return true;
		// } catch (Exception cause) {
		// logger.error("Exception in (Picking)Method : savePacking() " + cause);
		// }
		// return false;
	}

	public boolean savePackingProducts(List<PackingProducts> packingProduct) throws Exception {

		// try {
		for (PackingProducts temp : packingProduct) {
			int pRefID = pckprodrepo.pRefID(temp.getCompanyrefid(), temp.getBranchrefid(), temp.getLocname(),
					temp.getLocrefid());
			temp.setPackagerefid(pRefID);
			pckprodrepo.save(temp);
		}

		return true;
		// } catch (Exception cause) {
		// logger.error("Exception in (PackingProduct)Method : savePackingProducts() " +
		// cause);
		// }

		// return false;

	}

	public boolean savePackagematerial(PackingMaterial packmaterial) throws Exception {

		// try {
		List ls = pckrepo.exitpackmaterial(packmaterial.getCompanyrefid(), packmaterial.getBranchrefid(),
				packmaterial.getLocname(), packmaterial.getLocrefid(), packmaterial.getPack_materila(),
				packmaterial.getPackage_size());

		if (ls.size() != 0) {
			pckrepo.deletepackmaterial(packmaterial.getCompanyrefid(), packmaterial.getBranchrefid(),
					packmaterial.getLocname(), packmaterial.getLocrefid(), packmaterial.getPack_materila(),
					packmaterial.getPackage_size());

			packmatrepo.save(packmaterial);

		} else {
			System.out.println("inside " + packmaterial.getPack_materila());
			packmatrepo.save(packmaterial);
		}
		return true;
		// } catch (Exception cause) {
		// logger.error("Exception in (Picking)Method : savePackagematerial() " +
		// cause);
		// }

		// return false;

	}

	@Transactional
	public void getAutoincrement(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		List val = null;
		try {
			String value = "CALL medc_deliveryprocess.pro_packautoincrement(?, ?, ?, ?, ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, "packing");
			query.setParameter(2, cid);
			query.setParameter(3, bid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			val = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception in Method : getAutoIncrement() " + e);
			throw new Exception(e);
		}

		plautoincr = val;

	}

	public List packlist(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname)
			throws Exception {
		return pckrepo.packlist(companyrefid, branchrefid, locrefid, locname);
	}

	public List checkpackingdata(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname,
			Integer packid) throws Exception {
		return pckrepo.checkpackingdata(companyrefid, branchrefid, locrefid, locname, packid);
	}

	public List checkpackingfielddata(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname,
			Integer packid) throws Exception {
		return pckrepo.checkpackingfielddata(companyrefid, branchrefid, locrefid, locname, packid);
	}

	public List getpacklist(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname)
			throws Exception {
		return pckrepo.getpacklist(companyrefid, branchrefid, locrefid, locname);
	}

	public boolean checksavePacking(Packing packingMain) throws Exception {

		// try {
		if (packingMain.getStatus() == 2) {
			pckrepo.updatefielddata(packingMain.getEmprefidwrap(), packingMain.getStatus(), packingMain.getId());
			System.out.println("Boopalan " + packingMain.getStatus());
			if (packingMain.getStatus() == 2) {
				pckrepo.save_medc_salesordertrack(packingMain.getSalesorderrefid(), 4, packingMain.getClientmdate());
				// Boopalan 200919 - For saving data
				// medc_status.medc_salesordertrack
			}
			if (packingMain.getStatus() == 3) {
				pckrepo.save_medc_salesordertrack(packingMain.getSalesorderrefid(), 5, packingMain.getClientmdate());
				// Boopalan 200919 - For saving data
				// medc_status.medc_salesordertrack
			}
			pckrepo.updatestatus(packingMain.getCompanyrefid(), packingMain.getBranchrefid(), packingMain.getLocname(),
					packingMain.getLocrefid(), packingMain.getSalesorderrefid());
			return true;
		} else if (packingMain.getStatus() == 3) {
			pckrepo.updatefielddata1(packingMain.getEmprefidlabel(), packingMain.getStatus(), packingMain.getId());
			System.out.println("Boopalan " + packingMain.getStatus());
			if (packingMain.getStatus() == 2) {
				pckrepo.save_medc_salesordertrack(packingMain.getSalesorderrefid(), 4, packingMain.getClientmdate());
				// Boopalan 200919 - For saving data
				// medc_status.medc_salesordertrack
			}
			if (packingMain.getStatus() == 3) {
				pckrepo.save_medc_salesordertrack(packingMain.getSalesorderrefid(), 5, packingMain.getClientmdate());
				// Boopalan 200919 - For saving data
				// medc_status.medc_salesordertrack
			}
			pckrepo.updatestatus(packingMain.getCompanyrefid(), packingMain.getBranchrefid(), packingMain.getLocname(),
					packingMain.getLocrefid(), packingMain.getSalesorderrefid());
			return true;
		}

		// } catch (Exception cause) {
		// logger.error("Exception in (Packing)Method : checksavePacking() " + cause);
		// }
		return false;
	}

	@Transactional
	public Boolean checksavePackingProducts(List<PackingProducts> packingProduct) throws Exception {
		boolean flag = false;
		// try {
		for (int i = 0; i < packingProduct.size(); i++) {
			PackingProducts pk = packingProduct.get(i);
			String value = "CALL medc_deliveryprocess.medc_packing(? , ? , ? , ? , ? , ? , ? , ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, pk.getPackagerefid());
			System.out.println("Boopalan Shankar " + pk.getPackagerefid());
			query.setParameter(2, pk.getDrugproductrefid());
			query.setParameter(3, pk.getBoxqty());
			query.setParameter(4, pk.getStripqty());
			query.setParameter(5, pk.getTabqty());
			query.setParameter(6, pk.getQty());
			query.setParameter(7, pk.getReturnqty());
			query.setParameter(8, "update");
			int reVal = query.executeUpdate();
			if (reVal == 1) {
				flag = true;
			} else {
				flag = false;
			}
		}
		// } catch (Exception e) {
		// logger.error("Exception in Method : checksavePackingProducts() " + e);
		// }
		return flag;
	}

	public List checkedpicklist(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname)
			throws Exception {
		return pckrepo.checkedpicklist(companyrefid, branchrefid, locrefid, locname);
	}

	public List getapprovepacklist(Integer companyrefid, Integer branchrefid, Integer locrefid, Integer locname)
			throws Exception {
		return pckrepo.getapprovepacklist(companyrefid, branchrefid, locrefid, locname);
	}
}
