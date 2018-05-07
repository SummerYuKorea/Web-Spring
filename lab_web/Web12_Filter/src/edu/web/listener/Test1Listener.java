package edu.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class Test1Listener implements HttpSessionListener {

  
    public Test1Listener() {
        // TODO Auto-generated constructor stub
    }

	
    public void sessionCreated(HttpSessionEvent arg0)  { 
        System.out.println("세션 생성");
    }

	
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("세션 삭제");
    }
	
}
