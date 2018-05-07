package edu.spring.ex01;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; //아까test라이브러리 잘 추가해야만 import 됨
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)  
//JUnit 테스트를 위한 클래스라고 설정해줌 //매개변수의 저 클래스가 이걸 실행시켜줌(@Test 같은 거 찾아서부르는)

@WebAppConfiguration  //우리가 테스트할 메소드는 서버에서 실행되는 메소드 들임 //-> 웹 애플리케이션의 환경 설정 정보(예: web.xml)를 사용함
@ContextConfiguration  (locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})//'파일을 찾겠다(프로토콜)': 파일위치
												//spring폴더 밑에 xml 찾던가 spring 밑에 하위 폴더 아래 확장자가 xml인 파일 찾아라 하는 얘기 (대소문자 다 구별, 오타있으면 안돼)
	//애플리케이션(root-context.xml), 서블릿 컨택스트(servlet-context.xml) context환경설정 정보을 사용하겠다
public class ControllerTest {
//우리가 만드는 것은 서버가 실행시켜주는 클래스가 아니라
//아파치 톰캣의 스프링 프레임 워크가 가지고 있는 DispatcherSevlet이 (annotation을 찾아서) 실행시켜 주는 것(어떤 클래스에 의해 불리는 것)
	
	//@Inject :  Java에서 제공하는 DI annotation(스프링 아니라도 DI 쓸 수 있단 얘기)// Autowired(Spring에서의 DI기능)와 같은 기능
	@Autowired  //스프링 프레임 웤에게 객체를 생성해서 주입(injection)하라고 설정 //wiring(철사로 묶는것~)=>DI(의존성 주입)
	private WebApplicationContext wac;  //annotation에 의해 ControllerTest가 생성될 때 이미 wac는 (null이아니라) 주소값이 있는 상태가 됨
	
	// MVC 패턴의 앱을 테스트 하는 mockup 객체 ("모형" 이라는 뜻으로 실 제품이 나오기 전 모형을 만들어 보는 것을 mockup  //실제 크기의 모형으로다가)
	private MockMvc  mock;//mock:모조품
	
	private static final Logger logger= LoggerFactory.getLogger(ControllerTest.class);
	@Before //jnit의 것을 import해야함
	//실제 JUnit 테스트를 실행하기 전에 초기화 작업을 수행하는 메소드
	public void beforeTest(){
		logger.info("beforeTest() 호출");
		logger.info("wac : "+wac);  //얘가 널로 안나오고 주소값있는것을(객체생성되어있는것을) ㅂ확인할수 있(Autowired안주면 null)
		logger.info("mock : "+mock); //얜 널null~
		
		mock = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void testSample2() throws Exception{ //보통 여기만 만듬
		logger.info("testSample2() 호출");
		
		// MockMvc 객체를 사용해서 콘트롤러 메소드에게 GET 또는 POST 리퀘스트(요청)를 전달
		RequestBuilder req = MockMvcRequestBuilders.post("/test1")  //post방식으로 보낼 request를 만들겠다
												.param("username", "Admin"); //username에 Admin이라는 값을 줘서 리퀘스트에 실어 같이 보냄
					//=> post 방식으로 param보내서 test1() 메소드를 로그를 통해 test를 한것!(form만들지 않고도)

		mock.perform(req);

		
		
		req=MockMvcRequestBuilders.post("/test3").param("username", "한결이").param("age", "18");
		mock.perform(req);
		
	
	}
	
	@After
	//JUnit 테스트 수행 후 호출되는 메소드(필요한 경우에만 만들면 됨)
	public void afterTest(){
		logger.info("afterTest() 호출");
	}
	
	//이 파일에서 우클릭->Run as->JUnit test!!
}// end class ControllerTest
