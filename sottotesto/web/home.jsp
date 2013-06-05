<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
pageEncoding="ISO-8859-1"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>SottoTesto Web App</title>  
</head>  
<body>  
<h3>Scrivere una frase</h3>
<textarea rows="4" cols="50" name="inputtext" form="textform"
			onfocus="if(this.value == 'Enter text here...') this.value='';"
			onblur="if(this.value == 'Enter text here...') this.value='';">
Enter text here...</textarea>
<form action="home" id="textform" method="post">
<input type="submit" value="Submit">
</form>


  
</body>  
</html>  