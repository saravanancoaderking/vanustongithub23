package com.medeil.service;

/**
 * @author Boopalan Alagesan
 * @date   27-08-2019
 */
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.Picking;
import com.medeil.domain.PickingProduct;
import com.medeil.repository.PickingProductRepository;
import com.medeil.repository.PickingRepository;

@SuppressWarnings("rawtypes")
@Service
public class PickingService {

	static List plautoincr;
	static Integer pickingid;

	private static Logger logger = LogManager.getLogger();
	@PersistenceContext
	private EntityManager manager;

	@PersistenceContext
	EntityManager em;

	Query query;

	@Autowired
	PickingRepository pickingRepository;

	@Autowired
	PickingProductRepository pickingProductRepository;

	/** METHOD FOR SAVE PICKING - MAIN TABLE **/
	public boolean savePicking(Picking pickingMain) throws Exception {

		// try {

		Integer lastpicid = pickingRepository.getLastPickid(pickingMain.getCompanyrefid(), pickingMain.getBranchrefid(),
				pickingMain.getLocname(), pickingMain.getLocrefid());
		String random = "PIC";
		String compFormat = String.format("%05d", lastpicid);
		String lable = random + compFormat;
		pickingMain.setPicklistno(lable);
		pickingid = pickingRepository.save(pickingMain).getId();
		pickingRepository.updatestatus(pickingMain.getCompanyrefid(), pickingMain.getBranchrefid(),
				pickingMain.getLocname(), pickingMain.getLocrefid(), pickingMain.getSalesorderrefid());
		// padmini
		pickingRepository.updatepicstatus(pickingMain.getCompanyrefid(), pickingMain.getBranchrefid(),
				pickingMain.getLocname(), pickingMain.getLocrefid(), pickingMain.getSalesinvoiceno());
		return true;
		// } catch (Exception cause) {
		// logger.error("Exception in (Picking)Method : savePicking() " + cause);
		// }

		// return false;

	}

	/** METHOD FOR SAVE PICKING PRODUCTS - PRODUCTS DETAILS TABLE **/
	public boolean savePickingProducts(List<PickingProduct> pickingProduct) throws Exception {

		// try {
		for (PickingProduct temp : pickingProduct) {
			int pRefID = pickingProductRepository.pRefID(temp.getCompanyrefid(), temp.getBranchrefid(),
					temp.getLocname(), temp.getLocrefid());
			temp.setPicklistrefid(pRefID);
			pickingProductRepository.save(temp);
		}

		return true;
		// } catch (Exception cause) {
		// logger.error("Exception in (PickingProduct)Method : savePicking() " + cause);
		// }

		// return false;

	}

	/** METHOD FOR SALES ORDER NUMBER LIST **/
	public List getPLsalesorder(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		return pickingRepository.getPLsalesorder(cid, bid, locname, locrefid);
	}

	/** METHOD FOR GETTING DETAILS OF SALES ORDER VALUES **/
	public List getPLSOdetails(Integer soid) throws Exception {
		return pickingRepository.getPLSOdetails(soid);
	}

	/** METHOD FOR GETTING LIST OF EMPLOYEES **/
	public List getPlEmpdetails(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		return pickingRepository.getPlEmpdetails(cid, bid, locname, locrefid);
	}

	/** METHOD FOR LOADING VALUES TO GRID FOR GIVEN SALES INVOICE NUMBER **/
	public List getPLSIproducts(Integer sid) throws Exception {
		return pickingRepository.getPLSIproducts(sid);
	}

	/** METHOD FOR GETTING NEW PICKLISTNO - AUTOINCREMENT **/
	@Transactional
	public void getAutoincrement(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		List val = null;
		try {
			String value = "CALL medc_deliveryprocess.pro_pickautoincrement(?, ?, ?, ?, ?)";
			query = em.createNativeQuery(value);
			query.setParameter(1, "picking");
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

	/** METHOD FOR GETTING LIST OF EMPLOYEES **/
	public List getPickListAll(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		return pickingRepository.getPickListAll(cid, bid, locname, locrefid);
	}

	public boolean checksavePicking(Picking pickingMain) throws Exception {

		// try {
		if (pickingMain.getStatus() == 2) {
			pickingRepository.updatefielddata(pickingMain.getEmprefidsort(), pickingMain.getStatus(),
					pickingMain.getId());
			if (pickingMain.getStatus() == 3) {
				pickingRepository.save_medc_salesordertrack(pickingMain.getSalesorderrefid(), 3,
						pickingMain.getClientmdate());
				// Boopalan 200919 - For saving data
				// medc_status.medc_salesordertrack
			}
			pickingRepository.updatestatus(pickingMain.getCompanyrefid(), pickingMain.getBranchrefid(),
					pickingMain.getLocname(), pickingMain.getLocrefid(), pickingMain.getSalesorderrefid());
			return true;
		}

		else if (pickingMain.getStatus() == 3) {
			pickingRepository.updatefielddata1(pickingMain.getEmprefidapproval(), pickingMain.getStatus(),
					pickingMain.getId());
			if (pickingMain.getStatus() == 3) {
				pickingRepository.save_medc_salesordertrack(pickingMain.getSalesorderrefid(), 3,
						pickingMain.getClientmdate());
				// Boopalan 200919 - For saving data
				// medc_status.medc_salesordertrack
			}
			pickingRepository.updatestatus(pickingMain.getCompanyrefid(), pickingMain.getBranchrefid(),
					pickingMain.getLocname(), pickingMain.getLocrefid(), pickingMain.getSalesorderrefid());
			return true;
		}
		// } catch (Exception cause) {
		// logger.error("Exception in (Picking)Method : checksavePicking() " + cause);
		// }

		return false;

	}

	@Transactional
	public boolean checksavePickingProducts(List<PickingProduct> pickingProduct) throws Exception {
		boolean flag = false;
		try {
			for (int i = 0; i < pickingProduct.size(); i++) {
				System.out.println("trans");
				PickingProduct pk = pickingProduct.get(i);
				String value = "CALL medc_deliveryprocess.medc_picking(? , ? , ? , ? , ? , ? , ? , ?, ? , ? , ? , ? , ? , ? , ?)";
				query = em.createNativeQuery(value);
				query.setParameter(1, pk.getPicklistrefid());
				query.setParameter(2, pk.getDrugproductrefid());
				query.setParameter(3, pk.getBoxqty());
				query.setParameter(4, pk.getStripqty());
				query.setParameter(5, pk.getTabqty());
				query.setParameter(6, pk.getQty());
				query.setParameter(7, pk.getReturnqty());
				query.setParameter(8, pk.getShelfno());
				query.setParameter(9, pk.getRackno());
				query.setParameter(10, pk.getBlockno());
				query.setParameter(11, pk.getAvailqty());
				query.setParameter(12, pk.getPickedqty());
				query.setParameter(13, pk.getInvoiceqty());
				query.setParameter(14, pk.getRemarks());
				query.setParameter(15, "update");
				System.out.println("pro");
				int reVal = query.executeUpdate();
				if (reVal == 1) {
					flag = true;
				} else {
					flag = false;
				}
			}
		} catch (Exception e) {
			logger.error("Exception in Method : checksavePackingProducts() " + e);
			throw new Exception(e);
		}
		return flag;
	}
}
