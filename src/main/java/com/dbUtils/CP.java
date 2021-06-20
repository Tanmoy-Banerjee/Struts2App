package com.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
public class CP {

	static Connection con;
	
	public static Connection createC() {
		//load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user= "root";
			String password = "ABCD";
			String url = "jdbc:mysql://localhost:3306/users";
			
			con = DriverManager.getConnection(url,user,password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
}