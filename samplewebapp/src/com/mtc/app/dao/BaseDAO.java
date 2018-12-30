package com.mtc.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BaseDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	
	public Connection getConnection() {
		
		Connection connection = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			                                      //connection url, username , password
			connection = DriverManager.getConnection(URL,"root","Mounica12!");			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return connection;
		
	}
	
}
