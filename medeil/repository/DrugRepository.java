/**
 * 
 */
package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Drug;

/**
 * @author Ajith Kumar
 *
 */
@SuppressWarnings("rawtypes")
@Repository
public interface DrugRepository extends JpaRepository<Drug, Integer> {

	Drug findById(int id);
	
	boolean existsByUniformproductcode(String Uniformproductcode);
	
	@Query(value = "SELECT GroupID, GroupName FROM medc_productmaster.medc_group where verticalid=:verticalid group by groupname", nativeQuery = true)
	List getMain(@Param("verticalid") Integer verticalid);

	@Query(value = "SELECT m.SubGroupID1, m.SubGroupName1 FROM medc_productmaster.medc_subgroup1 m\n" + 
			"where m.verticalid=:verticalid and m.GroupRefId=:value group by m.subgroupname1", nativeQuery = true)
	List getsubgroup1(@Param("verticalid") Integer verticalid, @Param("value") String value);

	@Query(value = "SELECT m.SubGroupID2, m.SubGroupName2 FROM medc_productmaster.medc_subgroup2 m\n" + 
			"where m.SubGroupRefID1=:value and m.verticalid=:verticalid group by m.subgroupname2", nativeQuery = true)
	List getsubgroup2(@Param("verticalid") Integer verticalid, @Param("value") String value);

	@Query(value = "SELECT GenericID,GenericName FROM medc_productmaster.medc_genericmaster WHERE GenericName LIKE  :value%", nativeQuery = true)
	List getGeneric(@Param("value") String value);

	@Query(value = "SELECT GenericCombinationID, GenericCombinationalname FROM medc_productmaster.medc_genericcombinations WHERE GenericCombinationalname LIKE %:value%", nativeQuery = true)
	List genericCombination(@Param("value") String value);

	@Query(value = "SELECT DosageID,DosageValue FROM medc_productmaster.medc_dosagemaster", nativeQuery = true)
	List getDosage();

	@Query(value = "SELECT uomID, UOMName FROM medc_productmaster.medc_uom", nativeQuery = true)
	List getUom();

	@Query(value = "SELECT FormulationID, FormulationName FROM medc_productmaster.medc_formulation where status=0", nativeQuery = true)
	List getFormulation();

	@Query(value = "SELECT  ScheduleID, ScheduleName FROM medc_productmaster.medc_schedule", nativeQuery = true)
	List getSchedule();

	@Query(value = "SELECT InsuranceCompanyID,CompanyName FROM medc_insurance.insurancecompanyregistration WHERE status=0", nativeQuery = true)
	List getInsurance();

	/***** Drug Insurance Details *****/
	@Query(value = "select MAX(ProductDrugID) as drugid FROM medc_productmaster.medc_custproductmaster WHERE companyID= :comid and BranchID= :brid and LocName= :locname and LocRefID= :lrefID and drugStatus=0", nativeQuery = true)
	Integer maxInsurence(@Param("comid") int comid, @Param("brid") int brid, @Param("locname") int locname,
			@Param("lrefID") int lrefID);

	@Query(value = "SELECT ins.InsuranceCompanyID,ins.CompanyName FROM medc_insurance.insurancecompanyregistration ins "
			+ "INNER JOIN medc_productmaster.medc_insurancepdt mins ON ins.InsuranceCompanyID=mins.InsRefID "
			+ "Where DrugProductRefID= :id and ins.status=0", nativeQuery = true)
	List geteditInsurance(@Param("id") int id);

