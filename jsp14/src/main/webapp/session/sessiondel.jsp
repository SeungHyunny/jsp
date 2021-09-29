<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>세션삭제후</h1>
	<%
		session.removeAttribute("num");
		Enumeration enumeration = session.getAttributeNames();
		String key;
		Object value;
		
		while(enumeration.hasMoreElements()){
			key = enumeration.nextElement().toString();
			value = session.getAttribute(key);
			out.println("sessionName:"+key+"<br/>");
			out.println("sessionValue:"+value+"<br/>");
		}
		session.setAttribute("num2", 1234567);
		
	%>
	<a href="sessionAllDel.jsp">모든 세션 지우기</a>
</body>
</html>