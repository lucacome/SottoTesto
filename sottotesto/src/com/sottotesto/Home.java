package com.sottotesto;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
public class Home extends HttpServlet implements Servlet {  
  
private static final long serialVersionUID = 1L;  
  
public Home() {  
super();  
}  
  
@Override  
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
  
	request.setAttribute("hello_string", "text");  
request.getRequestDispatcher("/home.jsp").forward(request, response);  

  
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
 String text2 = request.getParameter("inputtext");
// response.sendRedirect("/index.html");
 
// request.getRequestDispatcher("/home.jsp").forward(request, response);
 request.getRequestDispatcher("/tagme").forward(request, response);
 //response.sendRedirect("/sottotesto/tagme");
 
}
}  
