package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Printsetting;

@Repository
public interface Printsettingsrepository  extends JpaRepository<Printsetting, Long>{
	
	@Query(value = "SELECT p.formid,p.formname FROM medc_printsettings.print_forms p", nativeQuery = true)
	List viewDefaultforms();
	
	@Query(value = "SELECT p.printid,p.formid,pf.formname,p.printtypeid,p.printtype,p.printlabelid,p.printlabel,pm.printimage FROM medc_printsettings.print_settings p\r\n" + 
			"INNER JOIN medc_printsettings.print_forms pf ON pf.formid=p.formid\r\n" + 
			"LEFT JOIN medc_printsettings.print_images pm ON pm.imageid=p.printlabelid\r\n" + 
			"where pf.formid=p.formid and companyid =?1 and branchid=?2 and locname =?3 and locrefid =?4", nativeQuery = true)
	List viewprintsettings(int companyid,int branchid,int locname, int locrefid);
	
	@Query(value = "SELECT p.printid,pi.printurl,p.formid,p.printtypeid,p.printtype,p.printlabelid,p.printlabel FROM medc_printsettings.print_settings p\r\n" + 
			"inner join medc_printsettings.print_images pi on pi.imageid=p.printlabelid\r\n" + 
			"where p.companyid =?1 and p.branchid=?2 and p.locname =?3 and p.locrefid =?4 and p.formid =?5", nativeQuery = true)
	List viewformsprintmodel(int companyid,int branchid,int locname, int locrefid,int formid);

}
