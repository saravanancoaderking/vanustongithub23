package com.medeil.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.medeil.domain.Printimages;
import com.medeil.domain.Printsetting;
import com.medeil.repository.Printimagerepository;
import com.medeil.repository.Printsettingsrepository;

@Service
public class Printsettingservice {

	@Autowired
	Printsettingsrepository printsettingsrepository;

	@Autowired
	Printimagerepository printimagerepository;

	public List viewDefaultforms() throws Exception {
		// try {

		return printsettingsrepository.viewDefaultforms();
		// } catch (Exception e) {
		// e.printStackTrace();
		//// }
		// return null;
	}

	// view print settings
	public List viewprintsettings(int companyid, int branchid, int locname, int locrefid) throws Exception {
		// try {
		return printsettingsrepository.viewprintsettings(companyid, branchid, locname, locrefid);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}

	// view forms print Model
	public List viewformsprintmodel(int companyid, int branchid, int locname, int locrefid, int formid)
			throws Exception {
		// try {

		return printsettingsrepository.viewformsprintmodel(companyid, branchid, locname, locrefid, formid);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}

	public ResponseEntity<Boolean> saveprintsettings(List<Printsetting> savesettings) throws Exception {
		// try {
		printsettingsrepository.saveAll(savesettings);
		return ResponseEntity.created(null).body(true);
		// } catch (DataIntegrityViolationException e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.getRootCause().getMessage());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// } catch (Exception e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.toString());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// }
	}

	// print image record
	public ResponseEntity<Printimages> saveprintimagerecord(Printimages printimage) throws Exception {
		// try {
		printimagerepository.save(printimage);
		return ResponseEntity.created(null).body(printimage);
		// } catch (DataIntegrityViolationException e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.getRootCause().getMessage());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);
		// } catch (Exception e) {
		// HashMap<String, String> errorMessage = new HashMap<String, String>();
		// errorMessage.put("message", e.toString());
		// return new ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST);

		// }
	}

	// print image save
	public boolean saveImageFile(MultipartFile file) throws IOException, Exception {
		boolean result = true;
		if (result == true) {
			System.out.println("Original Image Byte Size - " + file.getBytes().length);
			printimagerepository.imageuplaod(file.getOriginalFilename(), file.getContentType(), (file.getBytes()));
			result = true;
		} else {

			result = false;
		}
		return result;
	}
	
	public boolean UpdateImageFile(MultipartFile file,int imageid) throws IOException, Exception {
		boolean result = true;
		if (result == true) {
			System.out.println("Original Image Byte Size - " + file.getBytes().length);
			printimagerepository.updateimageuplaod(file.getOriginalFilename(), file.getContentType(), (file.getBytes()),imageid);
			result = true;
		} else {

			result = false;
		}
		return result;
	}

	// print image view
	public List<byte[]> getsendImage(Integer formid, Integer printtypeid) throws Exception {
		// TODO Auto-generated method stub
		return printimagerepository.getsendImage(formid, printtypeid);
	}

	public List getprintimagevalues(Integer formid, Integer printtypeid) throws Exception {
		return printimagerepository.getprintimagevalues(formid, printtypeid);

	}

}
