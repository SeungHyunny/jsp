package com.vision.servletex03;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycle
 */
@WebServlet("/Life")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycle() {        super();    }
    @PostConstruct
    public void xxxx() {
    	System.out.println("1. @PostConstruct이 붙은 메소드 xxxx() 수행");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("2. init() 메소드 수행 ~ !");
	}


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service() 메소드 수행 ~ !");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("4. destroy() 메소드 수행 ~ !");
	}
	@PreDestroy
	public void yyyy() {
		System.out.println("5. @PreDestroy이 붙은 메소드 yyyy() 수행");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("6. doGet() 호출~ !");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("7. doPost() 호출~ !");
		doGet(request, response);
	}

}
