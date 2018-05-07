package job.spring.ex1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//private Map<String, String> map;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	@ResponseBody
	public String home(Locale locale, Model model, HttpServletRequest req) {
		//logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		System.out.println(formattedDate);
//		model.addAttribute("serverTime", formattedDate );
//		
//		logger.info(req.getHeader("x-device-token"));
//		logger.info(req.getMethod());
//		logger.info(req.getRequestURI());
//		logger.info(req.getAttribute("query")+"");
//		
		//logger.info(vo.getQuery().getUtter());
		/*if(vo==null)logger.info("널이야.....");
		else {
			logger.info(vo.toString());
			if(vo.getQuery()!=null){
				logger.info(vo.getQuery().getUtter()+"~~~");
			}else{
				logger.info("빔..");
			}
		}*/

		//logger.info(vo.toString());
		
		return "home";
	}
	
}
