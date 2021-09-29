<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sub1 page</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String age = request.getParameter("age");
	%>
	<h1>여기는 sub1 page입니다.</h1>
	포함된 문서에서 출력된 정보<br/>
	이름 : <%=name %><br/>
	나이 : <%=age %><br/>
	<hr>
</body>
</html>