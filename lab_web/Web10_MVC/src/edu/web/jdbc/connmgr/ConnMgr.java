package edu.web.jdbc.connmgr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

//JDBC를 사용하여 Connection 설정/해제를 담당하는 유틸리티 클래스
public class ConnMgr {
	public static final String URL= "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER="scott";
	public static final String PASSWD="tiger";
	
	//객체생성못하도록(나중에 메소드를 다 퍼블릭 스테틱할거거든 like Math클래스)
	private ConnMgr(){}
	
	public static Connection getConnction(){
		Connection conn=null;
		
		
		try {
			//JDBC 드라이버를 메모리에 로드
			DriverManager.registerDriver(new OracleDriver());//오라클드라이버두개있는데 jdbc.오라클 더짧은거 쓰는게 권장된대
			
			//연결
			conn=DriverManager.getConnection(URL,USER,PASSWD);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}//getConnection
	
	
	
	public static void close(Connection conn, Statement stmt){
		try {
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//close
	
	public static void close(Connection conn, Statement stmt, ResultSet rs){
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//close
}
