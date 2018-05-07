package edu.spring.ex02.persistence;

import java.util.List;

import edu.spring.ex02.domain.MemberVO;

public interface MemberDAO {
	
	List<MemberVO> select();
	MemberVO select(String userid);
	int insert(MemberVO vo);
	int delete(String userid);
	int update(MemberVO vo);
	

}