	/***** Drug View Details *****/
	// Boopalan 170419 removed -> coalesce(GenericID,0)
	@Query(value = "select ProductDrugID,coalesce(BrandName,0),coalesce(GenericID,0),coalesce(GenericNameDosage,0),coalesce(UOM,0),coalesce(VAT,0),\n" + 
			"coalesce(CGST,0), coalesce(IGST,0), coalesce(SGST,0), coalesce(FormulationID,0),coalesce(SchudleType,0),\n" + 
			"coalesce(MRP,0),coalesce(MinQty,0), coalesce(MaxQty,0),coalesce(BannedDrug,0),coalesce(BannedDrugReason,0),\n" + 
			"coalesce(Boxpercartoon,0), coalesce(Stripperbox,0), coalesce(Quantityperstrip,0), coalesce(GST,0),coalesce(ProductRegNo,0),\n" + 
			"coalesce(DistImporterID,0),coalesce(LocName,0),coalesce(LocRefID,0),coalesce(companyID,0), coalesce(BranchID,0),coalesce(UniformProductCode,'Nil'),\n" + 
			"coalesce(temperature,'0C'),stock_available,coalesce(emergency_type,'No'),coalesce(narcoticdrug,'No'),coalesce(hanzoration_drug,'No'),\n" + 
			"coalesce(production_sunlight,'No'),coalesce(sanitizing,'No'),verticalid,coalesce(coldstorage,'No'),groupid,subgroupid1,subgroupid2,coalesce(pharmacompanyid,0),hsnid\n" + 
			"from medc_productmaster.medc_custproductmaster where ProductDrugID=:id", nativeQuery = true)
	List drugEditvalues(@Param("id") int id);

	
	// Boopalan 300419
	@Query(value = "SELECT distimporterid FROM medc_productmaster.medc_custproductmaster m where productdrugid =:id", nativeQuery = true)
	List geteditDistributorChannel(@Param("id") int id);

	// Boopalan 040619
	@Query(value = "SELECT pm.BrandName,gn.GenericName,pm.UniformProductCode,pm.GenericNameDosage,tm.VAT,pm.GST,fo.FormulationName,coalesce(pm.mrp,0),pm.ProductDrugID FROM medc_productmaster.medc_custproductmaster pm "
			+ "LEFT JOIN medc_productmaster.medc_formulation fo on fo.FormulationID=pm.formulationid "
			+ "LEFT JOIN medc_productmaster.medc_genericmaster gn on gn.GenericID=pm.genericID left join medc_globalsettings.medc_taxvatmaster tm on tm.VatTaxID=pm.VAT "
			+ "WHERE DrugStatus!=5 and pm.companyid= :id ORDER BY pm.productDrugID asc \n#page\n", countQuery = "select count(companyid) from medc_productmaster.medc_custproductmaster WHERE DrugStatus!=5 and companyid= :id ORDER BY productDrugID asc", nativeQuery = true)
	Page viewDrugmasters(@Param("id") int id, @Param("page") Pageable page);
	
	@Query(value = "SELECT pm.productdrugid,coalesce(pm.BrandName,'zin'),coalesce(gn.GenericName,'zsc'),pm.UniformProductCode,coalesce(pm.GenericNameDosage,'zen'),\n" + 
			"tm.VAT,pm.GST,coalesce(fo.FormulationName,'zof'),pm.mrp,pc.PCompanyName,hsn.hsncode,hsn.hsndescription,sch.schedulename FROM medc_productmaster.medc_custproductmaster pm\n" + 
			"LEFT JOIN medc_productmaster.medc_formulation fo on fo.FormulationID=pm.formulationid\n" + 
			"LEFT JOIN medc_productmaster.medc_genericmaster gn on gn.GenericID=pm.genericID\n" + 
			"LEFT JOIN medc_pharmacompany.medc_pharmacompanies pc on pc.PCompanyID=pm.pharmacompanyid\n" + 
			"left join medc_globalsettings.medc_taxvatmaster tm on tm.VatTaxID=pm.VAT\n" + 
			"left join medc_productmaster.medc_hsncodemaster hsn on hsn.HSNID=pm.hsnid\n" + 
			"left join medc_productmaster.medc_schedule sch on sch.ScheduleID=pm.schudletype\n" + 
			"WHERE pm.DrugStatus!=5 and pm.companyid=?1 ORDER BY pm.productDrugID desc", nativeQuery = true)
	List viewDrugmastersAll(Integer cid);
	
	@Query(value = "SELECT pm.productdrugid,coalesce(pm.BrandName,'zin'),coalesce(gn.GenericName,'zsc'),coalesce(pm.GenericNameDosage,'zen'),\n" + 
			"coalesce(fo.FormulationName,'zof'),pm.UniformProductCode FROM medc_productmaster.medc_custproductmaster pm\n" + 
			"LEFT JOIN medc_productmaster.medc_genericmaster gn on gn.GenericID=pm.genericID\n" + 
			"LEFT JOIN medc_productmaster.medc_formulation fo on fo.FormulationID=pm.formulationid\n" + 
			"WHERE pm.DrugStatus!=5 and pm.companyid=?1 and pm.brandname like ?2%", nativeQuery = true)
	List viewSearchDrugmastersAll(Integer cid, String svalue);
	
