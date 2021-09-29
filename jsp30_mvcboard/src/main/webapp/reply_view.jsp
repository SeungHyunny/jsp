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
<title>REPLY VIEW</title>
</head>
<body>
<%
	BoardDTO dto = (BoardDTO)request.getAttribute("reply_view");
%>
<table align="center">
<form action="reply.do" method="POST">
	<input type="hidden" name="bid" value="<%=dto.getBid() %>">
	<input type="hidden" name="bgroup" value="<%=dto.getBgroup() %>">
	<input type="hidden" name="bstep" value="<%=dto.getBstep() %>">
	<input type="hidden" name="bindent" value="<%=dto.getBindent() %>">
	<tr>
		<td colspan="5"><h1 align="center">댓글작성</h1></td>
	</tr>
	<tr>
		<th>게시번호</th>
		<td><%=dto.getBid() %></td>
	</tr>
	<tr>
		<th>조회수</th>
		<td><%=dto.getBhit() %></td>
	</tr>
	<tr>
		<th>게시자</th>
		<td><input type="text" name="bname" size="30"></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="btitle" size="30" value="re&gt;<%=dto.getBtitle() %>"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="bcontent" cols="50" rows="10" value="re&gt;<%=dto.getBcontent() %>"></textarea>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="답변등록" style="width: 50pt; height:25pt">
			<input type="button" value="목록보기" style="width: 50pt; height:25pt" onclick="javascript:window.location='list.do'">
			<input type="reset" value="취소" style="width: 50pt; height:25pt">
		</td>
	</tr>
</form>
</table>
</body>
</html>