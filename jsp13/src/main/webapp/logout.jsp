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
	if(cookies != null){
	 	for(Cookie x : cookies){
		 	if(x.getValue().equals("admin")){
				x.setMaxAge(0);
			}
	 	}
 	}
	response.sendRedirect("cookieTest.jsp");
 %>
</body>
</html>