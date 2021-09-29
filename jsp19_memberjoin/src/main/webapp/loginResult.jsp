<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginResult</title>
</head>
<body>

	<h1>login완료</h1><hr>
	<%
		String name = (String)session.getAttribute("name");
		String phone = (String)session.getAttribute("phone");
	%>
	<h2><%=name %>님 안녕하세요 환영합니다.</h2>
	<h3>당신의 전화번호는 <%=phone %>입니다.</h3>
	<a href="modify.jsp">회원정보수정</a>
</body>
</html>