package com.medeil.service;

import java.util.HashMap;
/**
 * @author Mrs.Padmini
 * @author Boopalan Alagesan
 *
 */
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.Drug;
import com.medeil.domain.NewProduct;
import com.medeil.domain.NewProductQty;
import com.medeil.repository.DrugRepository;
import com.medeil.repository.NewProductQtyRepository;
import com.medeil.repository.NewProductRepository;

@SuppressWarnings("rawtypes")
@Service
public class NewProductService {
	static String setAutoIncrement;
	@PersistenceContext
	private EntityManager em;

	Query query;
	List list;
	private static Logger logger = LogManager.getLogger();
	@Autowired
	private NewProductRepository newProductRepository;

	@Autowired
	private DrugRepository drugRepository;

	@Autowired
	NewProductQtyRepository newProductQtyRepository;

	public ResponseEntity<Boolean> saveNewProductEnq(List<NewProduct> newProducts) throws Exception {

		for (NewProduct newProduct : newProducts) {
			boolean existsBynewproductname = newProductRepository
					.existsByBrandnameAndCompanyidAndBranchidAndLocnameAndLocrefid(newProduct.getBrandname(),
							newProduct.getCompanyid(), newProduct.getBranchid(), newProduct.getLocname(),
							newProduct.getLocrefid());
			if (existsBynewproductname == true) {

			} else {
				newProductRepository.save(newProduct);

			}
		}
		return ResponseEntity.created(null).body(true);
	}

	public Integer saveNewProdMinqty(List<NewProductQty> newProductsIR) throws Exception {
		boolean flag = false;
		System.out.println("inside newproduct");

		for (int count = 0; count < newProductsIR.size();) {
			setAutoIncrement = this.getNewProductAutoincrement(newProductsIR.get(0).getCompanyrefid(),
					newProductsIR.get(0).getBranchrefid(), newProductsIR.get(0).getLocname(),
					newProductsIR.get(0).getLocrefid());
			break;
		}

		// try {

		for (int count = 0; count < newProductsIR.size(); count++) {

			newProductsIR.get(count).setNewprodno(setAutoIncrement);
			System.out.println("outside newproduct" + setAutoIncrement);

			Integer newpro = newProductQtyRepository.getnewproductrefid(newProductsIR.get(count).getNewproductname(),
					newProductsIR.get(count).getCompanyrefid(), newProductsIR.get(count).getBranchrefid(),
					newProductsIR.get(count).getLocname(), newProductsIR.get(count).getLocrefid());
			System.out.println("outside newproduct" + newpro);

			newProductsIR.get(count).setNprefid(newpro);
			System.out.println("newprid:" + newProductsIR.get(count).getNprefid());
			System.out.println("outside newproduct");

			newProductQtyRepository.saveAll(newProductsIR);

		}
		for (int count = 0; count < newProductsIR.size();) {
			newProductQtyRepository.gridColorNewProduct(newProductsIR.get(0).getCompanyrefid(),
					newProductsIR.get(0).getBranchrefid(), newProductsIR.get(0).getLocname(),
					newProductsIR.get(0).getLocrefid(), newProductsIR.get(0).getNprefid());

			break;
		}

		return 1;

		// } catch (

		// Exception cause) {
		// logger.error("Exception in (NewProductQty)Method : createRecord() " + cause);
		// }

		// return 0;
	}

	@Transactional
	public String getNewProductAutoincrement(int compid, int branchid, int locname, int locrefid) throws Exception {
		List getResultValue = null;

		String firstParameter = "NewProduct";

		// try {
		String q = "Call medc_stock.pro_autoincrement(?,?,?,?,?,?)";
		query = em.createNativeQuery(q);
		query.setParameter(1, firstParameter);
		query.setParameter(2, compid);
		query.setParameter(3, branchid);
		query.setParameter(4, locname);
		query.setParameter(5, locrefid);
		query.setParameter(6, 0);
		getResultValue = query.getResultList();
		System.out.println("SutoIncrement  :" + getResultValue);
		// } catch (Exception cause) {
		// System.out.println("getAutoincrements :" + cause);
		// }
		String NewProdNo = getResultValue.get(0).toString();

		return NewProdNo;
	}

