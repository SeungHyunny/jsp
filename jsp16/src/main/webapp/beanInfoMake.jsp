<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!-- 사용할 빈 등록 -->
<jsp:useBean id="person" class="com.vision.beans.Person" scope="page"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>빈만들기</title>
</head>
<body>
	<% //이름, 이메일, 아이디, 비밀번호, 취미, 전공, 연령, 기타
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String[] hobbys = request.getParameterValues("hobby");
		// String major = request.getParameter("major");
		String age = request.getParameter("age");
		String txt = request.getParameter("txt");
	%>
	<jsp:setProperty property="name" name="person" value="<%=name%>"/>
	<jsp:setProperty property="email" name="person" value="<%=email%>"/>
	<jsp:setProperty property="id" name="person" value="<%=id%>"/>
	<jsp:setProperty property="pw" name="person" value="<%=pw%>"/>
	<jsp:setProperty property="hobby" name="person" value="<%=hobbys%>"/>
	
	<jsp:setProperty property="age" name="person" value="<%=age%>"/>
	<jsp:setProperty property="txt" name="person" value="<%=txt%>"/>
	
	<%
		session.setAttribute("person", person);
		response.sendRedirect("dispBeanInfo.jsp");
	%>

</body>
</html>