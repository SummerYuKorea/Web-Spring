package edu.spring.ex03.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex03.domain.ReplyVO;
import edu.spring.ex03.service.ReplyService;

//RequestMapping
// ex03/replies (POST): 댓글 추가(insert)
// ex03/replies/all/숫자(bno) (GET): 해당 글번호(bno)의 모든 댓글 검색(select)
// ex03/replies/숫자(rno) (PUT): 해당 댓글 번호(rno)의 내용을 수정(update)
// ex03/replies/숫자(ron) (DELETE): 해당 댓글 번호(rno)의 댓글 삭제(delete)
@RestController
@RequestMapping(value="/replies")
public class ReplyRESTController {
	
	@Autowired
	private ReplyService service;
	
	@RequestMapping(method=RequestMethod.POST)  //class의 메핑주소가 이메소드의 주소라서 value 주지 않는다
	public ResponseEntity<Integer> createReply(@RequestBody ReplyVO vo){  //Integer<- insert의 결과가 정수라서 
		//RequestBody안에 넣어서 들어올것이라고 명시하는것(적지않아도 그렇지만 걍 더 확실히)/그안에 있는 것들을 dispatcher가 ReplyVO로 변환해서 vo매개변수로 넘어오는것
		int result;
		try {
			result = service.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<Integer> entity = new ResponseEntity<Integer>(0, HttpStatus.OK); 
		//entity = header(HttpStatus.OK) + body(result(문자열이든 arrayList든))
		
		return entity;		
	}
	
	@RequestMapping(value="/all/{no}", method=RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> readReplies(@PathVariable("no") int bno){  //URL(path)의 일부분을 변수(variable)로 사용하겠다! -> no //그변수값을 bno에 저장
		List<ReplyVO> list= service.read(bno);
		ResponseEntity<List<ReplyVO>> entity=new ResponseEntity<List<ReplyVO>>(list,HttpStatus.OK);
		return entity;
		
	}
	
	@RequestMapping(value="{no}", method=RequestMethod.PUT)
	public ResponseEntity<String> updateReply(
			@PathVariable("no") int rno,
			@RequestBody ReplyVO vo){
		vo.setRno(rno);
		int result= service.update(vo);
		ResponseEntity<String> entity;
		
		// 그냥 한번 String으로 줘보는중(ResponseEntity는 어떤 타입이던지 넣을 수 있다는 것을 보기위해~)
		if(result==1){
			entity=new ResponseEntity<String>("success", HttpStatus.OK);
		}else{
			entity=new ResponseEntity<String>("fail", HttpStatus.OK);
		}
		return entity;
	}
	
	@RequestMapping(value="{no}", method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteReply( @PathVariable("no") int rno){
		int result;
		ResponseEntity<String> entity;
		try {
			result = service.delete(rno);

			
			if(result==1){
				entity=new ResponseEntity<String>("success", HttpStatus.OK);
			}else{
				entity=new ResponseEntity<String>("fail", HttpStatus.OK);
			}
			return entity;
		} catch (Exception e) {
			entity=new ResponseEntity<String>("fail", HttpStatus.OK);
			return entity;
		}
		
	}
	
} 
