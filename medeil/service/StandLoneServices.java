/**
 * 
 */
package com.medeil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.repository.StandLoneRepository;

/**
 * @author Manikandan
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class StandLoneServices {

	@Autowired
	StandLoneRepository standLoneRepository;

	public List SuperAdminView() throws Exception {
		return standLoneRepository.SuperAdminView();
	}

	public List View(int compid, int brnchid, int locrefid) throws Exception {
		return standLoneRepository.View(compid, brnchid, locrefid);
	}

}
