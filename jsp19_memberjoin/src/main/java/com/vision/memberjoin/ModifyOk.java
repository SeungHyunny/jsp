package com.vision.memberjoin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 * 수정화면에서 넘어온 파라미터 값으로 디비를 UPDATE하는 작업 
 */
@WebServlet("/ModifyOk")
public class ModifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    private Connection conn;
	    private PreparedStatement pstmt;
	    private String name,id,pw,phone;
	    private String driver = "oracle.jdbc.driver.OracleDriver";
		private String url = "jdbc:oracle:thin:@localhost:1521:xe";
		private String user = "ai403";
		private String pwd = "java";
	    
	    public ModifyOk() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
		}
		
		private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			// 한글처리
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			
			// 파라미터 값 획득
			name = request.getParameter("name");
			id = (request.getParameter("id")).trim();
			pw = request.getParameter("pw");
			phone = request.getParameter("phone");
		
			// 디비작업
			try {
				Class.forName(driver);//1단계
				conn = DriverManager.getConnection(url,user,pwd);//2단계
				
				String sql = 
				"UPDATE MEMBER SET NAME=?,PW=?,PHONE=? WHERE ID = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setString(2, pw);
				pstmt.setString(3, phone);
				pstmt.setString(4, id);
				
				HttpSession session = request.getSession();
				int i = pstmt.executeUpdate();
				if(1 == i) {
					// 세션 정보도 수정 
					session.setAttribute("name", name);
					session.setAttribute("pw", pw);
					session.setAttribute("phone", phone);
					
					System.out.println("Update Success");
					response.sendRedirect("modifyResult.jsp");
				}else {
					System.out.println("Update Fail!");
					response.sendRedirect("modify.jsp");
				}
			
			
			
			} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} finally { //예외발생 유무와 관계없이 수행해야할 부분 
				// 4단계 처리 
				try {
					if(pstmt != null && !pstmt.isClosed())
						pstmt.close();
					if(conn !=null && !conn.isClosed())
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			}
			
		}
	}