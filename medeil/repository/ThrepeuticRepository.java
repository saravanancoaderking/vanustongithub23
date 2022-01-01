package com.medeil.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.medeil.domain.Branch;
import com.medeil.domain.Therapeutic;

@Repository
public interface  ThrepeuticRepository extends JpaRepository<Therapeutic, Long>{

	@Query(value = "SELECT  therapeuticname FROM medc_productmaster.medc_therapeuticmaster where therapeuticname=:tname",nativeQuery=true)
	String isExistTherapeutic(@Param("tname") String tname);
	
	@Query(value ="SELECT  therapeuticID,therapeuticname FROM medc_productmaster.medc_therapeuticmaster where  status!=2",nativeQuery=true)
	List viewTherapeutic();
	
	Therapeutic findById(int id); 
	
	
	@Query(value ="SELECT  therapeuticname FROM medc_productmaster.medc_therapeuticmaster WHERE therapeuticID=:id and status!=2",nativeQuery=true)
	List getTherapeutic(@Param("id") int id);
	
	@Query(value = "SELECT Therapeuticid,TherapeuticName FROM medc_productmaster.medc_therapeuticmaster WHERE  TherapeuticName=:tname and not Therapeuticid=:tid and status!=2",nativeQuery=true)
	String isTherapeuticUpdateExist(@Param("tname") String tname,@Param("tid") int tid);
	
	@Modifying
	@Transactional
	@Query(value="update medc_productmaster.medc_therapeuticmaster set Status=2 WHERE Therapeuticid=:id",nativeQuery=true)
	Integer deleteTherapeutic(@Param("id") int id);
}
