package edu.web.member.service;

import edu.web.member.domain.MemberVO;

public interface MemberService {

	//메소드의 프로토 타입만을 설계
	boolean isExistingId(String id);
	int insert(MemberVO vo);
	
}
