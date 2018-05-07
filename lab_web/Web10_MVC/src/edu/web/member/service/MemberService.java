package edu.web.member.service;

import edu.web.member.domain.MemberVO;

public interface MemberService {

	int insert(MemberVO vo);
	MemberVO select(String userid, String userpw);
	int leave(String userid);
}
