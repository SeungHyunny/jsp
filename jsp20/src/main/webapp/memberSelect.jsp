<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ page import="com.vision.daoex.*" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다오활용결과</title>
</head>
<body>

<h1>다오활용결과</h1><hr>
<%
	MemberDAO dao = new MemberDAO();
	Connection conn = ConnFactory.getInstance(); //일반 JDBC이용
	//Connection conn = DBCPFactory.getInstance(); //DBCP이용
	ArrayList<MemberDTO> data = dao.selectAll(conn);
	for(MemberDTO x:data){
		out.println(x+"<br/>");
	}
%>

</body>
</html>