package edu.web.member.persistence;

import edu.web.member.domain.MemberVO;
import static edu.web.member.domain.MemberVO.*;

public interface MemberDAO {
	
	public static final String SQL_SELECT_BY_USERID="select * from "+TABLE_NAME+" where "+COL_USERID+"=?";
	public static final String SQL_INSERT="insert into "+TABLE_NAME+
			"("+COL_USERID+","+COL_USERPW+","+COL_EMAIL+") values(?,?,?)";
	
	MemberVO select(String id);
	int insert(MemberVO vo);

}
