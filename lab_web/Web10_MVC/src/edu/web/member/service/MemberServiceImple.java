package edu.web.member.service;

import edu.web.member.domain.MemberVO;
import edu.web.member.persistence.MemberDAO;
import edu.web.member.persistence.MemberDAOImple;

public class MemberServiceImple implements MemberService {

	//멤버변수
	private MemberDAO dao;
	
	//싱글턴 제조
	private static MemberServiceImple instance;
	private MemberServiceImple() {
		dao=MemberDAOImple.getInstance();
	}
	public static MemberServiceImple getInstance(){
		if(instance==null) instance=new MemberServiceImple();
		return instance;
	}
	@Override
	public int insert(MemberVO vo) {
		
		return dao.insert(vo);
	}

	@Override
	public MemberVO select(String userid,String userpw) {
		
		return dao.select(userid, userpw);
	}
	@Override
	public int leave(String userid) {
		return dao.leave(userid);
	}

}
