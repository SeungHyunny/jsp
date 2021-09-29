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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; encoding=UTF-8");	
	%>
	<%!
		String name = "홍길동";
		int age = 23;
	%>
	<h1>Main Page</h1>
	<jsp:include page="sub1.jsp" flush="false">
		<jsp:param name="name" value="<%=name %>"/>
		<jsp:param name="age" value="<%=age %>"/>
	</jsp:include>
	메인에서 출력된 정보<br/>
	이름 : <%=name %><br/>
	나이 : <%=age %><br/>
	
</body>
</html>