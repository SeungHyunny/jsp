<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="com.vision.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
table{
	width:40%;
	border: 2px solid;
	border-collapse: collapse;
	border-color:orange;
}
th, td {
    padding: 10px;
    align:center;
    text-align:center;
}
.td_title{
	align:left;
	text-align:left;
}
</style>
<meta charset="UTF-8">
<title>LIST</title>
</head>
<body>
<%
	ArrayList<BoardDTO> list = (ArrayList<BoardDTO>)request.getAttribute("list");
%>
	<table align="center">
		<form action="write_view.do" method="POST">
		<tr>
			<td colspan="5"><h1>게시글목록</h1></td>
		</tr>	
		<tr>
			<th>번호</th>
			<th>게시자</th>
			<th>제목</th>
			<th>게시일자</th>
			<th>조회수</th>
		</tr>
<% 
	for(BoardDTO x:list){
%>
		<tr>
			<td><%=x.getBid() %></td>
			<td><%=x.getBname() %></td>
			<td class="td_title">
			<%
				int len = x.getBindent();
				for(int i=0; i<len; i++){
			%>
				&nbsp;&nbsp;&nbsp;
			<%
				}
			%>
				<a href="content_view.do?bid=<%=x.getBid() %>"><%=x.getBtitle() %></a>
			</td>
			<td><%=x.getBdate() %></td>
			<td><%=x.getBhit() %></td>
		</tr>
<% 	
	}
%>
		<tr>
			<td colspan="5">
				<input type="submit" value="글작성하기" style="width: 70pt; height:25pt;">
				<input type="reset" value="닫기" style="width: 50pt; height:25pt">
			</td>
		</tr>
	</table>
</body>
</html>