<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- errorPage는 하나만 지정. but, 어떤 오류가 발생될지 모르니 web.xml로 예외처리하는게 편함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int i = 40/0;
	%>
</body>
</html>