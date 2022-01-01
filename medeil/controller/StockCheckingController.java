/**
 * 
 */
package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.service.StockCheckServices;

/**
 * @author Vanu
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class StockCheckingController {

	@Autowired
	StockCheckServices stockCheckServices;

	@GetMapping(value = "supergetstockcheckinginfo")
	public List superAdminStockInfo() throws Exception {
		return stockCheckServices.superAdminStockInfo();
	}

	@GetMapping(value = "getstockcheckinginfo/{compid}/{brnchid}/{locname}/{locrefid}")
	public List StockInfo(@PathVariable Integer compid, @PathVariable Integer brnchid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return stockCheckServices.getStockInfo(compid, brnchid, locname, locrefid);
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

	@RequestMapping(value = "/StockdetailData/{pageno}/{size}", method = RequestMethod.GET)
	public Page getStockChecking(@PathVariable int pageno, @PathVariable int size) throws Exception {
		System.out.println("Hii iam oin controller class");
		return stockCheckServices.getStockDetail(pageno, size);

	}

	/** Show the Price Updating Details @Raja **/

	@GetMapping(value = "/stockpriceupdate")
	public List stockpriceupdate() throws Exception {
		return stockCheckServices.updateprice();
	}
}
