/**
 * 
 */
package com.medeil.repository;

import org.springframework.data.jpa.repository.query.Procedure;

import com.medeil.domain.PurchaseOrder;

/**
 * @author Vanu
 *
 */

public interface PurcOrderRepository {

	@Procedure(name = "medc_purchase.pro_add")
	public boolean createPurchaseOrder(PurchaseOrder purc) throws Exception;

}
