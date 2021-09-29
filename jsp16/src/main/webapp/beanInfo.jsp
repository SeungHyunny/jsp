<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 빈 사용을 위한 선언 -->
<jsp:useBean id = "student" class="com.vision.beans.Student" scope="page"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>빈(Bean)정보 출력</title>
</head>
<body>

<!-- Student student = new Student("홍길동","23",....) -->
<jsp:setProperty name="student" property="name" value="홍길동" />
<jsp:setProperty name="student" property="age" value="23세" />
<jsp:setProperty name="student" property="grade" value="3학년" />
<jsp:setProperty name="student" property="studentNum" value="19학번" />
<h3>
<%
	out.println(student);
%>
</h3>
<hr>
<h4>
이름 : <jsp:getProperty property="name" name="student"/> <br/>
나이 : <jsp:getProperty property="age" name="student"/> <br/>
학년 : <jsp:getProperty property="grade" name="student"/> <br/>
학번 : <jsp:getProperty property="studentNum" name="student"/> <br/>
</h4>
</body>
</html>