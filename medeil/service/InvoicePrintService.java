package com.medeil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.repository.InvoicePrintRepository;

@Service
public class InvoicePrintService {

	@Autowired
	InvoicePrintRepository invoicePrintRepository;

	public List getInvoice(int compid, int branchid, int locname, int locrefid, int shopid) throws Exception {

		return invoicePrintRepository.getInvoiceprintvalue(compid, branchid, locname, locrefid, shopid);

	}

	public List getInvoiceDetail(int compid, int branchid, int locname, int locrefid, int pono) throws Exception {
		System.out.println("Succ");
		return invoicePrintRepository.getInvoiceDetailvalue(compid, branchid, locname, locrefid, pono);
	}
}
