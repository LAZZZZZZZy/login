package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountBean
 */
@WebServlet("/AccountBean")

public class AccountBean {
 private String username = "";
 private String password = "";
 public String getPassword() {
  return password;
 }
 public void setPassword(String password) {
  this.password = password;
 }
 public String getUsername() {
  return username;
 }
 public void setUsername(String username) {
  this.username = username;
 }
}
