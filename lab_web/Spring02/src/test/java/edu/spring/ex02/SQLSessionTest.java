package edu.spring.ex02;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.domain.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class SQLSessionTest {
	private static final Logger logger = LoggerFactory.getLogger(SQLSessionTest.class);
	private static final String NAMESAPCE="edu.spring.ex02.BoardMapper"; //구지일케 길게안줘도되는데 그냥 겹치지 않으려고 해봄
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testSelectAll(){
		List<BoardVO> list=sqlSession.selectList(NAMESAPCE+".select_all");
		for(BoardVO vo:list){
			logger.info("vo.getTitle(): "+vo.getTitle());
		}
	}
}
