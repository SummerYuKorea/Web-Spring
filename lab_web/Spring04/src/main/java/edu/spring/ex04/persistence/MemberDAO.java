package edu.spring.ex04.persistence;

import edu.spring.ex04.domain.MemberVO;

public interface MemberDAO {

	MemberVO login(MemberVO vo);
}
