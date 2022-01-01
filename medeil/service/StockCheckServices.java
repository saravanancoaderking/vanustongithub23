/**
 * 
 */
package com.medeil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medeil.repository.CheckingDrugStockRepository;
import com.medeil.repository.StockCheckingRepository;

/**
 * @author Manikandan,Ranjan
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class StockCheckServices {

	@Autowired
	StockCheckingRepository stockCheckingRepository;
	@Autowired
	private CheckingDrugStockRepository drugstockRepository;

	public List superAdminStockInfo() throws Exception {
		return stockCheckingRepository.superAdminStockInfo();
	}

	public List getStockInfo(int compid, int brnchid, int locname, int locrefid) throws Exception {
		return stockCheckingRepository.getStockInfo(compid, brnchid, locname, locrefid);
	}

	/**
	 * fetching all out of stock drug details when emdsure stock api check Ranjan
	 * 06022020
	 * 
	 * @Return page object having List of OutOF stock drug detail.
	 * @Param pageno and size which determines what is the current pagenumber should
	 *        return page size is nothing but how much Object Data should every page
	 *        contain.
	 *
	 */
	public Page getStockDetail(int pageno, int size) throws Exception {
		// Page page = null;

		// try {
		Pageable paging = PageRequest.of(pageno, size);
		// Page page = drugstockRepository.findAll(paging);
		// System.out.println(page.getContent());
		// } catch (Exception ex) {
		/* logger.error("Exception in Method : domainList() : " + ex); */
//		}

		return drugstockRepository.findAll(paging);

	}

	public List updateprice() throws Exception {
		return stockCheckingRepository.getpriceupdatestock();
	}
}
