package com.medeil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.medeil.domain.SacCode;
import com.medeil.domain.SacGroup;
import com.medeil.domain.SacSectionCode;
import com.medeil.domain.Sacode;
import com.medeil.domain.ServiceProductmaster;
import com.medeil.repository.SacGroupCodeRepository;
import com.medeil.repository.SacRepository;
import com.medeil.repository.SacSectionRepository;
import com.medeil.repository.SacodeRepository;
import com.medeil.repository.ServiceProductmasterRepository;

/**
 * @author DesingRaja
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class SacService {

	private SacRepository sacrepositoryl;
	private SacSectionRepository sacsc;
	private SacGroupCodeRepository sacgc;
	private SacodeRepository sacoderep;
	private ServiceProductmasterRepository serviceProductmasterRepository;

	@Autowired
	public SacService(SacRepository sacrepositoryl, SacSectionRepository sacsc, SacGroupCodeRepository sacgc,
			SacodeRepository sacoderep, ServiceProductmasterRepository serviceProductmasterRepository) {
		super();
		this.sacrepositoryl = sacrepositoryl;
		this.sacsc = sacsc;
		this.sacgc = sacgc;
		this.sacoderep = sacoderep;
		this.serviceProductmasterRepository = serviceProductmasterRepository;
	}

	public List getsectionlist() {
		System.out.println("Section Raja1");
		return sacrepositoryl.getssectiondetails();
	}

	public List getgrouplist(Integer sectionid) {
		return sacrepositoryl.getgroupcode(sectionid);
	}

	public List getsaclist(Integer groupid) {
		return sacrepositoryl.getsaccode(groupid);
	}

	public List getsacsubcodelist1(Integer groupid, Integer saccode) {
		return sacrepositoryl.getsacsubcode1(groupid, saccode);
	}

	public List getsacsubcodelist2(Integer groupid, Integer saccode, String sacsubcode1) {
		return sacrepositoryl.getsacsubcode2(groupid, saccode, sacsubcode1);
	}

	public boolean savesaccode(SacCode saccode) throws Exception {
		Optional<SacCode> optional = sacrepositoryl.findBySectioncodeAndGroupcodeAndSaccode(saccode.getSectioncode(),
				saccode.getGroupcode(), saccode.getSaccode());
		if (optional.isPresent()) {
			optional.get().setCountrycode(saccode.getCountrycode());
			optional.get().setGstrate(saccode.getGstrate());
			optional.get().setCess(saccode.getCess());
			sacrepositoryl.save(optional.get());

		} else {
			sacrepositoryl.save(saccode);

		}
		return true;
	}

	public boolean savesc(SacSectionCode sc) throws Exception {

		sacsc.save(sc);
		return true;
	}

	public boolean savegc(SacGroup gc) throws Exception {

		sacgc.save(gc);
		return true;

	}

	public boolean savesaccode(Sacode sac) throws Exception {
		sacoderep.save(sac);
		return true;

	}

	public boolean Sacsubcode1(Sacode sac) throws Exception {
		sacoderep.save(sac);
		return true;
	}

	public boolean Sacsubcode2(Sacode sac) throws Exception {
		sacoderep.save(sac);
		return true;
	}

	public ResponseEntity<Boolean> saveSericeProduct(ServiceProductmaster serviceProductmaster) throws Exception {
		serviceProductmasterRepository.save(serviceProductmaster);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> getsaveSericeProduct(Integer countryid, Integer companyid, Integer branchid,
			Integer locname, Integer locrefid) throws Exception {
		List<ServiceProductmaster> productmaster = serviceProductmasterRepository
				.findByCountryidAndCompanyidAndBranchidAndLocnameAndLocrefid(countryid, companyid, branchid, locname,
						locrefid);
		return ResponseEntity.created(null).body(productmaster);
	}

	public ResponseEntity<Boolean> updateSericeProduct(ServiceProductmaster serviceProductmaster) throws Exception {
		ServiceProductmaster productmaster = serviceProductmasterRepository.findById(serviceProductmaster.getId())
				.get();
		productmaster = serviceProductmaster;
		serviceProductmasterRepository.save(productmaster);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<Boolean> deleteSericeProduct(Integer id) throws Exception {
		serviceProductmasterRepository.deleteById(id);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> getsaveSericeProducts(Integer id) {
		ServiceProductmaster productmaster = serviceProductmasterRepository.findById(id).get();
		return ResponseEntity.created(null).body(productmaster);
	}

}