	@Query(value = "SELECT cm.genericrefid,cm.genericname,cm.genericcode,cm.combinationcode FROM medc_productmaster.medc_custproductmaster pm\n" + 
			"inner join medc_productmaster.medc_combinationmaster cm on cm.combinationcode=pm.genericcombination where pm.productdrugid=?1", nativeQuery = true)
	List viewCombGenericAll(Integer drugid);
	
	/***** Drug Product Search *****/
	// Puthiran 261219
	@Query(value = "SELECT pm.BrandName,gn.GenericName,pm.UniformProductCode,pm.GenericNameDosage,tm.VAT,pm.GST,fo.FormulationName,coalesce(pm.mrp,0),pm.ProductDrugID FROM medc_productmaster.medc_custproductmaster pm "
			+ "LEFT JOIN medc_productmaster.medc_formulation fo on fo.FormulationID=pm.formulationid "
			+ "LEFT JOIN medc_productmaster.medc_genericmaster gn on gn.GenericID=pm.genericID left join medc_globalsettings.medc_taxvatmaster tm on tm.VatTaxID=pm.VAT "
			+ "WHERE DrugStatus!=5 and pm.companyid= :id and brandname like :searchvalue% ORDER BY pm.productDrugID asc \n#page\n", countQuery = "select count(ProductDrugID) from medc_productmaster.medc_custproductmaster WHERE DrugStatus!=5 and companyid= :id and brandname like :searchvalue%", nativeQuery = true)
	Page searchdrugproduct(@Param("id") int id, @Param("searchvalue") String searchvalue, @Param("page") Pageable page);

	/***** Drug Generic Search *****/
	// Puthiran 261219
	@Query(value = "SELECT pm.BrandName,gn.GenericName,pm.UniformProductCode,pm.GenericNameDosage,tm.VAT,pm.GST,fo.FormulationName,coalesce(pm.mrp,0),pm.ProductDrugID FROM medc_productmaster.medc_custproductmaster pm "
			+ "LEFT JOIN medc_productmaster.medc_formulation fo on fo.FormulationID=pm.formulationid "
			+ "LEFT JOIN medc_productmaster.medc_genericmaster gn on gn.GenericID=pm.genericID left join medc_globalsettings.medc_taxvatmaster tm on tm.VatTaxID=pm.VAT "
			+ "WHERE DrugStatus!=5 and pm.companyid= :id and generic_name  like :searchvalue% ORDER BY pm.productDrugID asc \n#page\n", 
			countQuery = "select count(ProductDrugID) from medc_productmaster.medc_custproductmaster WHERE DrugStatus!=5 and companyid= :id and generic_name like :searchvalue%", nativeQuery = true)
	Page searchdruggeneric(@Param("id") int id, @Param("searchvalue") String searchvalue, @Param("page") Pageable page);

	/***** Drug DeleteMaster *****/
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_productmaster.medc_custproductmaster set DrugStatus='5' WHERE  ProductDrugID= :id", nativeQuery = true)
	void deleteDruginfo(@Param("id") int id);

	@Query(value = "SELECT atc4.Chemicalsubstance,(atc3.Description) as desc3,(atc2.Description) as desc2,(atc1.Description)as desc1,(pr.Description) as desc0,gen.GenericName FROM medc_productmaster.medc_atc_child4 atc4 "
			+ "INNER JOIN medc_productmaster.medc_atc_child3 atc3 ON atc3.AtcChildId3=atc4.AtcChildId3RefId "
			+ "INNER JOIN medc_productmaster.medc_atc_child2 atc2 ON atc2.AtcChildId2=atc3.AtcChildId2RefId "
			+ "INNER JOIN medc_productmaster.medc_atc_child1 atc1 ON atc1.AtcChildId1=atc2.AtcChildId1RefId "
			+ "INNER JOIN medc_productmaster.medc_atc_parent pr ON  pr.AtcParentID=atc1.AtcParentRefId "
			+ "INNER JOIN medc_productmaster.medc_genericmaster gen ON gen.GenericID=atc4.GenericRefID "
			+ "WHERE atc4.GenericRefID= :id", nativeQuery = true)
	List getATC(@Param("id") int id);

