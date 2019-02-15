package com.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@WebServlet("/CheckAccount")
public class CheckAccount extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 System.out.println("account");
	 response.setContentType("text/html;charset=utf-8");
     request.setCharacterEncoding("utf-8");
     String username = request.getParameter("username");
     String pwd = request.getParameter("pwd");
     try {
         Class.forName("com.mysql.jdbc.Driver");
     } catch (ClassNotFoundException e) {
         e.printStackTrace();
         System.out.println("找不到驱动 ");
     }
     // 连接URL                    服务器地址                       端口号    数据库名
     String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null;

     try {                                                    //数据可的登录名  登录密码
         conn = (Connection) DriverManager.getConnection(url, "root", "123456");
         stmt = (Statement) conn.createStatement();
         // SQL语句
         String sql = "select * from user where name='" + username + "' and password= '" + pwd + "'";
         rs = stmt.executeQuery(sql);// 返回查询结果
     } catch (SQLException e) {
         e.printStackTrace();
     }
     HttpSession session = request.getSession();
     session.setAttribute("username", username);
     try {
         if (rs.next()) {
             // 如果记录集非空，表明有匹配的用户名和密码，登陆成功
        	 AccountBean account = new AccountBean();
        	 account.setPassword(pwd);
        	 account.setUsername(username);
        	 session.setAttribute("account", account);
        	 System.out.println("success");
             response.sendRedirect("success.jsp");
             
         } else {
             session.setAttribute("message", "用户名或密码不匹配。");
             System.out.println("XXXXXXXXXX");
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 @Override
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  HttpSession session = request.getSession();
  AccountBean account = new AccountBean();
  String username = request.getParameter("username");
  String pwd = request.getParameter("pwd");
  account.setPassword(pwd);
  account.setUsername(username);
  if((username != null)&&(username.trim().equals("jsp"))) {
   if((pwd != null)&&(pwd.trim().equals("1"))) {
    System.out.println("success");
    session.setAttribute("account", account);
    String login_suc = "success.jsp";
    response.sendRedirect(login_suc);
    return;
   }
  }
  String login_fail = "fail.jsp";
  response.sendRedirect(login_fail);
  return;
 }
 
}