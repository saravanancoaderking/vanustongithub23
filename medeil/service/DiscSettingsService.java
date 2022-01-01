package com.medeil.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.DiscountSettings;
import com.medeil.domain.IndCompModel;
import com.medeil.repository.DiscSettingsRepository;

@Service
public class DiscSettingsService {

	private final DiscSettingsRepository discsettingrepo;

	private final Logger log = LoggerFactory.getLogger(DiscSettingsService.class);

	@Autowired
	DiscSettingsService(DiscSettingsRepository Discsettingrepo) {

		this.discsettingrepo = Discsettingrepo;

	}

	public int saveDiscountSettings(List<DiscountSettings> disc) throws Exception {

		for (DiscountSettings temp : disc) {

			discsettingrepo.save(temp);
		}
		return 1;

	}

	public int savePriceSettings(IndCompModel loc) throws Exception {

		discsettingrepo.updatePriceSettings(loc.getFrmint1(), loc.getLocrefid(), loc.getLocname());

		return 1;

	}

	public List viewPriceSettings(IndCompModel loc) throws Exception {

		return discsettingrepo.viewPriceSettings(loc.getLocrefid(), loc.getLocname());

	}

	public List viewDiscountSettings(IndCompModel loc) throws Exception {

		return discsettingrepo.viewDiscountSettings(loc.getLocrefid(), loc.getLocname());

	}

	public List viewDiscountSettingsNo(IndCompModel loc) {

		return discsettingrepo.viewDiscountSettingsNo(loc.getLocrefid(), loc.getLocname());

	}

}
