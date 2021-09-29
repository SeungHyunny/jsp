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
<title>COTENT_VIEW</title>
</head>
<body>
<%
	//정보저장
	BoardDTO dto = (BoardDTO)request.getAttribute("content_view");
%>
<!-- 폼꾸미기 -->
<table align="center">
<form action="modify.do" method="POST">
	<input type="hidden" name="bid" value="<%=dto.getBid()%>">
	<input type="hidden" name="bhit" value="<%=dto.getBhit() %>">
	<input type="hidden" name="bname" value="<%=dto.getBname()%>">
	<tr>
		<th colspan="5"><h1>게시글보기</h1></th>
	</tr>
	<tr>
		<th>번호</th>
		<td><%=dto.getBid() %></td>
	</tr>
	<tr>
		<th>조회수</th>
		<td><%=dto.getBhit() %></td>
	</tr>
	<tr>
		<th>게시자</th>
		<td><%=dto.getBname() %></td>
	</tr>
	<tr>
		<th>게시일자</th>
		<td><%=dto.getBdate() %></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><input type="text" name="btitle" value="<%=dto.getBtitle() %>"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="50" name="bcontent"><%=dto.getBcontent() %></textarea>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정하기" style="width: 50pt; height:25pt">
			<input type="button" value="목록보기" style="width: 50pt; height:25pt" onclick="javascript:window.location='list.do'">
			<input type="button" value="삭제하기" style="width: 50pt; height:25pt" onclick="javascript:window.location='delete.do?bid=<%=dto.getBid() %>'">
			<input type="button" value="댓글달기" style="width: 50pt; height:25pt" onclick="javascript:window.location='reply_view.do?bid=<%=dto.getBid() %>'">
		</td>
	</tr>
</form>
</table>
</body>
</html>