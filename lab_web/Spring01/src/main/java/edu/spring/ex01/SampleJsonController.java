package edu.spring.ex01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.ex01.domain.ProductVO;

@Controller
public class SampleJsonController {
	
	private static final Logger logger=LoggerFactory.getLogger(SampleJsonController.class);
	
	@RequestMapping(value="/json1")
	public String testJson1(){
		logger.info("testJson1() 호출");
		return "sample1";   //스프링 프레임 웤이 리턴 값으로 jsp를 찾음
	}
	
	@RequestMapping(value="/json2")
	@ResponseBody public String testJson2(){  //이렇게 annotation줘서 보내면 sample1 이라고만 딱 나옴(sample1.jsp로 이동x)
		logger.info("testJson2() 호출");
		return "sample1한결이만세";   // 이 값을 그냥 response에 넣어버림 (알아서 html생성->개발자도구보삼)//응답이 여기서 나감 
		//한글은안되겠지~  //얘자체를 response body에 넣어서 browser까지 전달해줘라 (바로 클라이언트에게 전달해줘라)
		
		
		// @ResponseBody:
		// 콘트롤러 메소드가 리턴하는 값을 응답(response) body에 실어서 보내주라는 설정
		// JSP(View)를 거치지 않고 바로 클라이언트에 전달됨
	}//testJson2
	
	@RequestMapping(value="json3")
	@ResponseBody public ProductVO testJson3(){
		logger.info("testJson3() 호출");
		
		return new ProductVO("축구공",35000);  //일케하면 에러남.왜냐면 ~ response는 다 문자열이잖아-> Json으로 보내야지!
		// json으로 변환하는 방법을 써서(Gson을 이용하거나) 할 수도 있겠지만
		//근데 라이브러리 하나 추가하는 것만으로 객체를 자동으로 json형태로 하여 넘길수 있다는..솨실 oh		
	}
	
	//jackson-databind   //굉장히 유명한 라이브러리 중 하나// object를 json으로! 
	// 일종의 필터 역할을 하는 request, response에 관여// 이 안에있는 라이브러리 메소드를 호출을 해서 gson으로 넘겨준다 (알아서!)
	//(search.maven.org 에서 찾기) //최신인 2.8.8쓰겠다!
	// pom.xml에 추가후(dependency를 추가 (dependencies안에 추가 해야지)// 프로젝트우클릭->Maven->update project!
	// 한다음에 바로 F5만 해보면 json형태로 result가 나오는 것을 볼수있
	
	//pom.xml을 건드릴 때는 약간 긴장
	// library를 웹에서 받아오는 것이기 때문에 폴더에 다운로드가 될 때 문제가 생길 소지가 있다.
	// 나도 서버가 아예 안켜졌음. 그럴 땐 이클립스를 끄고 .m2 폴더 가서 fasterxml? 폴더를 통째로 지움(방금 받은 라이브러리)
	// 그리고 다시 maven->update project를 하면 다시 받아올 수 있다.  그러니까 잘됨!☆
	
}
