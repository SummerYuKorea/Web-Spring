package edu.spring.ex02.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex02.domain.BoardVO;
import edu.spring.ex02.pageutil.PageCriteria;
import edu.spring.ex02.pageutil.PageMaker;
import edu.spring.ex02.service.BoardServiceImple;

@Controller
@RequestMapping(value="/board")
//RequestMapping을 두가지 종류가 있다 탑레벨, 메소드 레벨// 얜 탑레벨~(주소에서  /board/--- 식으로 뒤에 붙여서 ㅏ사용)//나중에 jsp로 이동할 때도 views/board/---.jsp로이동
public class BoardController {
	private static final Logger logger=LoggerFactory.getLogger(BoardServiceImple.class);
	
	@Autowired
	private BoardServiceImple boardService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET )
	public void list(Model model,    Integer page, Integer perPage){//현재페이지정보, 한페이지에몇개보여줄건지 
																								//int로 줘버리면 널이넘어왓을경우 parseInt하면서 에러날 수 있어
		//리턴안하면 list.jsp찾겠졍
		
		//페이징 처리 이전 코드
//		List<BoardVO> list= boardService.read();
//		model.addAttribute("boardList", list);
		//list가 list.jsp로 갈때 모델에 실려서 가겠지
		
		// Paging 처리
		PageCriteria c=new PageCriteria();
		if(page!=null){
			c.setPage(page);
		}
		if(perPage!=null){
			c.setNumsPerPage(perPage);
		}
		
		List<BoardVO> list=boardService.read(c);
		model.addAttribute("boardList", list);
		
		//아래에 링크 (1,2,3,4.. )생성하려면 pager maker객체도 필요하지
		PageMaker maker = new PageMaker();
		maker.setCriteria(c);
		maker.setTotalCount(boardService.getTotalNumsOfRecords());
		//나머지 전부 set하는 setter메소드지->
		maker.setPageData();
		model.addAttribute("pageMaker", maker);
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)  //새글작성클릭했을때
	public void registerGET(){
		logger.info("registerGET() 호출");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)  //작성완료클릭했을때
	public String registerPOST(BoardVO vo, RedirectAttributes reAttr){ //BoardVO 집중!!!
		// request body 안에 넣어서 서버로 전달된 data들이// front controller에 의해서 메소드에게 전달이 됨 다음과 같이->
		//이 매개변수로 넘어올때 BoardVO 디폴트 생성자 불러서 생성한 후 form에서 name으로 넘어오는 값들을 setter메소드로 넣어서 넘어옴
//		try {
//			req.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		logger.info("registerPOST() 호출");
		logger.info("제목: "+vo.getTitle());
		logger.info("아이디: "+vo.getUserid());
		logger.info("본문: "+vo.getContent());
		
		int result=boardService.create(vo);
		if (result == 1) { // DB insert 성공
			reAttr.addFlashAttribute("insert_result", "success");  //세션에 객체에 넣는것
		} else { // DB insert 실패
			reAttr.addFlashAttribute("insert_result", "fail");
		}
		
		return "redirect:/board/list";
	}
	
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public void detail(int bno, Model model , @ModelAttribute("criteria") PageCriteria c){
		logger.info("detail() 호출 : bno="+bno);
		BoardVO vo =boardService.read(bno);
		model.addAttribute("boardVO", vo);
		
		logger.info(c.getPage()+"페이지");
		logger.info(c.getNumsPerPage()+"펄페이지");
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public void update(int bno, Model model, @ModelAttribute("criteria") PageCriteria c){
		logger.info("update() 호출:bno"+bno);
		BoardVO vo =boardService.read(bno);
		model.addAttribute("boardVO", vo);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updatePOST(BoardVO vo,  PageCriteria c){
		logger.info("updatePOST(): bno="+vo.getBno());
		int result=boardService.update(vo);
		return "redirect:/board/list?page="+c.getPage()+"&perPage="+c.getNumsPerPage();
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(int bno){
		logger.info("delete() 호출 : bno="+bno);
		int result=boardService.delete(bno);
		return "redirect:/board/list";
	}

}
