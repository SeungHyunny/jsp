<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jdbc4단계</title>
</head>
<body>
<%!
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String uid = "ai403";
	String upw = "java";
	String sql = "SELECT * FROM MEMBER";
%>
<h1>고객정보 출력</h1>
<hr>
<%
	try{
		Class.forName(driver); //1단계
		conn = DriverManager.getConnection(url,uid,upw);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()){
			String id = rs.getString("ID"); // = 1 : 컬럼이름을 넣어도 되고 순번을 넣어도 됨
			String pw = rs.getString("PW");
			String name = rs.getString("NAME");
			String phone = rs.getString("PHONE");
			
			out.println("아이디:"+id+" / 비밀번호:"+pw+" / 이름:"+name+" / 전화번호:"+phone+"<br/>");
		}
		conn.close();
	}catch(SQLException e){
		out.println("db에 이상이 있습니다.<br/>");
	}
%>
</body>
</html>