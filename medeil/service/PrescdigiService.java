/**
 * 
 */
package com.medeil.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medeil.domain.Prescdigiproduct;
import com.medeil.domain.Prescdigitalization;
import com.medeil.repository.PrescdigiRepository;
import com.medeil.repository.PrescdigiproRepository;

/**
 * @author www
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class PrescdigiService {
	@PersistenceContext
	private EntityManager manager;

	@PersistenceContext
	EntityManager em;

	@Autowired
	private HttpSession session;

	List list;

	Query query;
	private static Logger logger = LogManager.getLogger();

	@Autowired
	private PrescdigiRepository prescdigirepository;

	@Autowired
	private PrescdigiproRepository prescProdRepository;

	public List getsales(Integer cid, Integer bid, Integer locrefid, Integer locname) throws Exception {

		return prescdigirepository.getsalesoder(cid, bid, locrefid, locname);
	}

	public List getsalesordetail(Integer orderid) throws Exception {

		return prescdigirepository.getsalesoderdetail(orderid);
	}

	public List getomnisalesordetail(Integer orderid) throws Exception {

		return prescdigirepository.getomnisalesoderdetail(orderid);
	}

	public List getprodetail(Integer cid, Integer bid, Integer locrefid, Integer locname, String val) throws Exception {
		// List list = null;
		// try {
		// list = prescdigirepository.getproduct(val, cid);

		// } catch (Exception e) {
		// logger.error("Exception in Method : getBrandlist() " + e);
		// }
		return prescdigirepository.getproduct(val, cid);

	}

	/** METHOD FOR GETTING LIST OF EMPLOYEES **/
	public List getPlEmpdetails(Integer cid, Integer bid, Integer locname, Integer locrefid) throws Exception {
		return prescdigirepository.getPlEmpdetails(cid, bid, locname, locrefid);
	}

	public List getproduct(Integer compid, Integer brandid) throws Exception {
		// List list = null;
		// try {
		// list = prescdigirepository.getproduct1(compid, brandid);

		// } catch (Exception e) {
		// logger.error("Exception in Method : getBrandlist() " + e);
		// }
		return prescdigirepository.getproduct1(compid, brandid);

	}

	public boolean Saveprescdigi(Prescdigitalization prescdi) throws Exception {
		boolean flag = false;
		// try {
		if (!prescdi.equals("")) {

			String oldPdigitalizedno = prescdigirepository.lastpdigitalizedno(prescdi.getCompanyrefid(),
					prescdi.getBranchrefid(), prescdi.getLocname(), prescdi.getLocrefid());

			String oldInco = oldPdigitalizedno.substring(oldPdigitalizedno.length() - 9, oldPdigitalizedno.length());
			Long newInco = Long.parseLong(oldInco) + 1;
			String newPdigitalizedno = StringUtils.leftPad(newInco.toString(), 9, "0");

			prescdi.setPdigitalizedno("PRS" + newPdigitalizedno);
			prescdigirepository.save(prescdi);

			prescdigirepository.setstatus(prescdi.getCompanyrefid(), prescdi.getBranchrefid(), prescdi.getLocname(),
					prescdi.getLocrefid(), prescdi.getSalesorderid());
			flag = true;
		} else {
			flag = false;
		}
		// } catch (Exception ex) {
		// logger.error("Exception in Method : Prescdigitalization : " + ex);
		// }
		return flag;
	}

	public boolean Saveprescdigitable(List<Prescdigiproduct> prescdigiproduct) throws Exception {
		boolean saveflag = false;
		int prescpro = 0;
		prescpro = prescdigirepository.selectmaxpri(prescdigiproduct.get(0).getCompanyrefid(),
				prescdigiproduct.get(0).getBranchrefid(), prescdigiproduct.get(0).getLocname(),
				prescdigiproduct.get(0).getLocrefid());
		System.out.println("prescpro:" + prescpro);
		for (Prescdigiproduct temp : prescdigiproduct) {

			temp.setPdigitalizedrefid(prescpro);
			System.out.println("inside product:" + prescpro);

			prescProdRepository.save(temp);
		}
		try {
			List ls = null;
			String q = "Call medc_sales.medc_presstockvalidate(?,?,?,?,?)";
			query = em.createNativeQuery(q);
			query.setParameter(1, prescdigiproduct.get(0).getCompanyrefid());
			query.setParameter(2, prescdigiproduct.get(0).getBranchrefid());
			query.setParameter(3, prescdigiproduct.get(0).getLocname());
			query.setParameter(4, prescdigiproduct.get(0).getLocrefid());
			query.setParameter(5, prescpro);
			ls = query.getResultList();
		} catch (Exception e) {
			System.out.println("medc_presstockvalidate  :" + e);
			throw new Exception(e);
		}

		Integer[][] drugs = prescdigirepository.drugidprescvalidate();
		List countsize = prescdigirepository.countprescvalidate();
		for (int i = 0; i < countsize.size(); i++) {
			if (drugs[i][1] == 1) {
				// prescdigirepository.
			} else {

			}
		}
		saveflag = true;
		return saveflag;

	}

	@Transactional
	public List getAutoincrement(int compid, int branchid, int locname, int locrefid) throws Exception {
		List ls = null;
		String a1 = "prescriptiondigi";

		try {
			String q = "Call medc_stock.pro_autoincrement(?,?,?,?,?,?)";
			query = em.createNativeQuery(q);
			query.setParameter(1, a1);
			query.setParameter(2, compid);
			query.setParameter(3, branchid);
			query.setParameter(4, locname);
			query.setParameter(5, locrefid);
			query.setParameter(6, 0);
			ls = query.getResultList();
		} catch (Exception e) {
			System.out.println("getAutoincrements  :" + e);
			throw new Exception(e);
		}

		return ls;
	}

