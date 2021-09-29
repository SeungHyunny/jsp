<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.vision.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
table{
	width: 30%;
	border: 2px solid;
	border-color:orange;
}
th, td {
    padding: 10px;
    align:left;
}
</style>
<meta charset="UTF-8">
<title>WRITE VIEW</title>
</head>
<body>

<table align="center">
	<form action="write.do" method="POST">
	<tr>
		<td colspan="5"><h1 align="center">게시글작성</h1></td>
	</tr>
	<tr>
		<th class="jb-th-1">게시자</th>
		<td><input type="text" name="bname" size="30"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="btitle" size="30"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="bcontent" cols="50" rows="10"></textarea>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="작성하기" style="width: 50pt; height:25pt">
			<input type="button" value="목록보기" style="width: 50pt; height:25pt" onclick="javascript:window.location='list.do'">
			<input type="reset" value="닫기" style="width: 50pt; height:25pt">
		</td>
	</tr>
	</form>
</table>

</body>
</html>