	// padmini
	@Transactional
	public List newprno(NewProductQty newproducrtno) throws Exception {

		return newProductRepository.newprno(newproducrtno.getCompanyrefid(), newproducrtno.getBranchrefid(),
				newproducrtno.getLocname(), newproducrtno.getLocrefid());

	}

	public List newprview(NewProductQty newproducrtno) throws Exception {

		return newProductRepository.newprview(newproducrtno.getCompanyrefid(), newproducrtno.getBranchrefid(),
				newproducrtno.getLocname(), newproducrtno.getLocrefid(), newproducrtno.getNewprodno());

	}

	// padmini
	@Transactional
	public int updatenewproduct(List<NewProductQty> newproduct) throws Exception {
		int updateflag = 1;
		System.out.println("inside service");
		newProductQtyRepository.newprodelete(newproduct.get(0).getCompanyrefid(), newproduct.get(0).getBranchrefid(),
				newproduct.get(0).getLocname(), newproduct.get(0).getLocrefid(), newproduct.get(0).getNewprodno());

		System.out.println("inside service1");

		for (int i = 0; i < newproduct.size(); i++) {

			newproduct.get(i).setUpdateflag(1);

			// System.out.println("ipdte flag" + newproduct.get(i).getUpdateflag());

		}

		newProductQtyRepository.saveAll(newproduct);

		System.out.println("inside service2");

		updateflag = 1;
		return updateflag;
	}

	public List viewStkNewQtyAll(NewProductQty viewproduct) throws Exception {

		return newProductRepository.viewStkNewQtyAll(viewproduct.getCompanyrefid(), viewproduct.getBranchrefid(),
				viewproduct.getLocname(), viewproduct.getLocrefid());

	}

	public List viewStk1NewQtyAll(NewProductQty loc) throws Exception {

		return newProductRepository.viewStk1NewQtyAll(loc.getCompanyrefid(), loc.getBranchrefid(), loc.getLocname(),
				loc.getLocrefid(), loc.getNewprodno());

	}

	public boolean oneProduct(List<NewProduct> onepro) throws Exception {
		boolean flag = false;

		for (int i = 0; i < onepro.size(); i++) {
			String newname = newProductRepository.oneProduct(onepro.get(i).getBrandname(), onepro.get(i).getCompanyid(),
					onepro.get(i).getBranchid(), onepro.get(i).getLocname(), onepro.get(i).getLocrefid());
			System.out.println(newname);

			if (newname == null) {
				flag = true;
				return flag;
			} else {

				return flag;
			}
		}
		return flag;
	}

	public ResponseEntity<List<Drug>> saveNewcustProductEnq(List<Drug> newProducts) throws Exception {

		// try {

		for (int i = 0; i < newProducts.size(); i++) {
			boolean existsBynewproductname = ((DrugRepository) drugRepository)
					.existsByBrandnameAndCompanyidAndBranchidAndLocnameAndLocrefid(newProducts.get(i).getBrandname(),
							newProducts.get(i).getCompanyid(), newProducts.get(i).getBranchid(),
							newProducts.get(i).getLocname(), newProducts.get(i).getLocrefid());
			if (existsBynewproductname == false) {
				drugRepository.saveAll(newProducts);
			} else {
				System.out.println("product name" + newProducts.get(i).getBrandname());
				String errorMessage = newProducts.get(i).getBrandname() + " or " + " is already exists!";
				HashMap<String, String> message = new HashMap<String, String>();
				message.put("message", errorMessage);
				ResponseEntity responseEntity = new ResponseEntity(message, HttpStatus.CONFLICT);
				System.out.println("responseEntity" + responseEntity);
				return responseEntity;
			}
		}
		return ResponseEntity.created(null).body(newProducts);

		// } catch (Exception e) {
		// HashMap<String, String> message = new HashMap<String, String>();
		// message.put("message", e.getMessage());
		// return new ResponseEntity(message, HttpStatus.BAD_REQUEST);

		// }

	}
}
