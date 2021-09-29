<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	이름:${param.name}<br>
	이름:${session.name}<br>
	이름:${page.name}<br>
	이름:${application.name}<br>
	<%
		String 이름 = (String)session.getAttribute("name");
		String 이름2 = (String)application.getAttribute("name");
	%>
	이름:<%=이름 %><br>
	이름2:<%=이름2 %><br>
	
</body>
</html>