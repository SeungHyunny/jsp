<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>세션정보</h1>
<%
	//세션정보는 object객체로 리턴되므로 필요한 타입으로 Casting하여야 한다.
	int num = (Integer)session.getAttribute("num"); //obj타입으로 옴->숫자로 캐스팅
	String name = (String)session.getAttribute("guestname");
	int sessionInterval = session.getMaxInactiveInterval();//기본1800 : 타임아웃세팅
	out.println(num+":"+"name"+"("+sessionInterval+")<br/>");
	//out.println(num+"<br/>");
	//out.println(name+"<br/>");
%>
<a href="sessiondel.jsp">세션지우기</a>
</body>
</html>