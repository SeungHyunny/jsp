package com.vision.servletex05;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInitParam
 */
//@WebServlet("/ServletInitParam")
public class ServletInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInitParam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 아래 2줄은 항상 코딩해줘야함
		//////////////////////////////////////////////////////
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//////////////////////////////////////////////////////
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = getInitParameter("id");
		String pw = getInitParameter("pw");
		String company = getServletContext().getInitParameter("company");
		String telephone = getServletContext().getInitParameter("telephone");
		
		PrintWriter out = response.getWriter();		
		out.println("<html><head></head><body>");
		out.println("<h1>아이디"+id+"</h1>");
		out.println("<h1>패스워드"+pw+"</h1>");
		out.println("<h1>회사"+company+"</h1>");
		out.println("<h1>전화번호"+telephone+"</h1>");
		out.println("</body>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
