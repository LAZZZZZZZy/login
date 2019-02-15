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

/**
 * Servlet implementation class RegisterAccount
 */
@WebServlet("/RegisterAccount")
public class RegisterAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterAccount() {
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
		System.out.println("register");
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
	     String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
	     Connection conn = null;
	     Statement stmt = null;
	     int rs = 0;

	     try {                                                    //数据可的登录名  登录密码
	         conn = (Connection) DriverManager.getConnection(url, "root", "134679285");
	         stmt = (Statement) conn.createStatement();
	         // SQL语句
	         String sql = "INSERT INTO user (name,password) VALUES ( '" +username+"' , '"+pwd +"');";
	         System.out.println(sql);
	         rs = stmt.executeUpdate(sql);// 返回查询结果
	         System.out.println(rs);
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     HttpSession session = request.getSession();
	     session.setAttribute("username", username);
	     if (rs!=0) {
		     // 如果记录集非空，表明有匹配的用户名和密码，登陆成功
			 System.out.println("successReg");
		     response.sendRedirect("login.jsp");
		     
		 } else {
		     session.setAttribute("message", "用户名或密码不匹配。");
		     System.out.println("XXXXXXXXXX");
		 }
	}

}
