<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키세팅하기</h1>
	<%
	//쿠키는 간단한 것 위주로 만들어야함
		Cookie cookie1 = new Cookie("cookieName","cookieValue");
		Cookie cookie2 = new Cookie("id","admin");
		Cookie cookie3 = new Cookie("pw","1234");
		cookie1.setMaxAge(60*60); //1시간용
		cookie2.setMaxAge(30*60); //30분용
		cookie3.setMaxAge(30*60); //30분용
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
	%>
	<a href="cookieget.jsp">cookie얻기</a>
</body>
</html>