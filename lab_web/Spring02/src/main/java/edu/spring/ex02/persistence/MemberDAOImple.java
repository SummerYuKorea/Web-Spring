package edu.spring.ex02.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex02.domain.MemberVO;

@Repository  //서비스에게 주입될 수 있도록
public class MemberDAOImple implements MemberDAO {
	
	private static final String NAMESPACE="edu.spring.ex02.MemberMapper";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MemberVO> select() {
		return sqlSession.selectList(NAMESPACE+".select_all");
	}

	@Override
	public MemberVO select(String userid) {
		return sqlSession.selectOne(NAMESPACE+".select_by_userid", userid);
	}

	@Override
	public int insert(MemberVO vo) {
		
		return sqlSession.insert(NAMESPACE+".insert", vo);
	}

	@Override
	public int delete(String userid) {
		
		return sqlSession.update(NAMESPACE+".delete",userid);
	}

	@Override
	public int update(MemberVO vo) {
		
		return sqlSession.update(NAMESPACE+".update",vo);
	}

}
