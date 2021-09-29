<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if (id.equals("admin") && pw.equals("1234")){
		Cookie cookie = new Cookie("id",id);
		cookie.setMaxAge(20); //3일을 설정한 예 : 60*60*24*3
	//클라이언트에 저장
	response.addCookie(cookie);
	response.sendRedirect("welcome.jsp");
	}else{
		response.sendRedirect("login.jsp");	
	}
%>