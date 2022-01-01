package com.medeil.util;

public class AutoIncrement {

	public static String getIncrement00(String r) {

		Long auto = (long) 0;

		try {
			auto = Long.parseLong(r) + 1;
		} catch (Exception e) {
			auto = (long) 0.0;
		}

		String s = "" + auto;

		StringBuilder sb = new StringBuilder(s);

		if (auto < 10) {
			sb.insert(0, "/00000000");
		} else if (auto < 100) {
			sb.insert(0, "/0000000");

		} else if (auto < 1000) {

			sb.insert(0, "/000000");
		} else if (auto < 10000) {

			sb.insert(0, "/00000");
		} else if (auto < 100000) {

			sb.insert(0, "/0000");
		} else if (auto < 1000000) {

			sb.insert(0, "/000");
		} else if (auto < 10000000) {

			sb.insert(0, "/00");
		} else if (auto < 100000000) {

			sb.insert(0, "/0");
		}

		return sb.toString();

	}

	public static String getIncrement02(String r) {

		Long auto = (long) 0;

		try {
			auto = Long.parseLong(r) + 1;
		} catch (Exception e) {
			auto = (long) 1 ;
		}

		String s = "" + auto;

		StringBuilder sb = new StringBuilder(s);

		if (auto < 10) {
			sb.insert(0, "/000000000");
		} else if (auto < 100) {
			sb.insert(0, "/00000000");

		} else if (auto < 1000) {

			sb.insert(0, "/0000000");
		} else if (auto < 10000) {

			sb.insert(0, "/000000");
		} else if (auto < 100000) {

			sb.insert(0, "/00000");
		} else if (auto < 1000000) {

			sb.insert(0, "/0000");
		} else if (auto < 10000000) {

			sb.insert(0, "/000");
		} else if (auto < 100000000) {

			sb.insert(0, "/00");
		}

		return sb.toString();

	}
	
	
	
	public static String getIncrement03(String start,String locname,String locrefid  ,String num) {

		Long auto = (long) 0;

		try {
			auto = Long.parseLong(num) + 1;
		} catch (Exception e) {
			auto = (long) 1 ;
		}

		String s = "" + auto;

		StringBuilder sb = new StringBuilder();
		sb.append(start);
		getLocName(sb,Integer.parseInt(locname.split("\\.")[0]),Integer.parseInt(locrefid.split("\\.")[0]));
		if (auto < 10) {
			sb.append("/000000000");
		} else if (auto < 100) {
			sb.append( "/00000000");

		} else if (auto < 1000) {

			sb.append( "/0000000");
		} else if (auto < 10000) {

			sb.append( "/000000");
		} else if (auto < 100000) {

			sb.append("/00000");
		} else if (auto < 1000000) {

			sb.append( "/0000");
		} else if (auto < 10000000) {

			sb.append("/000");
		} else if (auto < 100000000) {

			sb.append("/00");
		}
		sb.append(s);
		return sb.toString();

	}

	
	
	public static  void getLocName(StringBuilder  sb,Integer locname,Integer locrefid ){

		
		if(locname==1){
			sb.append("SH_"+locrefid);
			
		}else if(locname==2){
			sb.append("WH_"+locrefid);
			
		}else if(locname==3){
			
			sb.append("HO_"+locrefid);
		}
	
		
	}
	
	//selva - Expiry
	public static String  getIncrement01(String  r){
		 
		 
		 Long	auto = Long.parseLong(r)+1  ;
		 
	    String s=""+auto ;
	 
	    StringBuilder sb = new StringBuilder(s);
	 
	 
		 if(auto<10){
			 sb.insert(0, "/00000000");	
		 }else if(auto<100) {
			 sb.insert(0, "/0000000");	 
			 	 
		 }else if(auto<1000) {
			 
			 sb.insert(0, "/000000");		 
		 }else if(auto<10000) {
			 
			 sb.insert(0, "/00000");	 	 
		 }else if(auto<100000) {
			 
			 sb.insert(0, "/0000");	  
		 }else if(auto<1000000) {
			 
			 sb.insert(0, "/000");	  
		 }else if(auto<10000000) {
			 
			 sb.insert(0, "/00");	
		 }else if(auto<100000000) {
			 
			 sb.insert(0, "/0");	
		 }
		 
			 		 
			 
		return  sb.toString();
		 	 
	 }
	
	
	
	

}
