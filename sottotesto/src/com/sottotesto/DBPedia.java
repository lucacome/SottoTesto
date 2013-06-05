package com.sottotesto;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.sottotesto.TagmeDataWrapper.TagmeData;

public class DBPedia extends HttpServlet implements Servlet{
	private static final long serialVersionUID = 2L;
	
	public DBPedia() {
	super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TagmeData data = null;
		Gson gson = new Gson();
		String responsetag = request.getParameter("responsetag");
		data = gson.fromJson(responsetag, TagmeData.class);
		
		ResultSet results = null;
		String resultquery = "";
		for (int i=0; i<=data.annotations.size()-1; i++){
			String titletag = data.annotations.get(i).title;	
		
		
		titletag = titletag.replaceAll(" ", "_");
		
	    String s2 = "PREFIX  dbpprop: <http://dbpedia.org/property/>\n" +
	    		"\n" +
	    		"SELECT  *\n" +
	            "WHERE {\n" +
	            "<http://dbpedia.org/resource/" + titletag + "> dbpprop:placeOfBirth ?nat .\n" +
	            "  }\n" +
	            "";

	    Query query2 = QueryFactory.create(s2); //s2 = the query above
	    QueryExecution qExe = QueryExecutionFactory.sparqlService( "http://dbpedia.org/sparql", query2 );
	    results = qExe.execSelect(); 
	    resultquery += ResultSetFormatter.asText(results);
//	    ResultSetFormatter.outputAsJSON(results);
	        
//	    resultquery += results;
		}
//	    String temp = String.valueOf(data.annotations.size());
		
		request.setAttribute("dbpOutput", resultquery);  
//		request.setAttribute("hello_string", titletag);  

		request.getRequestDispatcher("/dbpedia.jsp").forward(request, response);	
		
	}
}
