package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.LoyalityGiftProduct;

@SuppressWarnings("rawtype")
@Repository
public interface LgiftProductRepository extends JpaRepository<LoyalityGiftProduct, Long> {
	
	 @Query(value="SELECT gp.gift_product_id, gp.giftproductname FROM medc_loyality.gift_products gp WHERE gp.companyrefid=:comid AND gp.branchrefid =:branchid AND gp.locname=:locname AND gp.locrefid=:locrefid AND gp.status =0",nativeQuery = true)
	    List getgiftproduct(@Param("comid") Integer comid,@Param("branchid") Integer branchid,@Param("locname") Integer locname, @Param("locrefid") Integer locrefid);
	 
	 @Query(value="SELECT lg.lgiftprod_id,lg.min_gift_point,lg.gift_code,lg.gift_product_id,lg.gift_product_qty,lg.product_value,date(lp.to_date) FROM medc_loyality.medc_lgiftproduct lg\r\n" + 
	 		"inner join medc_loyality.medc_loyalitypoints lp on lp.loyality_typeid=lg.loyality_typeid WHERE lg.gift_code like ?1%",nativeQuery = true)
	    List getgiftcarddetails(String giftcode);
	

	
}
