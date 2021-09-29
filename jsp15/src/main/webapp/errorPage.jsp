<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 에러 처리 페이지임을 선언 -->
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>안녕하세요? error page</h1><hr>
	<%= exception.getMessage() %>
</body>
</html>