package com.Auth;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.User.User;
import com.dbUtils.CP;

public class SignUp {

	
	public String execute() {
	System.out.println("The control reaches here");
    HttpServletRequest request = ServletActionContext.getRequest();
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    System.out.println(name);
    
    User ob = new User(name,email,username,password);
    boolean test = insertUserToDB(ob);
    if(test == true)
    return "success";
    else {
    	return "success";
    	}
	}
	
	
	public static boolean insertUserToDB(User user) {
		
		boolean flag = false;
		 
		try {
			Connection con =  CP.createC();
			String q = "insert into userlist(name,email,username,password) values(?,?,?,?)";
			
			
			PreparedStatement pstmt = con.prepareStatement(q);
			//set the value of parameters
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getEmail());
			pstmt.setString(3, user.getUsername());
			pstmt.setString(4, user.getPassword());
			
			
			pstmt.executeUpdate();
			flag = true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
}
