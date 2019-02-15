<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page language="java" import="com.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
    <%
    AccountBean account = (AccountBean)session.getAttribute("account");
    %>
    username:<%= account.getUsername()%>
     <br>
     password:<%= account.getPassword() %>
  </body>
</html>