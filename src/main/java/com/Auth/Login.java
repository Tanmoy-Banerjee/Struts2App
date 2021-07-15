package com.Auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.dbUtils.CP;

public class Login  implements SessionAware {
    
	String username; String password;
	SessionMap<String,String> sessionmap;  
	public String execute()
	{
		 System.out.println("The code reaches here testing");
		 HttpServletRequest request = ServletActionContext.getRequest();
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
	     Login ob = new Login();
		 if(ob.validate(username,password)==true)
		 {
		 return "success";
		 }
		 else {
			 
			 return "failed";
		 }
	}

	@Override
	public void setSession(Map map) {  
	    sessionmap=(SessionMap)map;  
	    sessionmap.put("login","true");  
	}  
	
	public  boolean validate(String username,String password) {
	boolean flag = false;
	try {
		
		Connection con =  CP.createC();
	    String query =  "select * from userlist where username=? and password=?";
	    PreparedStatement pstmt = con.prepareStatement(query);
	    pstmt.setString(1, username);
	    pstmt.setString(2, password);
	    
	    ResultSet rs=pstmt.executeQuery();
	    flag=rs.next();  
	    
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return flag;
	}
	
	public String logout(){  
	    sessionmap.invalidate();  
	    return "success";  
	} 
	
}
