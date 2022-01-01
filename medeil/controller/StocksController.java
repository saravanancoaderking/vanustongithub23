package com.medeil.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Barqrsettings;
import com.medeil.domain.Stocks;
import com.medeil.service.StocksService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class StocksController {

	@Autowired
	private StocksService service;

	@GetMapping(value = "stockproductdata/{product}/{cid}/{bid}/{locrefid}/{locname}")
	public List getStockProduct(@PathVariable String product, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		return service.getStockProduct(product, cid, bid, locrefid, locname);
	}

	@GetMapping(value = "getStockdosage/{id}")
	public List getProDosage(@PathVariable Integer id) throws Exception {
		return service.getProDosage(id);
	}

	@GetMapping(value = "getStockformulation/{id}")
	public List getProFormulation(@PathVariable Integer id) throws Exception {
		return service.getProFormulation(id);
	}

	// Boopalan 04062019
	@PostMapping(value = "saveStockdata")
	public boolean saveStock(@RequestBody Stocks stocks) { // throws Exception
		return service.saveStock(stocks);
	}

	// Boopalan 04062019
	@GetMapping(value = "viewstockdata/{cid}/{bid}/{locrefid}/{locname}/{pageno}/{size}")
	public Page viewStock(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer pageno, @PathVariable Integer size) throws Exception {
		return service.viewStock(cid, bid, locrefid, locname, pageno, size);
	}

	@GetMapping(value = "searchstockdata/{cid}/{bid}/{locrefid}/{locname}/{searchindex}/{searchvalue}/{pageno}/{size}")
	public Page searchstockitems(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer searchindex, @PathVariable String searchvalue,
			@PathVariable Integer pageno, @PathVariable Integer size) throws Exception {
		return service.searchstockitems(cid, bid, locrefid, locname, searchindex, searchvalue, pageno, size);
	}

	@PostMapping(value = "updateStockdata")
	public boolean updateStock(@RequestBody Stocks stocks) throws Exception {
		return service.updateStock(stocks);
	}

	/**** Edit Stock *****/
	@GetMapping(value = "editstockdata/{id}")
	public Stocks editStockinfo(@PathVariable Integer id) throws Exception {
		return service.editStockinfo(id);
	}
	
	@GetMapping(value = "getstockdrugname/{drugid}")
	public List getstockdrugname(@PathVariable Integer drugid) throws Exception {
		return service.getstockdrugname(drugid);
	}

	@GetMapping(value = "/editstockdosage/{id}")
	public List editStockdos(@PathVariable Integer id) throws Exception {
		return service.editStockdos(id);
	}

	@GetMapping(value = "editstockformulation/{id}")
	public List editStockForm(@PathVariable Integer id) throws Exception {
		return service.editStockForm(id);
	}

	@GetMapping(value = "editstocksgst/{id}")
	public List editSgst(@PathVariable Integer id) throws Exception {
		return service.editSgst(id);
	}

	@GetMapping(value = "editstockcgst/{id}")
	public List editCgst(@PathVariable Integer id) throws Exception {
		return service.editCgst(id);
	}

	@GetMapping(value = "editstockigst/{id}")
	public List editIgst(@PathVariable Integer id) throws Exception {
		return service.editIgst(id);
	}

	@GetMapping(value = "editstockutgst/{id}")
	public List editUtgst(@PathVariable Integer id) throws Exception {
		return service.editUtgst(id);
	}

	@GetMapping(value = "editstockgst/{id}")
	public List editGst(@PathVariable Integer id) throws Exception {
		return service.editGst(id);
	}

	@GetMapping(value = "editstockvat/{id}")
	public List editVat(@PathVariable Integer id) throws Exception {
		return service.editVat(id);
	}

	@GetMapping(value = "deletestockdata/{id}")
	public Integer deleteStock(@PathVariable Integer id) throws Exception {
		return service.deleteStock(id);
	}

	// puthiran for barqr settings
	@PostMapping(value = "savebarqrsettings")
	public boolean savebarqrsettings(@RequestBody Barqrsettings barqrsetting) throws Exception {
		return service.savebarqrsettings(barqrsetting);
	}

	// view barqr settings shopwise
	@GetMapping(value = "/viewbarqrsettings/{companyid}/{branchid}/{locname}/{locrefid}")
	public List viewbarsettings(@PathVariable int companyid, @PathVariable int branchid, @PathVariable int locname,
			@PathVariable int locrefid) throws Exception {
		return service.viewbarqrsettings(companyid, branchid, locname, locrefid);
	}

	@GetMapping(value = "/viewqrcodeimage/{stockid}")
	public Map<String, String> QrcodeImageView(@PathVariable Integer stockid) throws Exception {
		Map<String, String> jsonMap = new HashMap<>();
		// try {
		byte[] path = service.getQrcodeImage(stockid);
		String encodeImage = Base64.getEncoder().encodeToString(path);
		jsonMap.put("content", encodeImage);
		return jsonMap;
		// } catch (Exception e) {
		// e.printStackTrace();
		// jsonMap.put("content", "no image");
		// return jsonMap;
		// }
	}

	// Dsing raja
	// Schedule List Form

	@GetMapping(value = "getschdldata/{comid}/{branchid}/{locname}/{locrefid}")
	public List getscheduldata(@PathVariable Integer comid, @PathVariable Integer branchid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		System.out.println("Scheld controller");
		return service.getschdldata(comid, branchid, locname, locrefid);
	}

	@GetMapping(value = "editschedule/{scheduleid}/{productid}")
	public boolean changeschedule(@PathVariable Integer scheduleid, @PathVariable Integer productid) throws Exception {
		System.out.println(scheduleid + "   " + productid);
		return service.editschedule(scheduleid, productid);
	}

	@GetMapping(value = "updateminimumqty/{cid}/{bid}/{lname}/{lrefid}")
	public void updateminiQuantity(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrefid) throws Exception {
		service.updateminiQuantity(cid, bid, lname, lrefid);
	}

	@GetMapping(value = "getbatch/{cid}/{bid}/{lname}/{lrefid}")
	public List getbatchname(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer lname,
			@PathVariable Integer lrefid) throws Exception {
		return service.getbatchno(cid, bid, lname, lrefid);
	}

}
