package edu.spring.ex03;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.persistence.ReplyDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ReplyDAOTest {
	
	private static final Logger logger= LoggerFactory.getLogger(ReplyDAOTest.class);
	
	@Autowired
	private ReplyDAO dao;
	
	@Test
	public void doTest(){
		//testInsert();
//		testSelect();
//		testUpdate();
		testDelete();
	}

	private void testInsert(){
		ReplyVO vo=new ReplyVO(0,1,"댓글 입력 테스트", "admin",null);
		int result=dao.insert(vo);
		logger.info("insert result="+result);
	}
	
	private void testSelect(){
		for(ReplyVO vo: dao.select(1)){
			logger.info(vo.getRno()+" : "+vo.getBno()+" : "+vo.getRtext());
		}
	}
	
	private void testUpdate(){
		ReplyVO vo=new ReplyVO();
		vo.setRno(1);
		vo.setRtext("댓글 수정 테스트");
		
		int result=dao.update(vo);
	}
	
	private void testDelete(){
		int result=dao.delete(3);
		logger.info("result: "+result);
	}
}
