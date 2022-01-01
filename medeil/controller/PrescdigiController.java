/**
 * 
 */
package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.domain.Prescdigiproduct;
import com.medeil.domain.Prescdigitalization;
import com.medeil.service.PrescdigiService;

/**
 * @author www
 *
 */
@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("/api")
public class PrescdigiController {

	@Autowired
	PrescdigiService prescdigiservice;

	@GetMapping(value = "/getprescsalesorder/{cid}/{bid}/{locrefid}/{locname}")
	public List getSalesorder(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname) throws Exception {
		return prescdigiservice.getsales(cid, bid, locrefid, locname);
	}

	@GetMapping(value = "/getprescprodetail/{cid}/{bid}/{locrefid}/{locname}/{brandname}")
	public List getprodetails(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locrefid,
			@PathVariable Integer locname, @PathVariable String brandname) throws Exception {
		return prescdigiservice.getprodetail(cid, bid, locrefid, locname, brandname);
	}

	@GetMapping(value = "/getproduct/{compid}/{brandid}")
	public List getproduct(@PathVariable Integer compid, @PathVariable Integer brandid) throws Exception {
		return prescdigiservice.getproduct(compid, brandid);
	}

	@GetMapping(value = "/getprescslsordetail/{orderid}")
	public List getSalesorderdetail(@PathVariable Integer orderid) throws Exception {
		return prescdigiservice.getsalesordetail(orderid);
	}

	// for omni lead process Puthiran

	@GetMapping(value = "/omnigetprescslsordetail/{orderid}")
	public List getomniSalesorderdetail(@PathVariable Integer orderid) throws Exception {
		return prescdigiservice.getomnisalesordetail(orderid);
	}

	/** METHOD FOR GETTING LIST OF EMPLOYEES **/
	@GetMapping(value = "getPrescEmpdetails/{cid}/{bid}/{locname}/{locrefid}")
	public List getPlEmpdetails(@PathVariable Integer cid, @PathVariable Integer bid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return prescdigiservice.getPlEmpdetails(cid, bid, locname, locrefid);
	}

	/** METHOD FOR SAVING **/
	@PostMapping(value = "/saveprescdigi")
	public boolean Saveprescdigi(@RequestBody Prescdigitalization prescdi) throws Exception {
		return prescdigiservice.Saveprescdigi(prescdi);
	}

	@PostMapping(value = "/saveprescdigitable")
	public boolean Saveprescdigitable(@RequestBody List<Prescdigiproduct> prescdigiproduct) throws Exception {
		return prescdigiservice.Saveprescdigitable(prescdigiproduct);
	}

	// checking process
	@GetMapping(value = "/prescdigino/{compid}/{brandid}/{locname}/{locrefid}")
	public List prescdigino(@PathVariable Integer compid, @PathVariable Integer brandid, @PathVariable Integer locname,
			@PathVariable Integer locrefid) throws Exception {
		return prescdigiservice.prescdigi(compid, brandid, locname, locrefid);
	}

	@GetMapping(value = "/prescdigichecking/{compid}/{brandid}/{locname}/{locrefid}/{prescdigino}")
	public List prescdigino(@PathVariable Integer compid, @PathVariable Integer brandid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer prescdigino) throws Exception {
		System.out.println("inside prescdigichecking");
		return prescdigiservice.prescdigino(compid, brandid, locname, locrefid, prescdigino);
	}

	@GetMapping(value = "/presccheckingpro/{compid}/{brandid}/{locname}/{locrefid}/{prescdigino}")
	public List prescheckprod(@PathVariable Integer compid, @PathVariable Integer brandid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer prescdigino)
			throws Exception {

		return prescdigiservice.prescheckprod(compid, brandid, locname, locrefid, prescdigino);
	}

	/** METHOD FOR CHECKING PROCESS **/
	@PostMapping(value = "/checkprescdigi")
	public boolean Checkprescdigi(@RequestBody Prescdigitalization prescdi) throws Exception {
		System.out.println("checkprescdigi");
		return prescdigiservice.Checkprescdigi(prescdi);
	}

	@PostMapping(value = "/checkprescdigitable")
	public boolean Checkprescdigitable(@RequestBody List<Prescdigiproduct> prescdigiproduct) throws Exception {
		System.out.println("checkprescdigitable");
		return prescdigiservice.Checkprescdigitable(prescdigiproduct);
	}

	/** METHOD FOR Approval PROCESS **/

	// checking process
	@GetMapping(value = "/prescdiginoapprv/{compid}/{brandid}/{locname}/{locrefid}")
	public List prescdiginoappr(@PathVariable Integer compid, @PathVariable Integer brandid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		return prescdigiservice.prescdigiappr(compid, brandid, locname, locrefid);
	}

	/** Rejction list **/

	@GetMapping(value = "/rejectedpresc/{compid}/{brandid}/{locname}/{locrefid}/{orderid}")
	public int Rejection(@PathVariable Integer compid, @PathVariable Integer brandid, @PathVariable Integer locname,
			@PathVariable Integer locrefid, @PathVariable Integer orderid) throws Exception {
		System.out.println("checkprescdigi");
		return prescdigiservice.Rejection(compid, brandid, locname, locrefid, orderid);
	}

	// ** view process**//
	@GetMapping(value = "/viewprescriptio/{compid}/{brandid}/{locname}/{locrefid}")
	public List viewprescriptio(@PathVariable Integer compid, @PathVariable Integer brandid,
			@PathVariable Integer locname, @PathVariable Integer locrefid) throws Exception {
		System.out.println("inside prescdigichecking");
		return prescdigiservice.viewprescriptio(compid, brandid, locname, locrefid);
	}

	// ** view Prescription History **//
	@GetMapping(value = "/getprescriptionhistory/{compid}/{brandid}/{locname}/{locrefid}/{pageno}/{size}")
	public Page getprescriptionhistory(@PathVariable Integer compid, @PathVariable Integer brandid,
			@PathVariable Integer locname, @PathVariable Integer locrefid, @PathVariable Integer pageno,
			@PathVariable Integer size) throws Exception {
		System.out.println("inside prescdigichecking");
		return prescdigiservice.getprescriptionhistory(compid, brandid, locname, locrefid, pageno, size);
	}

}