	@Query(value = "SELECT MAX(CombinationID + 1) as id FROM medc_productmaster.medc_newcombinationtest", nativeQuery = true)
	Integer maxComID();

	@Query(value = "SELECT PhotoName FROM medc_productmaster.medc_custprdphoto WHERE DrugProductRefID= :id", nativeQuery = true)
	List getFilename(@Param("id") String id);

	// Edit Drug Form
	@Query(value = "SELECT FormulationID, FormulationName FROM medc_productmaster.medc_formulation where status=0 and FormulationID= :id", nativeQuery = true)
	List geteditFormulation(@Param("id") int id);

	@Query(value = "SELECT ScheduleID, ScheduleName FROM medc_productmaster.medc_schedule where ScheduleID= :id", nativeQuery = true)
	List editSchedule(@Param("id") int id);
	
	@Query(value = "SELECT pcompanyid,pcompanyname FROM medc_pharmacompany.medc_pharmacompanies where pcompanyid= :id", nativeQuery = true)
	List geteditManufacture(@Param("id") int id);

	/*** Boopalan Edit START ***/
	@Query(value = "SELECT VatTaxID,VAT FROM medc_globalsettings.medc_taxvatmaster where VatTaxID= :id", nativeQuery = true)
	List editVat(@Param("id") int id);

	@Query(value = "SELECT GstTaxID,GST FROM medc_globalsettings.medc_taxgstmaster where GstTaxID= :id", nativeQuery = true)
	List editGst(@Param("id") int id);

	@Query(value = "SELECT SgstTaxID,SGST FROM medc_globalsettings.medc_taxsgstmaster where SgstTaxID= :id", nativeQuery = true)
	List editSgst(@Param("id") int id);

	@Query(value = "SELECT CgstTaxID,CGST FROM medc_globalsettings.medc_taxcgstmaster where CgstTaxID= :id", nativeQuery = true)
	List editCgst(@Param("id") int id);

	@Query(value = "SELECT IgstTaxID,IGST FROM medc_globalsettings.medc_taxigstmaster where IgstTaxID= :id", nativeQuery = true)
	List editIgst(@Param("id") int id);

	/*** Boopalan Edit END ***/

	@Query(value = "SELECT GenericID,GenericName FROM medc_productmaster.medc_genericmaster WHERE GenericID= :id", nativeQuery = true)
	List geteditGeneric(@Param("id") int id);

	/********* EDIT GENERIC ID **************/ // Boopalan 170419
	@Query(value = "SELECT gm.GenericID,gm.GenericName FROM medc_productmaster.medc_genericmaster gm inner join  medc_productmaster.medc_custproductmaster  cu on cu.GenericID = gm.GenericID WHERE ProductDrugID=:id", nativeQuery = true)
	List geteditGenericid(@Param("id") int id);

	@Query(value = "SELECT GenericName FROM medc_productmaster.medc_genericmaster WHERE GenericID= :id", nativeQuery = true)
	String getGenericName(@Param("id") int id);

	/**** EDIT MAIN GROUP ****/ // Boopalan 190419
	@Query(value = "SELECT mg.GroupID, mg.GroupName FROM medc_productmaster.medc_group mg inner join medc_productmaster.medc_custproductmaster cu on cu.categoryid = mg.GroupID where cu.productdrugid =:value", nativeQuery = true)
	List getEdtMain(@Param("value") Integer value);

	/**** EDIT MAIN GROUP ****/ // Boopalan 190419
	@Query(value = "SELECT m.SubGroupID1, m.SubGroupName1 FROM medc_productmaster.medc_subgroup1 m inner join medc_productmaster.medc_custproductmaster cu on cu.subcategoryid = m.SubGroupID1 where cu.productdrugid =:value", nativeQuery = true)
	List subgroup1(@Param("value") Integer value);

