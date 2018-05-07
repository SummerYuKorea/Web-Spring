package edu.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid=request.getParameter("userid");
		String userpw=request.getParameter("userpw");
		if(checkUser(userid, userpw)){
			//로그인 성공// 세션에 userid 속성 저장-> main 페이지로 redirect
			HttpSession session=request.getSession();
			session.setAttribute("userid", userid);
			response.sendRedirect("main");
		}else{
			//로그인 실패// 로그인 페이지 보여줌
			response.sendRedirect("login");
		}
	}
	
	private boolean checkUser(String id, String pw){
		if(id.equals("admin") && pw.equals("1234"))return true;
		else return false;
	}

}
