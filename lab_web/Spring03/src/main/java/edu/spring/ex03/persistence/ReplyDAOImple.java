package edu.spring.ex03.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex03.domain.ReplyVO;

@Repository //root-context에서 component-scan, 클래스 선언시 annotaion ///2가지 꼭 필요
public class ReplyDAOImple implements ReplyDAO {

	private static final String NAMESPACE="edu.spring.ex03.ReplyMapper";
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ReplyVO vo) {
		return sqlSession.insert(NAMESPACE+".insert",vo);
	}

	@Override
	public List<ReplyVO> select(int bno) {
		return sqlSession.selectList(NAMESPACE+".select_by_bno", bno);
	}
	
	@Override
	public int update(ReplyVO vo) {
		return sqlSession.update(NAMESPACE+".update", vo);
	}
	
	@Override
	public int delete(int rno) {
		return sqlSession.delete(NAMESPACE+".delete",rno);
	}

	@Override
	public int updateReplyCnt(int amount, int bno) {
		Map<String, Integer> map=new HashMap<>();
		map.put("amount", amount);
		map.put("bno", bno);
		return sqlSession.update("edu.spring.ex03.BoardMapper.update_reply_cnt", map);
	}

	@Override
	public int selectBno(int rno) {
		return sqlSession.selectOne(NAMESPACE+".select_bno", rno);
	}

}
