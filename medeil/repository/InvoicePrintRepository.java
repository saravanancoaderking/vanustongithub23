package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medeil.domain.Shop;

public interface InvoicePrintRepository extends JpaRepository<Shop, Long> {
	
	
	@Query(value =  "select  ms.shopname, concat (ms.Address1,' ', cy.cityname ), ms.MobileNo from medc_storereg.medc_shopinformation ms inner join medc_fixedsettings.medc_city cy on cy.cityid=ms.City where ms.CompanyRefID=:compid and ms.BranchRefID=:branchid and ms.LocName=:locname and ms.ShopID=:shopid and ms.LocRefID=:locrefid group by ms.shopid", nativeQuery = true)
   	List getInvoiceprintvalue(@Param("compid") int compid,
		@Param("branchid") int branchid, @Param("locname") int locname,
		@Param("locrefid") int locrefid,@Param("shopid") int shopid);
	

@Query(value =  "Select mcp.BrandName, mp.TotalQuantity,coalesce(mp.TotalProductPrice,0),coalesce((mp.TotalQuantity * mp.TotalProductPrice),0) as totalamount,md.DistributorName,concat (md.Address1,md.Address2,' ', dcy.cityname ), md.pincode, md.Email ,"
		+ "(select coalesce(sum(m.TotalQuantity * m.TotalProductPrice),0) as Total from medc_purchase.medc_poproduct m where m.porefid =:pono ) Grandtotal,mmp.pono FROM medc_purchase.medc_poproduct mp INNER JOIN medc_purchase.medc_purchaseorder mmp ON mmp.poid = mp.porefid"
		+ " inner join medc_distributor.medc_distributorinformation md on md.distributorid=mmp.vendorid"
		+ " inner join medc_fixedsettings.medc_city dcy on dcy.cityid=md.City"
		+ " INNER JOIN medc_productmaster.medc_custproductmaster mcp ON mcp.productdrugid = mp.drugproductrefid"
		+ " WHERE mp.Companyrefid =:compid  and mp.branchrefid =:branchid and mp.Locname =:locname and mp.Locrefid =:locrefid and mmp.POID =:pono ", nativeQuery = true)
	List getInvoiceDetailvalue(@Param("compid") int compid,
		@Param("branchid") int branchid, @Param("locname") int locname,
		@Param("locrefid") int locrefid,@Param("pono") int pono);
}
