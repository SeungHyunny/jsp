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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; encoding=UTF-8");	
	%>
	<jsp:forward page="forwardRes.jsp">
		<jsp:param name="id" value="홍길동"/>
		<jsp:param name="pw" value="1234"/>
	</jsp:forward>
</body>
</html>