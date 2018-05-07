package edu.spring.ex03;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.service.ReplyService;

@RestController
//RestCOntroller라고 선언된 클래스의 메소드들은 전부 그 리턴값들이 View(JSP) 파일의 이름을 의미하는 것이 아니라
//ResponseBody에 포함되서 클라이언트에게 직접 전달됨
//RestController의 메소드들에는 @ResponseBody 어노테이션을 사용하지 않음
//	@RestController는 스프링 4버전부터 지원
public class RESTController {
	
	@Autowired
	private ReplyService service;
	
	@RequestMapping(value="/rest1" , method=RequestMethod.GET)
	public String rest1(){
		return "Hello, REST Controller!";
	}
	
	@RequestMapping(value="rest2")
	public List<ReplyVO> rest2(){
		int bno=2;
		return service.read(bno);
		
	}
	
	//ResponseEntity는 에러처리할 때 좋은?
	// 구지 쓸 이유 없는듯

	@RequestMapping(value="/rest3")
	public ResponseEntity<ReplyVO> rest3(){
		ReplyVO vo = new ReplyVO(11,22,"댓글 Ajax REST 테스트", "admin", new Date());
		ResponseEntity<ReplyVO> entity= 
					new ResponseEntity<ReplyVO>(vo, HttpStatus.OK); //보내줄데이타, 리턴코드(개발자도구에서확인가능)
		return entity;
	}
	
	@RequestMapping(value="/rest4")
	public ResponseEntity<List<ReplyVO>> rest4(){
		List<ReplyVO> list=service.read(1);
		ResponseEntity<List<ReplyVO>> entity=new ResponseEntity<List<ReplyVO>>(list, HttpStatus.OK);
		return entity;
	}
	
}