	/**** EDIT MAIN GROUP ****/ // Boopalan 190419
	@Query(value = "SELECT m.SubGroupID2, m.SubGroupName2 FROM medc_productmaster.medc_subgroup2 m inner join medc_productmaster.medc_custproductmaster cu on cu.subcategory2 = m.SubGroupID2 where cu.productdrugid =:value", nativeQuery = true)
	List subgroup2(@Param("value") Integer value);

	// Boopalan 071119
	@Modifying
	@Transactional
	@Query(value = "update medc_productmaster.medc_custproductmaster set image_url =?1,image_filename=?3  where ProductDrugID=?2   ", nativeQuery = true)
	int uploadDrugImagePath(String file, int drugproductid, String filename);
	
	@Modifying
	@Transactional
	@Query(value = "update medc_productmaster.medc_vanustonproductmaster set image_url =?1,image_filename=?3  where ProductDrugID=?2   ", nativeQuery = true)
	int VanustonDrugImagePath(String file, int drugproductid, String filename);


	/**** EDIT MAIN GROUP ****/ // Boopalan 190419
	@Query(value = "SELECT coalesce(max(m.UniformProductCode),'EMSPH000000') as UniformProductCode  FROM medc_productmaster.medc_custproductmaster m where m.companyID=?1 and m.BranchID=?2 and m.LocName=?3 and m.LocRefID=?4", nativeQuery = true)
	String UniformProductCode(int comid, int brid, int locname, int lrefID);

	@Query(value = "SELECT gm.genericid,fu.formulationid,cu.genericnamedosage from medc_productmaster.medc_custproductmaster cu\r\n"
			+ "inner join medc_productmaster.medc_formulation fu on fu.formulationid=cu.formulationid\r\n"
			+ "inner join medc_productmaster.medc_genericmaster gm on gm.genericid=cu.genericid\r\n"
			+ "where productdrugid=?1", nativeQuery = true)
	List<Object[]> getSubstituteDrugDetails(int drugid);

	@Query(value = "SELECT m.image_url FROM medc_productmaster.medc_custproductmaster m where m.ProductDrugID=?1 ", nativeQuery = true)
	String getsendImage(@Param("id") int id);
	
	//DesingRaja
	@Query(value= "SELECT cpm.productdrugid,CONCAT(cpm.brandname,' ',genericnamedosage),gm.genericname,cpm.drugbannedfrom,cpm.banneddrugreason FROM medc_productmaster.medc_custproductmaster cpm\r\n" + 
			"INNER JOIN medc_productmaster.medc_genericmaster gm ON gm.genericid = cpm.genericid\r\n" + 
			"WHERE countryid =:countryid AND banneddrug=:bannedstatus"  , nativeQuery = true)
	List getbanneddrug(@Param("countryid") Integer countryid, @Param("bannedstatus") Integer bannedstatus);
	
   @Query(value = "SELECT cpm.productdrugid,CONCAT(cpm.brandname,' ',cpm.genericnamedosage) brandname,f.formulationname,gm.genericname FROM medc_productmaster.medc_custproductmaster cpm\r\n" + 
   		"INNER JOIN medc_productmaster.medc_formulation f ON f.formulationid =cpm.formulationid\r\n" + 
   		"INNER JOIN medc_productmaster.medc_genericmaster gm ON gm.genericid = cpm.genericid\r\n" + 
   		"WHERE cpm.BrandName like  ?2% AND cpm.countryid =?1 ORDER BY cpm.BrandName  LIMIT 10 ", nativeQuery = true)
	List viewProductNames(int countryid, String searchvalue);
	//DesingRaja
	@Query(value = "SELECT cpm.productdrugid,CONCAT(cpm.brandname,' ',cpm.genericnamedosage) brandname,f.formulationname,gm.genericid,gm.genericname FROM medc_productmaster.medc_custproductmaster cpm\r\n" + 
			"INNER JOIN medc_productmaster.medc_formulation f ON f.formulationid =cpm.formulationid\r\n" + 
			"INNER JOIN medc_productmaster.medc_genericmaster gm ON gm.genericid = cpm.genericid\r\n" + 
			"WHERE gm.genericname like  ?2% AND cpm.countryid =?1 AND cpm.banneddrug = 0 GROUP BY gm.genericname ORDER BY cpm.BrandName  LIMIT 10 ", nativeQuery = true)
	List viewGenericNames(int countryid, String searchvalue);

