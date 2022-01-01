/**
 * 
 */
package com.medeil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.domain.StockIn;
import com.medeil.repository.StockInRepository;

/**
 * @author
 *
 */
@SuppressWarnings("rawtypes")
@Service
public class StocksInService {

	@Autowired
	StockInRepository repository;

	public List<StockIn> getAll() throws Exception {
		List<StockIn> list = new ArrayList<>();
		Iterable<StockIn> stocktax = repository.findAll();

		stocktax.forEach(list::add);
		return list;
	}

	public StockIn postStockstax(StockIn stockstax) throws Exception {
		stockstax.getWtaxID();
		repository.save(stockstax);
		return stockstax;
	}

	public List sgst() throws Exception {
		return repository.sgst();
	}

	public List cgst() throws Exception {
		return repository.cgst();
	}

	public List igst() throws Exception {
		return repository.igst();
	}

	public List utgst() throws Exception {
		return repository.utgst();
	}

	public List gst() throws Exception {
		return repository.gst();
	}

	public List vat() throws Exception {
		return repository.vat();
	}
}
