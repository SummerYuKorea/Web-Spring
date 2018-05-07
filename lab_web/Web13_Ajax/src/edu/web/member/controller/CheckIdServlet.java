package edu.web.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.dbcp.connmgr.ConnMgr;
import edu.web.member.service.MemberServiceImple;

@WebServlet(name = "checkId", urlPatterns = { "/check-id" })
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberServiceImple service;
    public CheckIdServlet() {
    	service=MemberServiceImple.getInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8"); //이거 할 필요 없음 ajax에서 json object로 넘기면 안해도 되던데?
		
		String id=request.getParameter("userid");
		System.out.println("id: "+id); //잼~
		
		
		PrintWriter out = response.getWriter();
		if(service.isExistingId(id)){ //DB에 아이디가 존재하는 경우
			out.write("invalid");  //지금 response에 적는 중이라는 것!(브라우져로 전달됨) 콜백함수에서 res 처리 하면 되지
		}else{ //DB에 아이디가 없는 경우
			out.write("valid");
			
		}
	}

}
