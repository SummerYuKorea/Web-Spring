package edu.spring.ex02.service;

import java.util.List;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;

// CRUD( Create, Read, Update, Delete)
public interface BoardService {

	int create(BoardVO vo);
	List<BoardVO> read();
	BoardVO read(int bno);
	int update(BoardVO vo);
	int delete(int bno);
	
	int getTotalNumsOfRecords();
	List<BoardVO> read(PageCriteria criteria);
}
