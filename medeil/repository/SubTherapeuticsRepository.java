package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.medeil.domain.SubTherapeutic;

@Repository
public interface SubTherapeuticsRepository extends JpaRepository<SubTherapeutic, Long> {

	@Query(value = "SELECT  subtherapeuticname FROM medc_productmaster.medc_subtherapeuticmaster where  subtherapeuticname=:stname and  therapeuticid=:tname", nativeQuery = true)
	String isSubTherapeuticExist(@Param("tname") int tname, @Param("stname") String stname);

	@Query(value = "SELECT  st.subtherapeuticid,t.therapeuticname,st.subtherapeuticname FROM medc_productmaster.medc_subtherapeuticmaster st left join medc_productmaster.medc_therapeuticmaster t on st.therapeuticid=t.Therapeuticid where  st.status!=2", nativeQuery = true)
	List viewTherapeutic();

	SubTherapeutic findById(int id);

	@Query(value = "SELECT  therapeuticname FROM medc_productmaster.medc_therapeuticmaster WHERE therapeuticID=:id and status!=2", nativeQuery = true)
	List getTherapeutic(@Param("id") int id);

	@Query(value = "SELECT count(*) FROM medc_productmaster.medc_subtherapeuticmaster WHERE  subtherapeuticname=:tname and  therapeuticid=:tid and not subtherapeuticid=:stid and status!=2", nativeQuery = true)
	Integer isTherapeuticUpdateExist(@Param("tid") int tid, @Param("tname") String tname, @Param("stid") int stid);

	@Modifying
	@Transactional
	@Query(value = "update medc_productmaster.medc_therapeuticmaster set Status=2 WHERE Therapeuticid=:id", nativeQuery = true)
	Integer deleteTherapeutic(@Param("id") int id);

	@Query(value = "SELECT Therapeuticid,TherapeuticName FROM medc_productmaster.medc_therapeuticmaster", nativeQuery = true)
	List LoadTherapeutics();
	
	
    @Query(value ="SELECT cmp.companyname,brn.branchname,loc.locationname,COALESCE(IFNULL(shp.shopname,''),IFNULL(whr.warehousename,''),IFNULL(hsp.hospitalname,''))AS name,loc1.locationname as Flocationame,COALESCE(IFNULL(shp1.shopname,''),IFNULL(whr1.warehousename,''),IFNULL(hsp1.hospitalname,''))AS Flocationname,loc2.locationname as Tlocation,COALESCE(IFNULL(shp2.shopname,''),IFNULL(whr2.warehousename,''),IFNULL(hsp2.hospitalname,''))AS Tlocationname,indentno,indentdate,ind.Status from medc_indentmaster.medc_indentreq ind left join medc_adminsecurity.medc_locationref loc on loc.id=ind.locname "
    		+ "left join medc_storereg.medc_shopinformation shp on shp.shopid=ind.locrefid and shp.locname=loc.id	"
    		+ "left join medc_warehousereg.medc_warehouseinfo whr on whr.warehouseid=ind.locrefid and whr.locname=loc.id  "
    		+ "left join medc_hospitalreg.hospitalregistration hsp on hsp.hospitalid=ind.locrefid and hsp.locname=loc.id "
    		+ "left join medc_adminsecurity.medc_locationref loc1 on loc1.id=ind.fromlocname "
    		+ "left join medc_storereg.medc_shopinformation shp1 on shp1.shopid=ind.fromlocid and shp1.locname=loc1.id "
    		+ "left join medc_warehousereg.medc_warehouseinfo whr1 on whr1.warehouseid=ind.fromlocid and whr1.locname=loc1.id  "
    		+ "left join medc_hospitalreg.hospitalregistration hsp1 on hsp1.hospitalid=ind.fromlocid and hsp1.locname=loc1.id "
    		+ "left join medc_adminsecurity.medc_locationref loc2 on loc2.id=ind.tolocname "
    		+ "left join medc_storereg.medc_shopinformation shp2 on shp2.shopid=ind.tolocid and shp2.locname=loc2.id "
    		+ "left join medc_warehousereg.medc_warehouseinfo whr2 on whr2.warehouseid=ind.tolocid and whr2.locname=loc2.id "
    		+ "left join medc_hospitalreg.hospitalregistration hsp2 on hsp2.hospitalid=ind.tolocid and hsp2.locname=loc2.id "
    		+ "left join medc_companyreg.medc_companyinfomation cmp on cmp.companyid=ind.companyrefid "
    		+ "left join medc_branchreg.medc_branchinfomation brn on brn.branchid=ind.branchrefid",nativeQuery=true)
	List viewIndentStatus();
}
