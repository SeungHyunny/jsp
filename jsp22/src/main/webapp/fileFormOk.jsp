<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.util.*" %>
<%
	String path = request.getRealPath("fileFolder");
	int size = 1024 * 1024 * 10; //10MB
	String file = "";
	String oriFile = "";
// D:\springworkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\jsp22\fileFolder
	try{
		MultipartRequest mrequest = 
				new MultipartRequest(request,path,size,"utf-8",new DefaultFileRenamePolicy());
		Enumeration<String> files = mrequest.getFileNames();
		String str = files.nextElement();
		
		file = mrequest.getFilesystemName(str);
		oriFile = mrequest.getOriginalFileName(str);
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1></h1>
</body>
</html>