package edu.spring.ex02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex02.persistence.MemberDAO;
import edu.spring.ex02.domain.MemberVO;

@Service
public class MemberServiceImple implements MemberService {
	
	@Autowired
	private MemberDAO dao;

	@Override
	public List<MemberVO> select() {
		return dao.select();
	}

	@Override
	public MemberVO select(String userid) {
		return dao.select(userid);
	}

	@Override
	public int insert(MemberVO vo) {
		return dao.insert(vo);
	}

	@Override
	public int delete(String userid) {
		return dao.delete(userid);
	}

	@Override
	public int update(MemberVO vo) {
		return dao.update(vo);
	}

}
