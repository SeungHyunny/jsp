<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>모든 세션을 지우고 난 후 결과보기</h1>
<%
	//세션정보 모두 지우기
	session.invalidate();
	if(request.isRequestedSessionIdValid()){
		out.println("session valid!");
		Enumeration enumeration = session.getAttributeNames();
		String key;
		Object value;
		
		while(enumeration.hasMoreElements()){
			key = enumeration.nextElement().toString();
			value = session.getAttribute(key);
			out.println("sessionName:"+key+"<br/>");
			out.println("sessionValue:"+value+"<br/>");
		}
	}else{
		out.println("session invalid!");
	}

%>
</body>
</html>