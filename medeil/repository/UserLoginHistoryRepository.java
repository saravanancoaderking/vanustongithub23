package com.medeil.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medeil.domain.UserLoginHistory;

@Repository
public interface UserLoginHistoryRepository extends JpaRepository<UserLoginHistory, Long> {
	@Query(value = "SELECT date_format(usertime,'%d %b %Y, %r') FROM medc_adminsecurity.medc_userloginhistory where userid=?1 ORDER BY usertime DESC LIMIT 1 , 1 ", nativeQuery = true)
	String lastVisit(int userid);

	@Query(value = "SELECT new map(m.country as country, m.regionName as region, m.city as city, m.timezone as timezone, m.isp as isp, m.query as ip, date_format(usertime,'%d %b %Y, %r') as date,m.osversion as osversion, m.ostype as ostype, m.browsertype as browsertype) FROM UserLoginHistory m  where m.userid=?1 order by usertime desc")
	List loginHistory(int userid, Pageable page);

}
