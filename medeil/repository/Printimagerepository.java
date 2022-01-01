package com.medeil.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.Printimages;

@SuppressWarnings("rawtypes")
@Repository
public interface Printimagerepository extends JpaRepository<Printimages, Long> {
	
	//save print image
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_printsettings.print_images set ImageUrl=?1,Imagetype=?2,printimage=?3 ORDER BY imageid DESC LIMIT 1", nativeQuery = true)
	void imageuplaod(String originalFilename, String contentType, byte[] compressBytes);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE medc_printsettings.print_images set ImageUrl=?1,Imagetype=?2,printimage=?3 where imageid=?4", nativeQuery = true)
	void updateimageuplaod(String originalFilename, String contentType, byte[] compressBytes, int imageid);

	@Query(value = "SELECT printimage from medc_printsettings.print_images where formid=?1 and printtype=?2", nativeQuery = true)
	List<byte[]> getsendImage(Integer formid, Integer printtypeid);


	@Query(value = "SELECT imageid,printlabel,printurl from medc_printsettings.print_images where formid=?1 and printtype=?2", nativeQuery = true)
	List getprintimagevalues(Integer formid, Integer printtypeid);
	

}
