<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//세션의 이름들을 Enumeration에 담은 객체로 리턴
	Enumeration enumeration = session.getAttributeNames();
	while(enumeration.hasMoreElements()){
		String sessionName = enumeration.nextElement().toString();
		String sessionValue = (String)session.getAttribute(sessionName);
		if(sessionValue.equals("admin")){
			out.println(sessionValue+"님 하이루~<br/>");
		}
	}
		
%>
<a href="logout.jsp">로그아웃</a>
</body>
</html>