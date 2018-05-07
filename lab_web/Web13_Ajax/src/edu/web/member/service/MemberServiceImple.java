package edu.web.member.service;

import edu.web.member.domain.MemberVO;
import edu.web.member.persistence.MemberDAO;
import edu.web.member.persistence.MemberDAOImple;
import sun.security.jca.GetInstance;

public class MemberServiceImple implements MemberService {
	
	private MemberDAO dao;
	
	private static MemberServiceImple instance;
	private MemberServiceImple() {
		dao=MemberDAOImple.getInstance();
	}
	public static MemberServiceImple getInstance(){
		if(instance==null)instance=new MemberServiceImple();
		return instance;
	}

	@Override
	public boolean isExistingId(String id) {  //이게 서비스가 할 일이래! (dao는 진짜 접근만 하나봄_)
		MemberVO vo = dao.select(id);
		if(vo==null){ //존재하지 않는다
			return false;
		}else{		//아이디가 존재한다
			return true;
		}
	}
	
	
	@Override
	public int insert(MemberVO vo) {
		return dao.insert(vo);
	}

}
