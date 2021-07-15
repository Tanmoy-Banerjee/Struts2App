<%@ page import ="java.sql.* , java.io.*, com.Auth.Login , com.dbUtils.CP" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
//response.getWriter().write("Hello"); 




String username =(String) request.getParameter("username");
String password =(String) request.getParameter("password");

System.out.println(username);
System.out.println(password);

  Login ob = new Login();
if(ob.validate(username,password)==true)
{
//System.out.println("Code reaches here");
response.getWriter().write("success");
}
else {
	System.out.println("Code also reaches here");
	response.getWriter().write("failed");
}

%>