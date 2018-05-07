package edu.spring.ex03.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.persistence.ReplyDAO;

@Service
public class ReplyServiceImple implements ReplyService {

	private static final Logger logger=LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO dao;
	
	@Transactional()
	// root-context.xml 에서 설정한 transactionManager를 weaving
	@Override
	public int create(ReplyVO vo) throws Exception {
		dao.insert(vo);
		logger.info("댓글 입력 성공");
		
		dao.updateReplyCnt(1, vo.getBno());
		logger.info("게시판 댓글 개수 업데이트 성공");
		
		return 1;
	}

	@Override
	public List<ReplyVO> read(int bno) {
		return dao.select(bno);
	}

	@Override
	public int update(ReplyVO vo) {
		return dao.update(vo);
	}

	@Transactional
	@Override
	public int delete(int rno) {
		dao.delete(rno);
		logger.info("댓글 삭제 성공");
		
		int bno=dao.selectBno(rno);
		dao.updateReplyCnt(-1, bno);
		
		return 1;  //throw되는게 없으면 성공적으로 리턴까지올테니까 그냥 1(성공)넘기기
	}

}
