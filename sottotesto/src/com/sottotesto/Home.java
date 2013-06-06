package com.sottotesto;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
  
public class Home extends HttpServlet implements Servlet {  
  
private static final long serialVersionUID = 1L;  
Logger logger = LogManager.getLogger(Home.class.getName());  

public Home() {  
super();  
}  
  
@Override  
protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {  
	Debug.initializeDbgFile();
	Debug.writeDbgLine("Home.java: doGet()");
	
	logger.trace("looog 4jjjjj");
	
request.getRequestDispatcher("/home.jsp").forward(request, response); 
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {      
	Debug.writeDbgLine("Home.java: doPost()");
 request.getRequestDispatcher("/tagme").forward(request, response);
}
}  
