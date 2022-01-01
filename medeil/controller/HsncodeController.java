package com.medeil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medeil.bean.HsnBean;
import com.medeil.domain.Hsn_id;
import com.medeil.domain.Hsn_md;
import com.medeil.domain.Hsncodeproduct;
import com.medeil.repository.HsncodeRepository;
import com.medeil.service.HsncodeService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("api")
public class HsncodeController {

	@Autowired
	private HsncodeService hsncodeservice;

	@Autowired
	private HsncodeRepository hsnrepo;
	@ResponseBody
	@RequestMapping("/getcountry")
	public List getcountrylist() throws Exception {
		System.out.println("Raja Controller");
		return hsncodeservice.countrylist();
	}

	@ResponseBody
	@RequestMapping("/getmdesc")
	public List getmdesclist() throws Exception {
		System.out.println("RajaMdec");
		System.out.println("mdesc " + hsnrepo.getmdescription());
		return hsnrepo.getmdescription();
	}

	@ResponseBody
	@RequestMapping("/getidesc/{mdescid}/{countryid}")
	public List getidesclist(@PathVariable Integer mdescid, @PathVariable Integer countryid) throws Exception {
		return hsnrepo.getidesc(mdescid, countryid);
	}
//	@ResponseBody
//	@PostMapping("/savedata")
//	public boolean savehsn(@RequestBody List<Hsncode> hsncode) throws Exception {
//		System.out.println("RController");
//		
//		return hsncodeservice.savehsncode(hsncode);
//	}

	@PostMapping("/savemddata")
	public boolean savemd(@RequestBody List<Hsn_md> hsnmd) throws Exception {
		return hsncodeservice.savemdes(hsnmd);
	}

	@PostMapping("/saveid")
	public boolean saveides(@RequestBody Hsn_id hsnid) throws Exception {
		return hsncodeservice.saveid(hsnid);
	}

	@ResponseBody
	@RequestMapping("/gethsndesc/{mdescid}")
	public List gethsndesclist(@PathVariable Integer mdescid) throws Exception {
		return hsnrepo.gethsndesc(mdescid);
	}

	@PostMapping("/updatehsnproduct")
	public ResponseEntity<Boolean> Updatehsncodeproduct(@RequestBody Hsncodeproduct hsncode) throws Exception {
		return hsncodeservice.Updatehsncodeproduct(hsncode);
	}
	
	
	@PostMapping("/save-hsncode")
	public ResponseEntity<Boolean> SaveHsncode(@RequestBody  List<HsnBean> hsnBeans) throws Exception {
		return hsncodeservice.SaveHsncode(hsnBeans);
	}
	
	@PostMapping("/savemd")
	public ResponseEntity<Boolean> savemd(@RequestBody Hsn_md hsnmd) throws Exception{
		System.out.println("HSN MD save");
		return hsncodeservice.savemdescrip(hsnmd);
	}
	
//	@ResponseBody
//	@RequestMapping("/isexisthsn/{hsncode}")
//	public boolean isexisthsn(@PathVariable Integer hsncode) throws Exception {
//		return hsnrepo.gethsncode(hsncode);
//	}
}
