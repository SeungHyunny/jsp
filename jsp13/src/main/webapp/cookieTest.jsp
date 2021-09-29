<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie x : cookies){
			out.println(x.getName()+"<br/>");
			out.println(x.getValue()+"<br/>");
			out.println("<hr>");
		}
	}	
%>

</body>
</html>