//for checking process PrescDigi Number
	public List prescdigi(Integer compid, Integer brandid, Integer locname, Integer locrefid) throws Exception {

		return prescdigirepository.getprescdigino(compid, brandid, locname, locrefid);
	}

	public List prescdigino(Integer compid, Integer brandid, Integer locname, Integer locrefid, Integer prescdigino)
			throws Exception {
		// list = null;
		// try {
		// list = prescdigirepository.getprescdata(compid, brandid, locname, locrefid,
		// prescdigino);
		// System.out.println("inside dervice prescdigino" + list.get(0));
		// } catch (Exception e) {
		// logger.error("Exception in Method :prescdigino() " + e);
		// }
		// System.out.println("inside service ");

		return prescdigirepository.getprescdata(compid, brandid, locname, locrefid, prescdigino);
	}

	public List prescheckprod(Integer compid, Integer brandid, Integer locname, Integer locrefid, Integer prescdigino)
			throws Exception {
		// list = null;
		// try {
		// list = prescdigirepository.getprescprod(compid, brandid, locname, locrefid,
		// prescdigino);
		// System.out.println("inside dervice prescheckprod" + list.get(0));
		// } catch (Exception e) {
		// logger.error("Exception in Method :prescheckprod() " + e);

		// }
		return prescdigirepository.getprescprod(compid, brandid, locname, locrefid, prescdigino);
	}

	public boolean Checkprescdigi(Prescdigitalization prescdi) throws Exception {

		// try {

		prescdigirepository.updatefielddata(prescdi.getEmprefid(), prescdi.getPdigitalizedid(), prescdi.getApprovsts());

		return true;
		// } catch (Exception cause) {
		// logger.error("Exception in (Packing)Method : checksavePacking() " + cause);
		// }
		// return false;
	}

	public void deletePrescProduct(List<Prescdigiproduct> presc) throws Exception {
		Prescdigiproduct purc = presc.get(0);
		int compid = purc.getCompanyrefid();
		int branchid = purc.getBranchrefid();
		int locname = purc.getLocname();
		int locrefid = purc.getLocrefid();

		int poid = purc.getPdigitalizedrefid();
		System.out.println("inside delete poid" + poid + compid + branchid + locname + locrefid);
		prescdigirepository.deletePoProduct(compid, branchid, locname, locrefid, poid);
	}

	@Transactional
	public Boolean Checkprescdigitable(List<Prescdigiproduct> prescdigiproduct) throws Exception {
		boolean flag = false;

		try {
			this.deletePrescProduct(prescdigiproduct);
			System.out.println("after delete");
			for (int i = 0; i < prescdigiproduct.size(); i++) {
				Prescdigiproduct pk = prescdigiproduct.get(i);
				System.out.println("inside for");
				String value = "CALL medc_sales.medc_presdigitp(?, ?, ? , ? , ? , ? , ? , ? , ?, ?, ?, ?, ?)";
				query = em.createNativeQuery(value);
				query.setParameter(1, pk.getPdigitalizedrefid());
				query.setParameter(2, pk.getDrugproductid());
				query.setParameter(3, pk.getQty());
				query.setParameter(4, pk.getDays());
				query.setParameter(5, pk.getMorning());
				query.setParameter(6, pk.getAfternoon());
				query.setParameter(7, pk.getEvening());
				query.setParameter(8, pk.getNight());
				query.setParameter(9, pk.getCompanyrefid());
				query.setParameter(10, pk.getBranchrefid());
				query.setParameter(11, pk.getLocname());
				query.setParameter(12, pk.getLocrefid());
				query.setParameter(13, "update");
				int reVal = query.executeUpdate();
				if (reVal == 1) {
					flag = true;
					System.out.println("checkprescdigi");
				} else {
					flag = false;
				}
			}
		} catch (Exception e) {
			logger.error("Exception in Method : Checkprescdigitable() " + e);
			throw new Exception(e);
		}
		return flag;
	}

	public List prescdigiappr(Integer compid, Integer brandid, Integer locname, Integer locrefid) throws Exception {

		return prescdigirepository.getprescdiginoappr(compid, brandid, locname, locrefid);
	}

	public int Rejection(Integer compid, Integer brandid, Integer locname, Integer locrefid, Integer orderid)
			throws Exception {

		return prescdigirepository.rejectorder(compid, brandid, locname, locrefid, orderid);
	}

	public List viewprescriptio(Integer compid, Integer brandid, Integer locname, Integer locrefid) throws Exception {
		// TODO Auto-generated method stub
		return prescdigirepository.viewpresc(compid, brandid, locname, locrefid);
	}

	public Page getprescriptionhistory(Integer compid, Integer brandid, Integer locname, Integer locrefid,
			Integer pageno, Integer size) throws Exception {
		// TODO Auto-generated method stub
		// Page page = null;
		// try {
		Pageable paging = PageRequest.of(pageno, size);
		Page page = prescdigirepository.getprescriptionhistory(compid, brandid, locname, locrefid, paging);
		// } catch (Exception ex) {
		// logger.error("Exception in Method : viewDrugmasters : " + ex);
		// }
		return page;

	}

}
