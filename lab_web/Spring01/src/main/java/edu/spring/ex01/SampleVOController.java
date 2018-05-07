package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.spring.ex01.domain.ProductVO;

@Controller  //나는 컨트롤럽니당// Spring Framework한테 등록~
public class SampleVOController {

	private static final Logger logger = LoggerFactory.getLogger(SampleVOController.class);
	
	@RequestMapping(
			value="/product1")
	public String testProduct1(Model model , String pname, int price){ 
		//얘는 자동으로 Integer.parseInt(request.getParameter("price")) 이거 해주는 건데 
		//만약에 url에 query string으로 값안주면 pname은 null이 되어도 상관 없지만 price는 parseInt(null) 이 되어 버려서 500에러 발생
		// 내부적으로 getParameter해서 parseInt까지 해주는 것을 확인할 수 있지
		logger.info("testProduct1() 호출:  pname->"+pname+"//  price-> "+price);
		ProductVO vo =new ProductVO(pname, price);
		model.addAttribute("product",vo);  //객체는 parameter에 못넣지 attribute 이용이 필요해~~
		
		return "product-result";
	}//testProduct1
	
	@RequestMapping(
			value="product2")
	public String testProduct2(@ModelAttribute("product") ProductVO vo){  
			//query String에 pname= &price= 로 넘기면 알아서 setter메소드로 넘기는 것  (ProductVO의 디폴트생성자호출후 setter로 set)
		
		logger.info("testProduct2() 호출:  pname="+vo.getPname()+"//  price= "+vo.getPrice());
		
		return "product-result";
	}
}
