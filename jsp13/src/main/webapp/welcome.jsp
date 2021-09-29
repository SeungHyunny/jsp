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
		String id = x.getValue();
		if(id.equals("admin")){
			out.println(id+"님 당신은 정식 사용자로 승인합니다.<br/>");
		}
	}
%>
<a href= "logout.jsp">로그아웃</a>
</body>
</html>