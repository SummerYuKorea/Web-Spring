package edu.web.board.service;

import java.util.List;

import edu.web.board.domain.BoardVO;
import edu.web.board.persistence.BoardDAOImple;

public class BoardSeviceImple implements BoardService {

	//멤버변수
	private BoardDAOImple dao; 
		
	//싱글턴 디자인 패턴
	private static BoardSeviceImple instance;
	private BoardSeviceImple() {
		dao=BoardDAOImple.getInstance();
	}
	public static BoardSeviceImple getInstance(){
		if(instance==null)instance=new BoardSeviceImple();
		return instance;
	}
	
	
	
	@Override
	public List<BoardVO> read() {
		System.out.println("BoardServiceImple.read() 호출");
		
		//TODO: DAO 객체의 select 메소드를 호출해서 ArrayList를 생성
		List<BoardVO> list= dao.select();
		
		return list;
	}
	
	
	@Override
	public int create(BoardVO vo) {
		System.out.println("BoardService.create() 호출");
		
		int result=dao.insert(vo);
		return result;
		
	}
	@Override
	public BoardVO read(int bno) {
		
		return dao.select(bno);
	}
	@Override
	public int update(BoardVO vo) {
		return dao.update(vo);
	}
	@Override
	public int delete(int bno) {
		return dao.delete(bno);
	}

}
