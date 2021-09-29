<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드하기</title>
</head>
<body>
	<h1>파일업로드하기</h1>
	<form action="fileFormOk.jsp" method="POST" enctype="multipart/form-data">
		파일:<input type="file" name="uploadfile"><br/>
		<input type="submit" value="FileUpload">
	</form>
</body>
</html>