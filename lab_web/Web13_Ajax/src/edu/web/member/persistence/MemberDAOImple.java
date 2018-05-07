package edu.web.member.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.web.dbcp.connmgr.ConnMgr;
import edu.web.member.domain.MemberVO;

public class MemberDAOImple implements MemberDAO {

	private static MemberDAOImple instance;
	private MemberDAOImple() {
		// TODO Auto-generated constructor stub
	}
	public static MemberDAOImple getInstance(){
		if(instance==null)instance=new MemberDAOImple();
		return instance;
	}
	
	
	@Override
	public MemberVO select(String id) {
		MemberVO vo=null;
		
		Connection conn=ConnMgr.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(SQL_SELECT_BY_USERID);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			if(rs.next()){
				String pw=rs.getString(2);
				String email=rs.getString(3);
				String active=rs.getString(4);
				vo=new MemberVO(id,pw,email,active);  //사실그냥 null이 아니기만 하면 되는ㅇ뎅..
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnMgr.close(conn, pstmt, rs);
			
		}
		return vo;
	}
	@Override
	public int insert(MemberVO vo) {
		int result=0;
		Connection conn= ConnMgr.getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getUserid());
			pstmt.setString(2, vo.getUserpw());
			pstmt.setString(3, vo.getEmail());
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnMgr.close(conn, pstmt);
		}
		
		return result;
	}

}
