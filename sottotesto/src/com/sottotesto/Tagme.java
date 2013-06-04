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

import com.google.gson.Gson;
import com.sottotesto.TagmeDataWrapper.TagmeData;


public class Tagme extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 2L;

public Tagme() {
	super();
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
//	request.setAttribute("hello_string", request.getParameter("inputtext"));  
	//request.getRequestDispatcher("/home.jsp").forward(request, response);
	URL url = new URL ("http://tagme.di.unipi.it/tag");
	String charset = "UTF-8";
	String param1name = "text";
	String param1value = request.getParameter("inputtext");
	String param2name = "key";
	String param2value = "plclcd321";
	String param3name = "include_categories";
	String param3value = "true";
	
	String query = String.format("%s=%s&%s=%s&%s=%s", URLEncoder.encode(param1name, charset), URLEncoder.encode(param1value, charset), URLEncoder.encode(param2name, charset), URLEncoder.encode(param2value, charset), URLEncoder.encode(param3name, charset), URLEncoder.encode(param3value, charset));
	
	HttpURLConnection connessione = (HttpURLConnection) url.openConnection();
	connessione.setRequestMethod("POST");
	connessione.setDoOutput(true);

	OutputStream output = null;
	try {
		output = connessione.getOutputStream();
		output.write(query.getBytes(charset));
	} finally {
		if (output != null) try { output.close(); } catch (IOException err){}
			
		}
	
	
	int rspCode = connessione.getResponseCode();
	String messaggio = connessione.getResponseMessage(); 
	String contenttype = connessione.getContentType();
	
	String responsetag = "";
	String json = "";
	TagmeData data = null;

	
	if (contenttype.contains("application/json")){
		Gson gson = new Gson();
		Scanner input = new Scanner(connessione.getInputStream());
		
		while (input.hasNextLine())
			responsetag += (input.nextLine());
		
//		json = gson.toJson(responsetag);
		data = gson.fromJson(responsetag, TagmeData.class);
		
		
	}else{
		json = "nessuna stringa";
	}


	//String.valueOf(rspCode)+messaggio+contenttype+
	
	request.setAttribute("hello_string", data.timestamp);  
	request.getRequestDispatcher("/home.jsp").forward(request, response);	
  
}


}
