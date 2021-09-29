<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		int a = 100;
	%>
	23+34 <br>
	${23+34} <br>
	${99.99} <br>
	${"abc"} <br>
	${true} <br>
	<%=a %> <br>
	${(a>=60)?"합격":"불합격" } <br>
</body>
</html>