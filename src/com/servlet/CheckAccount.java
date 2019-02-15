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
         System.out.println("�Ҳ������� ");
     }
     // ����URL                    ��������ַ                       �˿ں�    ���ݿ���
     String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null;

     try {                                                    //���ݿɵĵ�¼��  ��¼����
         conn = (Connection) DriverManager.getConnection(url, "root", "123456");
         stmt = (Statement) conn.createStatement();
         // SQL���
         String sql = "select * from user where name='" + username + "' and password= '" + pwd + "'";
         rs = stmt.executeQuery(sql);// ���ز�ѯ���
     } catch (SQLException e) {
         e.printStackTrace();
     }
     HttpSession session = request.getSession();
     session.setAttribute("username", username);
     try {
         if (rs.next()) {
             // �����¼���ǿգ�������ƥ����û��������룬��½�ɹ�
        	 AccountBean account = new AccountBean();
        	 account.setPassword(pwd);
        	 account.setUsername(username);
        	 session.setAttribute("account", account);
        	 System.out.println("success");
             response.sendRedirect("success.jsp");
             
         } else {
             session.setAttribute("message", "�û��������벻ƥ�䡣");
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