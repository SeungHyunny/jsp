<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 에러가 나면 넘어가는 페이지 지정 -->
<%@ page errorPage="errorPage.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러를 발생시키는 페이지</title>
</head>
<body>
<%
	int i = 40/0;
%>
</body>
</html>