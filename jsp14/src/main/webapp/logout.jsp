<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션정보out</title>
</head>
<body>
<h1>세션정보out</h1>
<%
	Enumeration enumeration = session.getAttributeNames();
	while(enumeration.hasMoreElements()){
		String name = enumeration.nextElement().toString();
		String value = (String)session.getAttribute(name);
		if(value.equals("admin")){
			session.removeAttribute(name);
		}
	}
%>
<a href="sessiontest.jsp">sessionInfo</a>
</body>
</html>