	//DesingRaja
	
	@Query(value = "SELECT cpm.productdrugid,CONCAT(cpm.brandname,' ',cpm.genericnamedosage) brandname,f.formulationname,gm.genericname,sch.schedulename,cpm.genericid FROM medc_productmaster.medc_custproductmaster cpm\r\n" + 
			"INNER JOIN medc_productmaster.medc_formulation f ON f.formulationid =cpm.formulationid\r\n" + 
			"INNER JOIN medc_productmaster.medc_genericmaster gm ON gm.genericid = cpm.genericid\r\n" + 
			"INNER JOIN medc_productmaster.medc_schedule sch ON sch.scheduleid = cpm.schudletype\r\n" + 
			"WHERE cpm.genericid =:genericid AND cpm.countryid =:countryid ORDER BY cpm.BrandName  LIMIT 10", nativeQuery=true)
	List productdata(@Param("genericid") Integer genericid, @Param("countryid") Integer countryid);
	/**** EDIT MAIN GROUP ****/ // Boopalan 190419
	@Query(value = "SELECT coalesce(max(m.UniformProductCode),'VANPM000000') as UniformProductCode  FROM medc_productmaster.medc_vanustonproductmaster m", nativeQuery = true)
	String UniformProductCode();

	//DesingRaja
	@Modifying
	@Transactional
	@Query(value="UPDATE medc_productmaster.medc_custproductmaster cpm SET cpm.banneddrug =1,cpm.banneddrugreason =:reason,drugbannedfrom =:bannedfrom WHERE cpm.genericid =:genericid AND cpm.countryid =:countryid" , nativeQuery = true)
	void updatebanneddrug(@Param("genericid") Integer genericid, @Param("countryid") Integer countryid,@Param("bannedfrom") String bannedfrom, @Param("reason") String reason);

	//Desingraja
	
	@Query(value = "SELECT bd.banneddrugid,bd.banned_drug_name, bd.gsr_no,date(bd.banned_from) FROM medc_productmaster.medc_banneddruglist bd WHERE bd.countryid =:countryid", nativeQuery=true)
	List viewbangen(@Param("countryid") Integer countryid);
	
	//Puthiran Vanuston Drugs
	@Query(value = "SELECT vp.ProductDrugID, vp.BrandName,vp.UniFormProductCode,vp.GenericNameDosage,vp.Generic_Name\n" + 
			"FROM medc_productmaster.medc_vanustonproductmaster vp where vp.countryid=?1 and vp.BrandName like ?2%", nativeQuery = true)
	List VanustonProducts(Integer countryid, String searchvalue);

	boolean existsByBrandnameAndGenericnamedosageAndCompanyidAndBranchidAndLocnameAndLocrefid(String brandname,
			String genericnamedosage, Integer companyid, Integer branchid, Integer locname, Integer locrefid);


	boolean existsByBrandnameAndCompanyidAndBranchidAndLocnameAndLocrefid(String brandname, Integer companyid,
			Integer branchid, Integer locname, Integer locrefid);
	
	@Query(value = "SELECT m.pcompanyid,m.pcompanyname,m.pshortname,m.pmobileno FROM medc_pharmacompany.medc_pharmacompanies m\r\n" + 
			"WHERE m.CompanyRefID =?1 AND m.BranchRefID =?2 AND m.LocName =?3 AND m.LocRefID =?4 AND m.pcompanyname LIKE ?5%", nativeQuery = true)
	List searchmanufacture(Integer compid, Integer branchid, Integer locname, Integer locrefid, String searchkey);
      
	
	@Query(value="SELECT COUNT(ProductDrugID) FROM medc_productmaster.medc_custproductmaster where companyID=?1 AND BranchID=?2 AND LocName=?3 and LocRefID=?4 and Groupid=?5 and Subgroupid1=?6", nativeQuery = true)
	Integer skuauto(Integer companyid, Integer branchid, Integer locname, Integer locrefid, Integer groupid,Integer subgroupid1);

	
}
