package com.medeil.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.medeil.domain.Ehr;
import com.medeil.domain.Ehrmaster;
import com.medeil.repository.EhrRepository;
import com.medeil.repository.EhrmasterRepository;

@Service
public class EhrService {

	private EhrRepository ehrRepository;
	private EhrmasterRepository ehrmasterRepository;
	Integer lastid;

	@Autowired
	public EhrService(EhrRepository ehrRepository, EhrmasterRepository ehrmasterRepository) {
		super();
		this.ehrRepository = ehrRepository;
		this.ehrmasterRepository = ehrmasterRepository;
	}

	public ResponseEntity<Boolean> ehrReportSave(Ehr ehr) {
		ehrRepository.save(ehr);
		return ResponseEntity.created(null).body(true);
	}

	public ResponseEntity<?> ehrReportlist() {
		List<Ehr> list = ehrRepository.findAll();
		return ResponseEntity.created(null).body(list);
	}

	public ResponseEntity<Boolean> ehrMasterSave(Ehrmaster ehrmaster) {
		lastid = ehrmasterRepository.save(ehrmaster).getId();
		return ResponseEntity.created(null).body(true);

	}

	public ResponseEntity<?> ehrMasterlist() {
		List<Ehrmaster> list = ehrmasterRepository.findAll();
		return ResponseEntity.created(null).body(list);
	}

	public ResponseEntity<Boolean> ehrMasterDocumentSave(MultipartFile file) throws Exception {
		storeFile(file);
		return ResponseEntity.created(null).body(true);

	}

	public Ehrmaster storeFile(MultipartFile file) throws Exception {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if (fileName.contains("..")) {
				throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
			}
			Ehrmaster ehrmaster = ehrmasterRepository.findById(lastid).get();
			ehrmaster.setDocname(fileName);
			ehrmaster.setDoctype(file.getContentType());
			ehrmaster.setEhrdoc(file.getBytes());
			return ehrmasterRepository.save(ehrmaster);
		} catch (IOException ex) {
			throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public List ViewMasterList(Integer cid, Integer bid, Integer locname, Integer locrefid) {
		return ehrmasterRepository.ViewMasterList(cid, bid, locname, locrefid);
	}

}
