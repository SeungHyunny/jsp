<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	//if(session.getAttribute("validOk")==null){
	if(!session.getAttribute("validOk").equals("ok")){
	%>	
		<jsp:forward page="login.jsp"/>
	<%
	}
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
	String phone = (String)session.getAttribute("phone");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
<h1>검증된 자만 사용하는 메인화면</h1><hr>
<h2><%=name %>님 안녕하세요.</h2>
<form action="logout.jsp" method="post">
	<input type="submit" value="로그아웃"> &nbsp;&nbsp;&nbsp;&nbsp; 
	<input type="button" value="정보수정" onclick="javascript:window.location='modify.jsp'">
</form>

</body>
</html>