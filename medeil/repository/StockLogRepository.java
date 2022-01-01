package com.medeil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.medeil.domain.StockLog;
@Repository
public interface StockLogRepository   extends JpaRepository<StockLog, Long>  {
	
	StockLog save( StockLog pr );
	

}



