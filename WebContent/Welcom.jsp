<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page language="java" import="com.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
    AccountBean account = (AccountBean)session.getAttribute("account");
%>
<h2>
Welcome to "<%= account.getUsername()%>" Login System!
</h2>
This is the first javaWeb Project!
</body>
</html>