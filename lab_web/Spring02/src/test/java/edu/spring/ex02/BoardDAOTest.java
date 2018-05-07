package edu.spring.ex02;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	private static final Logger logger= LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Autowired
	private BoardDAO dao;  //스프링프레임웤이 생성해야해 <- 그래서 root.xml에 package-scan그거 설정한거야 생성한애 찾아오려고? (근데 servlet-context.xml에있어서원래되긴
	
	@Test
	public void testDAO(){
		testPaging();
	}
	
	public void testSelectAll(){
		List<BoardVO> list =dao.select();
		for(BoardVO vo:list){
			logger.info(vo.getBno()+" : "+vo.getTitle());
		}
	}
	
	public void testSelectByBno(){
		BoardVO vo =dao.select(9);
		if(vo!=null){
		logger.info(vo.getBno()+" : "+vo.getTitle());  //vo가 널이라도 에러가 안나네!! 개쩜
		}else{
			logger.info("건샋결과업슴~");
		}
	}
	
	public void testInsert(){
		BoardVO vo= new BoardVO(1,"한결이가 방금 만든 제목","한결이가 방금 작성한 내용 !!", "summer123", null);
		int result=dao.insert(vo);
		if(result==1){
			logger.info("insert성공~");
		}else{
			logger.info("insert실패~");
		}
	}
	
	public void testSelectByUserid(){
		List<BoardVO> list= dao.select("sum");
		for(BoardVO vo: list){
			logger.info("짠-> "+vo.getTitle()  +" :: "+vo.getContent()+" :: "+vo.getUserid());
		}
	}
	
	public void testUpdate(){
		BoardVO vo=new BoardVO(9,"Spring","봄날씨 존좋", null, null);
		int result=dao.update(vo);
		if(result==1){
			logger.info("업ㅇ데이트 성공~");
		}else{
			logger.info("업ㅇ데이트 실패~");
		}
	}
	
	public void testDelete(){
		int result =dao.delete(11);
		if(result==1){
			logger.info("삭제 성공");
		}else{
			logger.info("삭제 실패");
		}
	}
	
	public void testSelectByTitleOrContent(){
		
		List<BoardVO> list=dao.select1("?");
		
		for(BoardVO vo:list){
			logger.info(vo.getBno()+" : "+vo.getTitle()+" : "+ vo.getContent());
		}
	}
	
	private void testTotalNums(){  //위에도 전부 private으로 만들었어야지?
		int result=dao.getTotalNumsOfRecords();
		logger.info("# of records: "+result);
	}
	
	private void testPaging(){
		PageCriteria criteria=new PageCriteria(2,3);//start end에 
		//List<BoardVO> list=dao.select(2,6);
		List<BoardVO> list=dao.select(criteria);
		for(BoardVO vo:list){
			logger.info("짠-> "+vo.getTitle()  +" :: "+vo.getContent()+" :: "+vo.getUserid());
		}
	}

}
