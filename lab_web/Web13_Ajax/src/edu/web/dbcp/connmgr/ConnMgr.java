package edu.web.dbcp.connmgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// DBCP를 사용한 Connection 연결/해제 유틸리티 클래스
public class ConnMgr {
	private ConnMgr(){}
	public static Connection getConnection(){
		Connection conn=null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context)initContext.lookup("java:comp/env");
			DataSource ds = (DataSource)envContext.lookup("dbcp/oraclexe");
			
			conn = ds.getConnection(); //Connection Pool안에 들어있는 커넥션을 가지고 오겠다
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}//getConnection
	
	public static void close(Connection conn, Statement stmt){
		try {
			stmt.close();
			conn.close(); //여기서의 close는 연결을 끊는 것이 아니라 Connection Pool에 Connection객체를 반환하는 것.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//close
	
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try {
			rs.close();
			close(conn,stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
