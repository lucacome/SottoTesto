package com.sottotesto;

import java.io.FileWriter;
import java.io.IOException;

public class Debug {
	  public static final boolean ON = true;		  
	  
	  private static String filename = "/var/lib/tomcat7/webapps/debug.out";
	 
	//print log line
	  public static void initializeDbgFile(){
		  //System.out.println(line);
		  try
		  {		      
		      FileWriter fw = new FileWriter(filename,false);
		      fw.write("");//appends the string to the file
		      fw.close();
		  }
		  catch(IOException ioe)
		  {
		      System.err.println("IOException: " + ioe.getMessage());
		  }
	  }
	  //print log line
	  public static void writeDbgLine(String line){
		  //System.out.println(line);
		  try
		  {		      
		      FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		      fw.write(line+"\n");//appends the string to the file
		      fw.close();
		  }
		  catch(IOException ioe)
		  {
		      System.err.println("IOException: " + ioe.getMessage());
		  }
	  }

}
