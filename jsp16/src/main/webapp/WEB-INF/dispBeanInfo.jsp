<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.vision.beans.Person" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>빈(Bean) 정보 출력</title>
</head>
<body>
	<%
		Person p = (Person)session.getAttribute("person");
		out.println(p);
	%>
		<h3>
		이름 : <%=p.getName() %> <br/>
		이메일 : <%=p.getEmail() %> <br/>
		아이디 : <%=p.getId() %> <br/>
		비밀번호 : <%=p.getPw() %> <br/>
		취미 : <%=Arrays.toString(p.getHobby()) %> <br/>
	
		연령대 : <%=p.getAge() %> <br/>
		기타 : <%=p.getTxt() %> <br/>
		</h3>
</body>
</html>