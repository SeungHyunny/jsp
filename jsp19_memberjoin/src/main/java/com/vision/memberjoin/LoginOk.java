package com.vision.memberjoin;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginOk
 * 로그인 창에서 전달받은 회원의 아이디와 패스워드를 점검
 * 데이터베이스에 접근해서 처리해야함
 */

@WebServlet("/LoginOk")
public class LoginOk extends HttpServlet {
	private static final long serialVersionUID = 1L; //클래스 버전관리하는 부호
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "ai403";
	private String pwd = "java";
	
    public LoginOk() { }
    	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	actionDo(request,response);
    }	
    	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	actionDo(request,response);
    }
    //파라미터로 넘어온 id와 password를 점검
    private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String id=request.getParameter("id");
    	String pw=request.getParameter("pw");
    	String sql = "SELECT * FROM MEMBER WHERE ID=? AND PW=?";
    	
    	//JDBC 1단계
    	try {//예외처리 해줘야 오류x
			
    		Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			int size = 0;
			
			String xname="";
			String xid="";
			String xpw="";
			String xphone="";
			
			while(rs.next()) {
				size += 1;
				xname = rs.getString("NAME");
				xid = rs.getString("ID");
				xpw = rs.getString("PW");
				xphone = rs.getString("PHONE");
			}

			if(size >= 1) {
				HttpSession session = request.getSession();
				session.setAttribute("name", xname);
				session.setAttribute("id", xid);
				session.setAttribute("pw", xpw);
				session.setAttribute("phone", xphone);
				
				response.sendRedirect("loginResult.jsp");
			
			}else {
				response.sendRedirect("login.html");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { //jdbc 4단계 작업
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
}
