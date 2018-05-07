package edu.spring.ex02.persistence;

import java.util.List;
import java.util.Map;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;

public interface BoardDAO {
	
	public List<BoardVO> select();
	BoardVO select(int bno);
	List<BoardVO> select(String userid);
	List<BoardVO> select1(String gum);
	int insert(BoardVO vo);
	int update(BoardVO vo);
	int delete(int bno);
	
	int getTotalNumsOfRecords();
	//List<BoardVO> select(int start, int end);
	List<BoardVO> select(PageCriteria pc);


}
