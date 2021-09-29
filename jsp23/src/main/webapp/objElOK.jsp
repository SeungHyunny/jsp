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
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	%>
	아이디 : <%=id %><br>
	비밀번호 :${param.pwd}
	비밀번호 :
	<%
		application.setAttribute("name","홍길동");
		session.setAttribute("name","홍길동");
		request.setAttribute("name","홍길동");
		pageContext.setAttribute("name","홍길동");;
	%>
</body>
</html>