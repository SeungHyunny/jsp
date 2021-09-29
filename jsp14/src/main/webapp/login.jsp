<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
</head>
<body>
	<h1>세션 생성을 위한 로그인</h1><hr>
	<form action="loginOK.jsp" method="POST">
		아이디 : <input type="TEXT" name="id" size="10"><br/>
		비밀번호: <input type="password" name="pw" size="10"/><br/>
		<input type="submit" value="로그인">
	</form>
</body>
</html>