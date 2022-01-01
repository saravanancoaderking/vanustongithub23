package com.medeil.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/**
 * @author Boopalan Alagesan
 *
 */
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medeil.repository.DashBoardRepository;

@Service
public class DashBoardService {
	Integer[] s = { 0 };
	List list = null;
	List list1 = null;
	private static org.apache.logging.log4j.Logger logger = LogManager.getLogger();
	@Autowired
	private DashBoardRepository dashBoardRepository;

	@PersistenceContext
	private EntityManager em;

	Query query;

	public List getsalesordertype(Integer compid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception {
		return dashBoardRepository.getsalesordertype(compid, branchid, locname, locrefid);
	}

	public List getsaleschart(Integer compid, Integer branchid, Integer locname, Integer locrefid, String clientcdate1)
			throws Exception {

		boolean b = dashBoardRepository.getsaleschart(compid, branchid, locname, locrefid, clientcdate1).contains(null);
		if (b) {
			return list = Arrays.asList(s);

		}

		else {
			return dashBoardRepository.getsaleschart(compid, branchid, locname, locrefid, clientcdate1);
		}

	}

	public List getpurchasechart(Integer compid, Integer branchid, Integer locname, Integer locrefid,
			String clientcdate1) throws Exception {
		boolean b = dashBoardRepository.getpurchasechart(compid, branchid, locname, locrefid, clientcdate1)
				.contains(null);
		if (b) {
			return list1 = Arrays.asList(s);

		}

		else {
			return dashBoardRepository.getpurchasechart(compid, branchid, locname, locrefid, clientcdate1);
		}
	}

	public List getPurchaseValue(int compid, int branchid, int locname, int locrefid) throws Exception {
		Integer count = 0;
		List novalue = Arrays.asList(count);
		boolean sales = dashBoardRepository.getPurchaseValue(compid, branchid, locname, locrefid).isEmpty();
		if (sales) { // Boopalan 200419
			return novalue;
		}
		return dashBoardRepository.getPurchaseValue(compid, branchid, locname, locrefid);
	}

	public List getweeklyPurchase(Integer cid, Integer bid, Integer locrefid, Integer locname, String clientcdate1)
			throws Exception {
		List val = null;
		Integer[] value1 = { 0, 0, 0, 0, 0, 0, 0 };// Boopalan 200419
		List val1 = Arrays.asList(value1);

		// try {
		String value = "CALL medil.pro_weeklypurchase(?, ?, ?, ?, ?)";
		query = em.createNativeQuery(value);
		query.setParameter(1, cid);
		query.setParameter(2, bid);
		query.setParameter(3, locrefid);
		query.setParameter(4, locname);
		query.setParameter(5, clientcdate1);
		val = query.getResultList();
		// } catch (Exception e) {
		// logger.error("Exception in Method : getweeklyPurchase() " + e);
		// }
		if (val.isEmpty()) {// Boopalan 200419
			return val1;
		}
		return val;
	}

	public List getminimunstock(Integer compid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return dashBoardRepository.getminimunstock(compid, branchid, locname, locrefid);
	}

	public List SIDBoard(Integer compid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		return dashBoardRepository.SIDBoard(compid, branchid, locname, locrefid);
	}

	// Dashboard by Puthiran
	public Map getsalesdatas(Integer compid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("DayTotal", dashBoardRepository.ViewoneDaySaleTotal(compid, branchid, locname, locrefid));
		map.put("WeekTotal", dashBoardRepository.ViewoneWeekSaleTotal(compid, branchid, locname, locrefid));
		map.put("MonthTotal", dashBoardRepository.ViewoneMonthSaleTotal(compid, branchid, locname, locrefid));
		map.put("YearTotal", dashBoardRepository.ViewoneYearSaleTotal(compid, branchid, locname, locrefid));
		map.put("GrandTotal", dashBoardRepository.ViewoneGrandSaleTotal(compid, branchid, locname, locrefid));
		return map;
	}

	public List getsalesdatasbyproductwise(Integer compid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception {
		return dashBoardRepository.getsalesdatasbyproductwise(compid, branchid, locname, locrefid);
	}

	public Map getpurchasedatas(Integer compid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("DayTotal", dashBoardRepository.ViewoneDayPurchaseTotal(compid, branchid, locname, locrefid));
		map.put("WeekTotal", dashBoardRepository.ViewoneWeekPurchaseTotal(compid, branchid, locname, locrefid));
		map.put("MonthTotal", dashBoardRepository.ViewoneMonthPurchaseTotal(compid, branchid, locname, locrefid));
		map.put("YearTotal", dashBoardRepository.ViewoneYearPurchaseTotal(compid, branchid, locname, locrefid));
		map.put("GrandTotal", dashBoardRepository.ViewoneGrandPurchaseTotal(compid, branchid, locname, locrefid));
		return map;
	}

	public List getdistributorwisepurchasedatas(Integer compid, Integer branchid, Integer locname, Integer locrefid)
			throws Exception {
		return dashBoardRepository.getdistributorwisepurchasedatas(compid, branchid, locname, locrefid);
	}

	// Puthiran Customer Counts
	public Map getcustcounts(Integer compid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("DayTotal", dashBoardRepository.ViewoneDayCustTotal(compid, branchid, locname, locrefid));
		System.out.print("Day Stock" + dashBoardRepository.ViewoneDayCustTotal(compid, branchid, locname, locrefid));
		map.put("WeekTotal", dashBoardRepository.ViewoneWeekCustTotal(compid, branchid, locname, locrefid));
		map.put("MonthTotal", dashBoardRepository.ViewoneMonthCustTotal(compid, branchid, locname, locrefid));
		map.put("YearTotal", dashBoardRepository.ViewoneYearCustTotal(compid, branchid, locname, locrefid));
		System.out.print("Year Stock" + dashBoardRepository.ViewoneYearCustTotal(compid, branchid, locname, locrefid));
		map.put("GrandTotal", dashBoardRepository.ViewoneGrandCustTotal(compid, branchid, locname, locrefid));
		return map;
	}

	public Map getproductcount(Integer compid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("DayTotal", dashBoardRepository.ViewoneDayProductTotal(compid, branchid, locname, locrefid));
		System.out.print("Day Stock" + dashBoardRepository.ViewoneDayProductTotal(compid, branchid, locname, locrefid));
		map.put("WeekTotal", dashBoardRepository.ViewoneWeekProductTotal(compid, branchid, locname, locrefid));
		map.put("MonthTotal", dashBoardRepository.ViewoneMonthProductTotal(compid, branchid, locname, locrefid));
		map.put("YearTotal", dashBoardRepository.ViewoneYearProductTotal(compid, branchid, locname, locrefid));
		System.out
				.print("Year Stock" + dashBoardRepository.ViewoneYearProductTotal(compid, branchid, locname, locrefid));
		map.put("GrandTotal", dashBoardRepository.ViewoneGrandProductTotal(compid, branchid, locname, locrefid));
		return map;
	}

	public Map getstockcount(Integer compid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("DayTotal", dashBoardRepository.ViewoneDayStockTotal(compid, branchid, locname, locrefid));
		System.out.print("Day Stock" + dashBoardRepository.ViewoneDayStockTotal(compid, branchid, locname, locrefid));
		map.put("WeekTotal", dashBoardRepository.ViewoneWeekStockTotal(compid, branchid, locname, locrefid));
		map.put("MonthTotal", dashBoardRepository.ViewoneMonthStockTotal(compid, branchid, locname, locrefid));
		map.put("YearTotal", dashBoardRepository.ViewoneYearStockTotal(compid, branchid, locname, locrefid));
		System.out.print("Year Stock" + dashBoardRepository.ViewoneYearStockTotal(compid, branchid, locname, locrefid));
		map.put("GrandTotal", dashBoardRepository.ViewoneGrandStockTotal(compid, branchid, locname, locrefid));
		return map;
	}

	public Map getoutofstock(Integer compid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("DayTotal", dashBoardRepository.ViewoneDayOutofStockTotal(compid, branchid, locname, locrefid));
		System.out.print(
				"Day Stock" + dashBoardRepository.ViewoneDayOutofStockTotal(compid, branchid, locname, locrefid));
		map.put("WeekTotal", dashBoardRepository.ViewoneWeekOutofStockTotal(compid, branchid, locname, locrefid));
		map.put("MonthTotal", dashBoardRepository.ViewoneMonthOutofStockTotal(compid, branchid, locname, locrefid));
		map.put("YearTotal", dashBoardRepository.ViewoneYearOutofStockTotal(compid, branchid, locname, locrefid));
		System.out.print(
				"Year Stock" + dashBoardRepository.ViewoneYearOutofStockTotal(compid, branchid, locname, locrefid));
		map.put("GrandTotal", dashBoardRepository.ViewoneGrandOutofStockTotal(compid, branchid, locname, locrefid));
		return map;
	}

	public int getshortexpiry(Integer compid, Integer branchid, Integer locname, Integer locrefid) {
		System.out.println("Raja");
		return dashBoardRepository.getshortexpprod(compid, branchid, locname, locrefid);
	}

	public int getexpstockcount(Integer compid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		System.out.println("Raja");
		return dashBoardRepository.getexpstockcount(compid, branchid, locname, locrefid);
	}

	// ABC Day
	public Object getdayabc(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		System.out.println("Raja Day abc service");
		return dashBoardRepository.getabcday(comid, branchid, locname, locrefid);
	}
	
	//ABC Over All
	public Map getabcdatas(Integer compid, Integer branchid, Integer locname, Integer locrefid) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("DayTotal", dashBoardRepository.getabcday(compid,branchid,locname,locrefid));
		System.out.print("Day Stock"+dashBoardRepository.getabcday(compid,branchid,locname,locrefid));
		map.put("WeekTotal", dashBoardRepository.getabcweek(compid,branchid,locname,locrefid));
		map.put("MonthTotal", dashBoardRepository.getabcmonth(compid,branchid,locname,locrefid));
		map.put("YearTotal", dashBoardRepository.getabcyear(compid,branchid,locname,locrefid));
		return map;
	}

	// ABC Week
	public Object getweekabc(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		System.out.println("Raja Week abc service");
		return dashBoardRepository.getabcweek(comid, branchid, locname, locrefid);

	}

	// ABC Month

	public Object getmonthabc(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		System.out.println("Raja Day Month service");
		return dashBoardRepository.getabcmonth(comid, branchid, locname, locrefid);

	}

	// ABC Year d

	public Object getyearabc(Integer comid, Integer branchid, Integer locname, Integer locrefid) throws Exception {
		System.out.println("Raja Day Year service");
		return dashBoardRepository.getabcyear(comid, branchid, locname, locrefid);

	}

		
}
