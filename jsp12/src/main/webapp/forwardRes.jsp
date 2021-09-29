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
		//request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; encoding=UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	%>
	<h1>포워딩된 파라미터 값 출력</h1>
	아이디 : <%=id %><br/>
	비밀번호 :<%=pw %>
</body>
</html>