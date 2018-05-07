package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.MemberVO;

public interface MemberService {
	
	List<MemberVO> select();
	MemberVO select(String userid);
	int insert(MemberVO vo);
	int delete(String userid);
	int update(MemberVO vo);

}
