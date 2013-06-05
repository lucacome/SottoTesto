<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ST_dbpResult</title>
</head>
<body>
<form action="home" id="homeform" method=get>
<input type="submit" value="Reset">
</form>
<br>
<b>Status:</b><br>
TAGME query ... OK<br>
DBPedia query ... OK<br>

<br><br>
<h2>DBPedia Response:</h2><br>
<%=(String)request.getAttribute("dbpOutput")%> <br>
</body>
</html>