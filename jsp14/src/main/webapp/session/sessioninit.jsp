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
	session.setAttribute("num", 1234);
	session.setAttribute("guestname","홍길동");
%>
<a href="sessionget.jsp">세션얻기</a>
</body>
</html>