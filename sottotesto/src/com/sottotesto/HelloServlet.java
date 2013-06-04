package com.sottotesto;

import java.io.IOException;  

import javax.servlet.Servlet;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class HelloServlet extends HttpServlet implements Servlet {  
  
private static final long serialVersionUID = 1L;  
  
public HelloServlet() {  
super();  
}  
  
@Override  
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
request.setAttribute("hello_string", "Hello WebApp!");  
  
request.getRequestDispatcher("/hello.jsp").forward(request, response);  
  
}  
}  
