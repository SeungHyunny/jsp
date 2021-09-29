<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script language="JavaScript" src = "members.js"></script>
<h1>회원가입</h1><hr>
<form action="joinOk.jsp" method="POST" name="reg_frm">
	<table border="0">
		<tr>
			<td>아이디</td><td><input type="text" name="id" size="20"></td>
		</tr>
		<tr>
			<td>비밀번호</td><td><input type="password" name="pw" size="20"></td>
		</tr>
		<tr>
			<td>비밀번호확인</td><td><input type="password" name="pw_check" size="20"></td>
		</tr>
		<tr>
			<td>이름</td><td><input type="text" name="name" size="20"></td>
		</tr>
		<tr>
			<td>전화번호</td><td><input type="text" name="phone" size="20"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="회원가입" onclick="infoConfirm()">
				<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>