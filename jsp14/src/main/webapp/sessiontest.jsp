<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션정보확인</title>
</head>
<body>
<h1>세션정보확인</h1>
<%
	Enumeration enumeration = session.getAttributeNames();
	int i=0;
	while(enumeration.hasMoreElements()){
		i++;
		String name = enumeration.nextElement().toString();
		String value = (String)session.getAttribute(name);
		out.println("name : "+name+"<br/>");
		out.println("value : "+value+"<br/>");
	}
	if(i==0){
		out.println("해당세션이 없습니다.");
	}
%>
</body>
</html>