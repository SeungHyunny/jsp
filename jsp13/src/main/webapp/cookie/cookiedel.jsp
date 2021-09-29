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
		Cookie[] cookies = request.getCookies();
		for(Cookie x:cookies){
			if (x.getName().equals("id") || x.getName().equals("pw")){
				x.setMaxAge(0);
				response.addCookie(x);
			}
		}
	%>
	<a href="cookieInfo.jsp">현재쿠키정보</a>
</body>
</html>