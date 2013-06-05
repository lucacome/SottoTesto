<%@page import="com.sottotesto.Tagme"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ST_tagmeResult</title>
</head>
<body>
<form action="home" id="homeform" method="get">
<input type="submit" value="Reset">
</form>
<br>
<b>Status:</b><br>
TAGME query ... OK<br>
Querying DBPedia ...<br>

<br><br>
<h2>TAGME Response:</h2><br>
<b>Codice:</b> <%=(String)request.getAttribute("rspCode")%> <br>
<b>Messaggio:</b> <%=(String)request.getAttribute("msg")%> <br>
<b>ContentType:</b> <%=(String)request.getAttribute("cntType")%> <br>
<br>
<b>JSON OUTPUT:</b><br>
<%=(String)request.getAttribute("json")%>


<jsp:forward page="/dbpedia">
	 <jsp:param name="responsetag" value='<%=(String)request.getAttribute("responsetag")%>'/>
</jsp:forward> 
</body>
</html>