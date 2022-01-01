/**
 * 
 */
package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;

import com.medeil.domain.Purchase;
import com.medeil.domain.PurchaseInvoice;

/**
 * @author Ajith AK
 *
 */
public interface PurcRepository {

	@Procedure(name = "medc_purchase.pro_purchaseInvoice")
	public boolean createRecord(Purchase purchase) throws Exception;

	@Procedure(name = "medc_purchase.pro_purcInvoice")
	public boolean createPurcinvoice(List<PurchaseInvoice> purchaseinvoice) throws Exception;

	@Procedure(name = "medc_purchase.pro_purchaseInvoice")
	public boolean updateRecord(Purchase purchase) throws Exception;

	@Procedure(name = "medc_purchase.pro_purcInvoice")
	public boolean updatePurcinvoice(List<PurchaseInvoice> purchaseinvoice) throws Exception;

}
