<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보수정 통보</title>
</head>
<body>
<h1><%=session.getAttribute("name")%>님의 회원정보 수정이 완료되었습니다.</h1> <hr>
수정내역<br/>
이름 : <%=session.getAttribute("name") %><br/>
비밀번호 : <%=session.getAttribute("pw") %><br/>
전화번호 : <%=session.getAttribute("phone") %><br/>
<hr>
<a href="logout.jsp">로그아웃하기</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="modify.jsp">다시수정</a>
</body>
</html>