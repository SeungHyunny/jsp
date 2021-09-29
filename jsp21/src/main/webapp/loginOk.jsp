<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vision.invalid.*" %>    
<%
	request.setCharacterEncoding("UTF-8");
	//response.setContentType("text/html; charset=UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDAO dao = MemberDAO.getInstance();
	int checkRes = dao.userCheck(id, pw);
	if(checkRes == MemberDAO.MEMBER_LOGIN_IS_NOT){
		%>
		<script>alert("등록된 아이디가 없습니다.");history.go(-1);</script>
		<%
	} //-1
	else if(checkRes == MemberDAO.MEMBER_LOGIN_PW_NO_GOOD){
		%>
		<script>alert("비밀번호가 틀립니다.");history.go(-1);</script>
		<%
	} //0 
	else if(checkRes == MemberDAO.MEMBER_LOGIN_SUCCESS){
		// 로그인된 결과를 session에 등록하는 작업 
		MemberDTO dto = dao.getMember(id);
		session.setAttribute("id", id);
		session.setAttribute("name",dto.getName());
		session.setAttribute("phone",dto.getPhone());
		// 등록된 사용자만 사용하게끔 세션정보에 추가하여
		// 필요한 사이트에서 이 세션을 점검한다.
		session.setAttribute("validOk","ok");
				
		response.sendRedirect("main.jsp"); // 메인 페이지로 전환 
		
	} // 1
	
%>    
