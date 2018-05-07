package edu.spring.ex04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex04.domain.MemberVO;
import edu.spring.ex04.persistence.MemberDAO;

@Service
public class MemberServiceImple implements MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Override
	public MemberVO login(MemberVO vo) {
		return dao.login(vo);
	}

}
