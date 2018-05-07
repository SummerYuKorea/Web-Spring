<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <%
   // 1.JDNI 서버 객체 생성
   InitialContext ic = new InitialContext();
   // 2. lookup()
   DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/myoracle");//env까지가 tomcat에서 관리하는 가상의 리소스 디렉토리
   // 3.getConnection() 
   Connection conn = ds.getConnection();
   
   Statement stmt = conn.createStatement();
   ResultSet rs = stmt.executeQuery("select * from test");
   
   while(rs.next()) {
      out.println("아이디: " + rs.getString("aa") + ", 비번: " + rs.getString("bb"));
   }
   
   rs.close();
   stmt.close();
   conn.close();
   %>

</body>
</html>