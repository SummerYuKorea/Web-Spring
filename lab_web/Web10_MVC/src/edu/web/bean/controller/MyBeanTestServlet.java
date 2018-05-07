package edu.web.bean.controller;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import edu.web.bean.model.MyBean;


@WebServlet(name = "beanTest", urlPatterns = { "/beanTest" })
public class MyBeanTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MyBeanTestServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MyBean클래스를 사용하려면 인스턴스 생성
		MyBean bean1 = new MyBean();
		System.out.println("\nbean1: "+bean1);
		System.out.println("num="+bean1.getMyNumber());
		System.out.println("name="+bean1.getMyName());
		
		// Tomcat 서버가 미리 생성한 MyBean 객체를 얻어옴
		// JNDI: Java Naming and Directory Interface
		try {
			Context initContext = new InitialContext();//context.xml에 저장된 것들을 불러오는것
			Context envContext = (Context)initContext.lookup("java:comp/env");//그 안에서 환경설정에 관한것만 찾아보는것
			MyBean bean2=(MyBean)envContext.lookup("bean/MyBeanFactory"); //서버가 이런 이름으로 생성한 객체를 넘겨줌
				// 이미생성한 것을 lookup을 부르는 누구에게 객체의 주소를 넘겨주는 방식->JNDI //싱글턴으로 동작함
			System.out.println("\nbean2: "+bean2);
			System.out.println("bean2.num2="+bean2.getMyNumber());
			System.out.println("bean2.name2="+bean2.getMyName());
			
			MyBean bean3=(MyBean)envContext.lookup("bean/MyBeanFactory");
			System.out.println("\nbean3: "+bean3);
			
			MyBean bean4=(MyBean)envContext.lookup("bean/MyBeanFactory2");
			System.out.println("\nbean4: "+bean4);
			System.out.println("bean4.num4="+bean4.getMyNumber());
			System.out.println("bean4.name4="+bean4.getMyName());
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
