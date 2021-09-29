package com.vision.memberjoin;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinOk
 */
@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PreparedStatement pstmt;
	private String name,id,pw,phone1,phone2,phone3;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	
	//메소드를 하나 만들어 get/post에서 호출
	//회원가입 폼에서 전달받은 파라미터 값을 db에 저장하는 작업
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//파라미터 값 획득
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		
		//예외처리해야함
		//db작업
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //1단계
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String uid = "ai403";
			String upw = "java";
			
			conn = DriverManager.getConnection(url,uid,upw); //2단계
			String sql = "Insert into member (name,id,pw,phone) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, phone1+"-"+phone2+"-"+phone3);
			
			int i = pstmt.executeUpdate();
			if(1 == i) {
				System.out.println("Insert Success");
				response.sendRedirect("joinResult.jsp");
			}else {
				System.out.println("Insert Fail!");
				response.sendRedirect("join.html");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//예외발생 유무와 관계없이 수행해야할 부분 //4단계
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
