<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		int age = 19;
		String name = "순이";
	%>
	<%!
		public String dispLine(int size, String buho){
			String line = "";
			for(int i=0; i<size; i++){
				line += buho;
			}
			return line;
		}
	%>
	<%
		// 구구단 출력
		out.println(dispLine(40,"★"));
		out.println(dispLine(80,"="));
			
		out.println("<br>");
		for(int i=2; i<=9; i++){
			out.println(9+"*"+i+"="+(9*i)+"<br>");
			if(i==5){
				%>
				이자리는 html 코드 자리입니다.<br>
				<%
			
			}	
		}
		out.println(name+"는 구구단을 못외웠어요!");
		out.println("나이는 "+age+"인데도 말입니다.");
	%>
	<hr>
	<p></p>
	<%=dispLine(30,"▶") %>
	<br>.....
	이름 : <%=name %><br>
	나이 : <%=age %><br>
		
</body>
</html>