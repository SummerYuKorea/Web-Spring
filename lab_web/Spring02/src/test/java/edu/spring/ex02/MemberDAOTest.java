package edu.spring.ex02;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex02.persistence.MemberDAO;
import edu.spring.ex02.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)  //testClass를 누가 실행시켜 줄거냐
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDAOTest {

	private static final  Logger logger= LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Autowired
	private MemberDAO dao;
	
	@Test
	public void testMemberDAO(){
		testSelectByUserid();
	}
	private void testSelectAll(){
		List<MemberVO> list=dao.select();
		for(MemberVO vo:list){
			logger.info("아이디: "+vo.getUserid()+"  비번: "+vo.getUserpw()+
					"  이멜: "+vo.getEmail()+"  액티브: "+vo.getActive());
		}
	}
	
	private void testSelectByUserid(){
		MemberVO vo=dao.select("summer");
		if(vo!=null){
			logger.info(vo.getUserid()+" : "+vo.getUserpw()+" : "+vo.getEmail()+" : "+vo.getActive());
		}else{
			logger.info("해당 아이디의 회원이 없");
		}
	}
}
