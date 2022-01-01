package com.medeil.controller;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medeil.domain.Damage_stock;
import com.medeil.domain.Damagestock;
import com.medeil.service.DamagestockService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class DamagestockController {

	@Autowired
	DamagestockService damagestockService;

	@GetMapping(value = "/getInvoice/{cid}/{bid}/{locrefid}/{locname}")
	public List getInvoice(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return damagestockService.getInvoice(cid, bid, locrefid, locname);
	}

	@GetMapping(value = "/getLoctype")
	public List getLoc() throws Exception {
		// System.out.println("Inside loctype");
		return damagestockService.getLoc();
	}

	@GetMapping(value = "/getLocreference/{locname}")
	public List getLocref(@PathVariable Integer locname) throws Exception {
		// System.out.println("Inside getLocref");
		return damagestockService.getLocref(locname);
	}

	@GetMapping(value = "/getdamageautoinc/{cid}/{bid}/{locrefid}/{locname}")
	public List getdamageAutoinc(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return damagestockService.getdamageAutoinc(cid, bid, locrefid, locname);
	}

	@GetMapping(value = "/getinvoicedetails/{cid}/{bid}/{locrefid}/{locname}/{id}")
	public List getInvoicedetails(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer id) throws Exception {
		return damagestockService.getInvoicedetails(cid, bid, locrefid, locname, id);
	}

	@GetMapping(value = "/getpiproduct/{cid}/{bid}/{locrefid}/{locname}/{id}")
	public List getPiproduct(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer id) throws Exception {
		return damagestockService.getPiproduct(cid, bid, locrefid, locname, id);
	}

	@GetMapping(value = "getDabrandlist/{val}/{cid}/{bid}/{locrefid}/{locname}")
	public List getBrandlist(@PathVariable String val, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		return damagestockService.getBrandlist(val, cid, bid, locrefid, locname);
	}

	// Search for Main Stock Product Desing

	@GetMapping(value = "getsearchproddetails/{val}/{cid}/{bid}/{locrefid}/{locname}")
	public List getprodlist(@PathVariable String val, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		return damagestockService.getproddetails(val, cid, bid, locrefid, locname);
	}

	@GetMapping(value = "getDatablevalues/{data}/{cid}/{bid}/{locrefid}/{locname}")
	public List getDatabledata(@PathVariable Integer data, @PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer locrefid, @PathVariable Integer locname) throws Exception {
		// System.out.println("Inside Datable");
		return damagestockService.getDatabledata(data, cid, bid, locrefid, locname);
	}

	/** CREATE Damage Stock RECORD **/
	@PostMapping(value = "savedamagestockform")
	public boolean createDamagestock(@RequestBody Damagestock damagestock) throws Exception {
		return damagestockService.createDamagestock(damagestock);

	}

	/** CREATE DAMAGE TABLE RECORD **/
	@PostMapping(value = "createDamagetable")
	public boolean createDamagetable(@RequestBody List<Damage_stock> Damage_stock) throws Exception {
		return damagestockService.createDamagetable(Damage_stock);
	}

	@GetMapping(value = "/getqty/{id}")

	public List getDamageboxdetails(@PathVariable Integer id) throws Exception {
		return damagestockService.getDamageboxdetails(id);
	}

	@GetMapping(value = "getshopDamagetax/{cid}/{bid}/{shopid}")
	public List getshopDamTax(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer shopid)
			throws Exception {
		return damagestockService.getshopDamTax(cid, bid, shopid);
	}

	@GetMapping(value = "gethospitalDamagetax/{cid}/{bid}/{hospitalid}")
	public List gethospitalDamTax(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer hospitalid) throws Exception {
		return damagestockService.gethospitalDamTax(cid, bid, hospitalid);
	}

	@GetMapping(value = "getwarehouseDamagetax/{cid}/{bid}/{warehouseid}")
	public List getwarehouseDamTax(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer warehouseid) throws Exception {
		return damagestockService.getwarehouseDamTax(cid, bid, warehouseid);
	}

	@GetMapping(value = "getshopTaxmaster/{cid}/{bid}/{shopid}")
	public List chechshopTaxmaster(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer shopid)
			throws Exception {
		return damagestockService.chechshopTaxmaster(cid, bid, shopid);
	}

	@GetMapping(value = "gethospitalTaxmaster/{cid}/{bid}/{hospitalid}")
	public List chechhospitalTaxmaster(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer hospitalid) throws Exception {
		return damagestockService.chechhospitalTaxmaster(cid, bid, hospitalid);
	}

	@GetMapping(value = "getwarehouseTaxmaster/{cid}/{bid}/{warehouseid}")
	public List chechwarehouseTaxmaster(@PathVariable Integer cid, @PathVariable Integer bid,
			@PathVariable Integer warehouseid) throws Exception {
		return damagestockService.chechwarehouseTaxmaster(cid, bid, warehouseid);
	}

	/** VIEW Damage RECORD **/

	@GetMapping(value = "viewDamage/{cid}/{bid}/{locrefid}/{locname}")
	public List getViewdamage(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {

		return damagestockService.getViewdamage(cid, bid, locrefid, locname);
	}

	/** Edit Damage RECORD **/
	@GetMapping(value = "/editDamage/{cid}/{bid}/{locrefid}/{locname}/{id}")
	public List getEditdamage(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer id) throws Exception {
		return damagestockService.getEditdamage(cid, bid, locrefid, locname, id);
	}

	@GetMapping(value = "/editdamagetable/{cid}/{bid}/{locrefid}/{locname}/{id}")
	public List getEditdamagetable(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer id) throws Exception {
		// System.out.println("Inside getEditdamagetable");
		return damagestockService.getEditdamagetable(cid, bid, locrefid, locname, id);
	}

	/** Update Damage Stock RECORD **/
	@PostMapping(value = "updateDamage")
	@Transactional
	public boolean updateDamagestock(@RequestBody Damagestock damagestock) throws Exception {
		// System.out.println("ss : " + damagestock.getDistname());
		return damagestockService.updateDamagestock(damagestock);

	}

	/** PDATE DAMAGE TABLE RECORD updateDamagetable **/
	@PostMapping(value = "updateDamagetable")
	@Transactional
	public boolean updateDamagetable(@RequestBody List<Damage_stock> Damage_stock) throws Exception {
		return damagestockService.updateDamagetable(Damage_stock);
	}

	/** VIEW-HQ Damage RECORD **/

	@GetMapping(value = "viewhqDamage/{cid}/{bid}/{locrefid}/{locname}")
	public List getViewhqdamage(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {

		return damagestockService.getViewhqdamage(cid, bid, locrefid, locname);
	}

	/** H.Q Damage RECORD **/
	@GetMapping(value = "/hqdamageview/{cid}/{bid}/{locrefid}/{locname}/{id}")
	public List gethqdamage(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer id) throws Exception {
		return damagestockService.getHqdamage(cid, bid, locrefid, locname, id);
	}

	@GetMapping(value = "/hqdamagetableview/{cid}/{bid}/{locrefid}/{locname}/{id}")
	public List getHqdamagetable(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable Integer id) throws Exception {
		// System.out.println("Inside getEditdamagetable");
		return damagestockService.getHqdamagetable(cid, bid, locrefid, locname, id);
	}

	/** DELETE Damage Stock **/
	@GetMapping(value = "deleteDamage/{id}")
	public void deleteDamage(@PathVariable("id") Integer id) throws Exception {
		damagestockService.deleteDamage(id);
	}

	@PostMapping(value = "updatedestroy")
	public boolean updatedest(@RequestBody List<Damage_stock> Damage_stock) throws Exception {
		System.out.println("Destroy Controll");
		return damagestockService.destroy(Damage_stock);

	}
}
