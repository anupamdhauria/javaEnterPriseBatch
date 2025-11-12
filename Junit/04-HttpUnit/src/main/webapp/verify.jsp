<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String username=request.getParameter("uname");
String password=request.getParameter("password");

//No inputs
if (username.equals("") || password.equals("") || username.length() == 0 || password.length() == 0) {
	out.println("provide credentials");
	return;
}

//Provide logic for authentication
if (username.equalsIgnoreCase("sachin") && password.equals("tendulkar"))
	out.println("valid credentials");
else
	out.println("invalid credentials");

%>