package com.sottotesto;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Tagme extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 2L;

public Tagme() {
	super();
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	//config TAGME request parameters
	URL url = new URL ("http://tagme.di.unipi.it/tag");
	String charset = "UTF-8";
	String param1name = "text";
	String param1value = request.getParameter("inputtext");
	String param2name = "key";
	String param2value = "plclcd321";
	String param3name = "include_categories";
	String param3value = "true";	
	String query = String.format("%s=%s&%s=%s&%s=%s", URLEncoder.encode(param1name, charset), URLEncoder.encode(param1value, charset), URLEncoder.encode(param2name, charset), URLEncoder.encode(param2value, charset), URLEncoder.encode(param3name, charset), URLEncoder.encode(param3value, charset));
	
	//open TAGME connection
	HttpURLConnection connessione = (HttpURLConnection) url.openConnection();
	connessione.setRequestMethod("POST");
	connessione.setDoOutput(true);

	//get TAGME response
	OutputStream output = null;
	try {
		output = connessione.getOutputStream();
		output.write(query.getBytes(charset));
		} 
	finally {
		if (output != null) try { output.close(); } catch (IOException err){}			
		}
	
	//read TAGME response
	int rspCode = connessione.getResponseCode();
	String messaggio = connessione.getResponseMessage(); 
	String contenttype = connessione.getContentType();	
	String responsetag = "";
	if (contenttype.contains("application/json")){		
		Scanner input = new Scanner(connessione.getInputStream());		
		while (input.hasNextLine())
			responsetag += (input.nextLine());
		input.close();		
	}else{
		responsetag = "nessuna stringa";
	}

	//config & view JSP
	String json = responsetag.replaceAll(",", ",<br>");
	request.setAttribute("rspCode", String.valueOf(rspCode));
	request.setAttribute("msg", messaggio);
	request.setAttribute("cntType", contenttype);
	request.setAttribute("json", json);  
	request.setAttribute("responsetag", responsetag);	
	request.getRequestDispatcher("/tagme.jsp").forward(request, response);
}


}
