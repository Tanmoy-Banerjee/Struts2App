package com.Auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.dbUtils.CP;

/**
 * Servlet implementation class Login1
 */
@WebServlet("/login")
public class Login1 extends HttpServlet implements SessionAware {
	private static final long serialVersionUID = 1L;
	 
		String username; String password;
		SessionMap<String,String> sessionmap;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("The code reaches here");
		String status = "";
	//	 HttpServletRequest request = ServletActionContext.getRequest();
		 String username = request.getParameter("username");
		 String password = request.getParameter("password");
	    
		 if(validate(username,password)==true)
		 {
		 status= "success";
		 }
		 else {
			 
	     status = "failed";
		 }
	}
	
	@Override
	public void setSession(Map map) {  
	    sessionmap=(SessionMap)map;  
	    sessionmap.put("login","true");  
	}  
	
	public static boolean validate(String username,String password) {
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
