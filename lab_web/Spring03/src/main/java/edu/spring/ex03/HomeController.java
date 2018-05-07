package edu.spring.ex03;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.ex03.domain.ReplyVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// 내가 만드는 ㅂ메소드
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody  //이렇게하면 리턴값이 바디에 실려서 바로 클라이언트에게 전달이 된다//VIEW를 거치지 않는 것
	public String test(){
		return "test";
	}
	
	//내가만드는메소드2
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	@ResponseBody
	public ReplyVO test2(){
		ReplyVO vo=new ReplyVO(111,222,"테스트2메소드 중","한결이만세",new Date());
		
		return vo;//객체는 단지 주소값일 뿐이야 controller가 client에 전달할 때에는 문자열이 되어야만 함. ->Json됨
		
	}
	
}
