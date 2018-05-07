package edu.web.member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.web.dbcp.connmgr.ConnMgr;
import edu.web.member.domain.MemberVO;

public class MemberDAOImple implements MemberDAO {

	//싱글턴
	private static MemberDAOImple instance;
	private MemberDAOImple(){}
	public static MemberDAOImple getInstance(){
		if(instance==null)instance=new MemberDAOImple();
		return instance;
	}
	@Override
	public int insert(MemberVO vo) {
		int result=0;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=ConnMgr.getConnection();
		try {
			pstmt=conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpw());
			pstmt.setString(3, vo.getEmail());
			
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnMgr.close(conn, pstmt);
		}
		return result;
	}

	@Override
	public MemberVO select(String userid, String userpw) {
		MemberVO vo=null;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn=ConnMgr.getConnection();
		
		try {
			pstmt=conn.prepareStatement(SQL_SELECT);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpw);
			rs=pstmt.executeQuery();
			System.out.println("dao의 select 실행중");
			if(rs.next()){
				String email=rs.getString(3);
				System.out.println("rs.next가 true임");
				vo=new MemberVO(userid, userpw, email, "Y");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			ConnMgr.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	@Override
	public int leave(String userid) {
		int result=0;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=ConnMgr.getConnection();
		try {
			pstmt=conn.prepareStatement(SQL_LEAVE);
			pstmt.setString(1, userid);
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnMgr.close(conn, pstmt);
		}
		return result;
	}

}
