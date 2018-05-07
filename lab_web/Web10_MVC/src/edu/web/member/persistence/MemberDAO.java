package edu.web.member.persistence;

import static edu.web.member.domain.MemberVO.*;


import edu.web.member.domain.MemberVO;

public interface MemberDAO {

	public static final String SQL_INSERT="insert into "+TABLE_NAME+"("+COL_USERID+", "+COL_USERPW+", "+COL_EMAIL+") values(?,?,?)";
	public static final String SQL_SELECT="select * from "+TABLE_NAME
				+" where "+COL_USERID+"=? and "+COL_USERPW+"=?";
	public static final String SQL_UPDATE="update "+TABLE_NAME+" set "+COL_EMAIL+"="+"?, "+COL_USERPW+"=?, "+
											"where "+COL_USERID+"=?";
	public static final String SQL_LEAVE="update "+TABLE_NAME+" set "+COL_ACTIVE+"='N' "+" where "+COL_USERID+"=?";
	
	int insert(MemberVO vo);
	MemberVO select(String userid, String userpw);
	int leave(String userid);
}
