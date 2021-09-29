<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.vision.invalid.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
%>
<jsp:useBean id="dto" class="com.vision.invalid.MemberDTO" scope="page"/> 
<jsp:setProperty name="dto" property="*"/>
<%
	String id = (String)session.getAttribute("id");
	dto.setId(id);// 수정폼에는 id라는 파라미터가 없음 그래서 특별히 지정해줌 
	MemberDAO dao = MemberDAO.getInstance();
	int res = dao.updateMember(dto);
	if (res == MemberDAO.MEMBER_UPDATE_SUCCESS){
		%><script>
			alert("정보수정이 완료되었습니다.");
			document.location.href="main.jsp";
		</script>
		<%
	}else{
		%>
			<script>
			alert("정보수정이 실패되었습니다.");
			history.go(-1);
			</script>
		<%
	}
	
%>