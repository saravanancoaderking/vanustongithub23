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

import com.medeil.domain.VanustonProductMaster;

@Repository
public interface VanustonProductMasterRepository extends JpaRepository<VanustonProductMaster, Long> {

	// Boopalan 071119

	/***** View DrugMaster *****/
	@Query(value = "SELECT pm.productdrugid,coalesce(pm.BrandName,'zin'),coalesce(gn.GenericName,'zsc'),pm.UniformProductCode,coalesce(pm.GenericNameDosage,'zen'),tm.VAT,pm.GST,coalesce(fo.FormulationName,'zof'),pm.mrp FROM medc_productmaster.medc_vanustonproductmaster pm\r\n"
			+ "LEFT JOIN medc_productmaster.medc_formulation fo on fo.FormulationID=pm.formulationid\r\n"
			+ "LEFT JOIN medc_productmaster.medc_genericmaster gn on gn.GenericID=pm.genericID\r\n"
			+ "left join medc_globalsettings.medc_taxvatmaster tm on tm.VatTaxID=pm.VAT\r\n"
			+ "WHERE DrugStatus!=5 ORDER BY pm.productDrugID asc", nativeQuery = true)
	List viewVanustonDrugmasters();

	/***** View Vanuston DrugMaster Image *****/
	@Query(value = "SELECT m.image_url FROM medc_productmaster.medc_vanustonproductmaster m where m.ProductDrugID=?1 ", nativeQuery = true)
	String getsendVanustonImage(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value = "update medc_productmaster.medc_vanustonproductmaster set image_url =?1,image_filename=?3  where ProductDrugID=?2   ", nativeQuery = true)
	int uploadDrugImagePath(String file, int drugproductid, String filename);

	/***** Drug View Details *****/
	// Boopalan 170419 removed -> coalesce(GenericID,0)
	@Query(value = "select ProductDrugID,coalesce(BrandName,0),coalesce(GenericID,0),coalesce(GenericNameDosage,0),"
			+ "coalesce(UOM,0),coalesce(VAT,0), coalesce(CGST,0), coalesce(IGST,0), coalesce(SGST,0), coalesce(FormulationID,0),"
			+ "coalesce(SchudleType,0),coalesce(MRP,0),coalesce(MinQty,0), coalesce(MaxQty,0),coalesce(BannedDrug,0),coalesce(BannedDrugReason,0), "
			+ "coalesce(Boxpercartoon,0), coalesce(Stripperbox,0), coalesce(Quantityperstrip,0), coalesce(GST,0),"
			+ "coalesce(ProductRegNo,0),coalesce(DistImporterID,0),coalesce(LocName,0),coalesce(LocRefID,0), "
			+ "coalesce(companyID,0), coalesce(BranchID,0) from medc_productmaster.medc_vanustonproductmaster "
			+ "where ProductDrugID= :id", nativeQuery = true)
	List drugEditvalues(@Param("id") int id);

	/***** Drug DeleteMaster *****/
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_productmaster.medc_vanustonproductmaster set DrugStatus='5' WHERE  ProductDrugID= :id", nativeQuery = true)
	void deleteDruginfo(@Param("id") int id);

	@Query(value = "SELECT verticalid, verticalname, countryid, vertical_ranking FROM medc_productmaster.medc_vanustonvertical  where countryid =?1", nativeQuery = true)
	List vanustonVerticalID(int id);

	@Query(value = "SELECT * FROM medc_fixedsettings.medc_taxtype where countryrefid =?1", nativeQuery = true)
	List GetTaxCountryWise(int id);
	
	List<VanustonProductMaster> findAllByBrandnameStartingWith(String productname);
	
	VanustonProductMaster findByProductdrugid(Integer id);

}
