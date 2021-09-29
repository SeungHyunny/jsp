package com.vision.frontcontroller;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.vision.command.*;

@WebServlet("*.do")
public class MainControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MainControl() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/http; charset=utf-8");
		String viewPage = null;
		BCommand service = null;
		String uri = request.getRequestURI(); // -> xxxxx.xxx.xxx/*.do
		String contextPath = request.getContextPath();
		String xdo = uri.substring(contextPath.length()); // -> /*.do
		switch(xdo) {
		case"/list.do":
			service = new BListCommand();
			service.execute(request, response);
			viewPage = "list.jsp";
			break;
		case"/content_view.do":
			service = new BContentCommand();
			service.execute(request, response);
			viewPage = "content_view.jsp";
			break;
		case"/write.do":
			service = new BWriteCommand();
			service.execute(request, response);
			viewPage = "list.do";
			break;	
		case"/write_view.do":
			viewPage = "write_view.jsp";
			break;
		case"/modify.do":
			service = new BModifyCommand();
			service.execute(request, response);
			viewPage = "list.do";
			break;
		case"/delete.do":
			service = new BDeleteCommand();
			service.execute(request, response);
			viewPage = "list.do";
			break;
		case"/reply.do":
			service = new BReplyCommand();
			service.execute(request, response);
			viewPage = "list.do";
			break;
		case"/reply_view.do":
			service = new BReplyViewCommand();
			service.execute(request, response);
			viewPage = "reply_view.jsp";
			break;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
