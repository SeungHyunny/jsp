<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mem" class="com.vision.elex.Member" scope="application"/>
<jsp:setProperty name="mem" property="name" value="홍길동"/>
<jsp:setProperty name="mem" property="id" value="HGD"/>
<jsp:setProperty name="mem" property="pwd" value="1234"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름:${mem.name}<br>
	id:${mem.id}<br>
	pwd:${mem.pwd}<br>
	암호 :<jsp getProperty property="pwd" name="mem"/>

</body>
</html>