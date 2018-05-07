package edu.web.board.service;

import java.util.List;
import edu.web.board.domain.BoardVO;

// CRUD (create, read, update, delete) :DB의 네가지 기본 동작
// 서비스객체: CRUD를 이용한 비지니스 로직(서비스 흐름)을 설계하는 일
public interface BoardService {

	List<BoardVO> read();//ArrayList는 List상속받은애야. AL쓸거지만 걍 List로 하는중
	
	int create(BoardVO vo);
	BoardVO read(int bno);
	
	int update(BoardVO vo);
	int delete(int bno);
}
