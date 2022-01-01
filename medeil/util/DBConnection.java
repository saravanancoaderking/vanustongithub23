package com.medeil.util;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	
	
	  public static final String DATABASE_USER = "user";

	  public static final String DATABASE_PASSWORD = "password";

	  public static final String MYSQL_AUTO_RECONNECT = "autoReconnect";

	  public static final String MYSQL_MAX_RECONNECTS = "maxReconnects";

	  public static Connection getConnection() throws Exception {
	    String driver = "com.mysql.jdbc.Driver";
	    // load the driver
	    Class.forName(driver);
	    String dbURL = "jdbc:mysql://localhost:3366/medeil_plus";
	    String dbUsername = "root";
	    String dbPassword = "MEdeiLDemO@2010";

	    java.util.Properties connProperties = new java.util.Properties();
	    connProperties.put(DATABASE_USER, dbUsername);
	    connProperties.put(DATABASE_PASSWORD, dbPassword);

	    // set additional connection properties:
	    // if connection stales, then make automatically
	    // reconnect; make it alive again;
	    // if connection stales, then try for reconnection;
	    connProperties.put(MYSQL_AUTO_RECONNECT, "true");
	   
	    Connection conn = DriverManager.getConnection(dbURL, connProperties);
	    return conn;
	  }

	
	
	
	
	
	
	
	
	
	

}
