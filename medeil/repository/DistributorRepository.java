
package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Distributor;

@Transactional
@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {

	Distributor save(Distributor phcom);

	Distributor findById(int frmint1);

	@Transactional
	@Modifying
	@Query(value = "insert into medc_distributor.medc_distributortype  ( LocName,LocRefID,  DistributorTypeName   ) values ( ?1,?2,?3 )", nativeQuery = true)
	int saveIndvDistType(int lcrnm, int lcrid, String divisioname);

	@Transactional
	@Modifying
	@Query(value = "	insert into medc_distributor.medc_distphcompany ( LocName,LocRefID,  PhCompanyRefID,DistRefID ) values ( ?1,?2,?3,?4 )", nativeQuery = true)
	int saveDistPhcompany(int lcrnm, int lcrid, int phid, int distid);

	@Query(value = "SELECT  IFNULL( MAX( DistributorID ),0 )   FROM medc_distributor.medc_distributorinformation       where  LocName=?1 and LocRefID=?2    ", nativeQuery = true)
	Integer viewDistributorId(Integer lcrnm, Integer lcrid);

	@Query(value = " SELECT  IFNULL( RIGHT( distno, 7 ),0 )  FROM   medc_distributor.medc_distributorinformation      where  DistributorID=?3 and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	String viewDistributorIncNo(Integer lcrnm, Integer lcrid, Integer id);

	@Query(value = "SELECT * FROM medc_distributor.medc_distributortype       where  LocName=?1 and LocRefID=?2   ", nativeQuery = true)
	List viewDistType(int lcrnm, int lcrid);

	@Query(value = "SELECT * FROM medc_distributor.medc_distributorinformation    where  LocName=?1 and LocRefID=?2   and Status!=5  order by  DistributorID desc", nativeQuery = true)
	List viewDistributors(int lcrnm, int lcrid);

	@Query(value = "SELECT * FROM medc_distributor.medc_distributorinformation    where  DistributorID =?3 and  LocName=?1 and LocRefID=?2   ", nativeQuery = true)
	List viewDistributor(int lcrnm, int lcrid, int id);

	@Query(value = "SELECT pm.PCompanyID,pm.PCompanyName FROM medc_pharmacompany.medc_pharmacompanies pm INNER JOIN medc_storereg.medc_shopinformation sh ON sh.country=pm.CountryofOrigin AND sh.ShopID=pm.LocRefID\r\n" + 
			"where  sh.ShopID=?1 or pm.CompanyRefID=1 and pm.Status!=5  ORDER BY PCompanyName ASC ", nativeQuery = true)
	List viewPhCompanies( int lcrid);

	@Query(value = "  SELECT  ph.PCompanyID,ph.PCompanyName,dist.DistRefID FROM medc_distributor.medc_distphcompany  dist left join (SELECT   PCompanyID,PCompanyName   FROM medc_pharmacompany.medc_pharmacompanies     where  LocName=?1 and LocRefID=?2 and    Status!=5 )ph  on   ph.PCompanyID = dist.PhCompanyRefID   where  dist.DistRefID=?3  and  dist.LocName=?1 and dist.LocRefID=?2  ", nativeQuery = true)
	List viewDistPhCompanies(int lcrnm, int lcrid, Integer distid);

	// selva

	@Modifying
	@Transactional
	@Query(value = "update    medc_distributor.medc_distributorinformation  set   Status=5  where  DistributorID=?3 and  LocName=?1 and LocRefID=?2  ", nativeQuery = true)
	int deleteDistributor(int lcrnm, int lcrid, int name);

	@Query(value = "SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation WHERE status=0 ", nativeQuery = true)
	List Distinfo();

	@Query(value = "SELECT DistributorID,DistributorName FROM medc_distributor.medc_distributorinformation WHERE CompanyrefID=:comid and branchrefid =:branchid and locname=:locname and locrefid =:locrefid", nativeQuery = true)
	List Distinfo1(@Param("comid") int comid, @Param("branchid") int branchid, @Param("locname") int locname, @Param("locrefid") int locrefid);

	//Desing 040419  Inventory Report/StkTrans by Product
	@Query(value = "SELECT stktrfid,stktrfno FROM medc_stock.medc_stocktransfer where companyrefid =:cid and branchrefid =:bid and locname =:lnid and locrefid =:lrid", nativeQuery = true)
	List StktrnNo(@Param("cid") int cid, @Param("bid") int bid, @Param("lnid") int lnid, @Param("lrid") int lrid);

	@Query(value = "SELECT stateid,statename FROM medc_fixedsettings.medc_state  where stateid = :id ", nativeQuery = true)
	public List editDistsstate(@Param("id") Integer id);

	@Query(value = "SELECT cityid,cityname FROM medc_fixedsettings.medc_city  where cityid = :id ", nativeQuery = true)
	public List editDistscity(@Param("id") Integer id);

	@Query(value = "SELECT DisttypeID,DistributorTypeName FROM medc_distributor.medc_distributortype where DisttypeID = :id", nativeQuery = true)
	public List editDiststype(@Param("id") Integer id);

	
	// Desing 120419 Purchase Report/BatchNamewise Purchase
	@Query(value = "SELECT batchno,batchname FROM medc_stock.medc_mainstock WHERE batchname like :str%  and  "
			+ "     companyrefid=:cid and branchrefid =:bid and locname =:lnid and locrefid =:lrid", nativeQuery = true)
	List BatchNo(@Param("str") String str, @Param("cid") int cid, @Param("bid") int bid, @Param("lnid") int lnid,
			@Param("lrid") int lrid);
	
	
	//Desing 040419 Inventory Report/Requisition No by Product
		@Query(value = "SELECT indentreqid, indentno FROM medc_indentmaster.medc_indentreq where companyrefid =:cid and branchrefid =:bid and locname =:lnid and   locrefid =:lrid", nativeQuery = true)
		List IndReqNo(@Param("cid") int cid, @Param("bid") int bid, @Param("lnid") int lnid, @Param("lrid") int lrid);
	
		//Desing 070519 Purchase Report/PurchaseInvoicewise
		@Query(value = "SELECT  piid , pino FROM medc_purchase.medc_purchaseinvoice where  companyrefid =:cid and branchrefid =:bid and locname =:lnid and locrefid =:lrid",nativeQuery = true)
		List PurInvoiceNo(@Param("cid") int cid, @Param("bid") int bid, @Param("lnid") int lnid, @Param("lrid") int lrid);

		//Desing 070519 Purchase Report/PurchaseInvoicewise
		@Query(value = "SELECT dis.distributorid,dis.distributorname FROM medc_distributor.medc_distributorinformation dis\r\n" + 
				"Where dis.companyrefid=?1 and dis.branchrefid=?2 and dis.locname=?3 and dis.locrefid=?4  and dis.distributorname like ?5%",nativeQuery = true)
		List getdistliost(@Param("cid") Integer cid, @Param("bid") Integer bid, @Param("lnid") Integer lnid, @Param("lrid") Integer lrid,@Param("searchkey") String searchkey);
		
}