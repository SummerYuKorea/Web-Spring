package edu.spring.ex04;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value="/test1", method=RequestMethod.GET) 
		//test1, test2 을 SampleInterceptor2 인터셉터에 매핑해놓음. servlet_context.xml에 설정해놓음
	public String test1(){
		logger.info("test1호출");
		return "test";
	}
	
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public String test2(Model model){
		logger.info("test2호출");
		model.addAttribute("data", "test2");
		return "test";
	}
	
}
