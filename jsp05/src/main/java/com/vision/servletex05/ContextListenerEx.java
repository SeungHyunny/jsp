package com.vision.servletex05;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
// 전체 서블릿들의 생명주기를 관장하는 클래스

@WebListener
public class ContextListenerEx implements ServletContextListener {
	public ContextListenerEx() {
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("contextInitialized");
	}
	
	
}
