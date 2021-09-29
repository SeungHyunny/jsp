package com.vision.servletex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormEX
 */
@WebServlet("/FormEX")
public class FormEX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormEX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charsset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pw");
		String[] hobbys = request.getParameterValues("hobby");
		String[] majors = request.getParameterValues("major");
		String protocl = request.getParameter("protocl");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title></title></head><body>");
		out.println("name:"+name+"<br/>");
		out.println("id:"+id+"<br/>");
		out.println("pwd:"+pwd+"<br/>");
		out.println("hobbys:"+hobbys+"<br/>");
		out.println("majors:"+majors+"<br/>");
		out.println("protocl:"+protocl+"<br/>");
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
