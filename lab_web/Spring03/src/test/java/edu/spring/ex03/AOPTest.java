package edu.spring.ex03;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.ex03.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)  //test를 어디서 돌릴거냐
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class AOPTest {

	@Autowired
	private CustomerService customerService;
	
	@Test
	public void doTest(){
		try {
			customerService.createCustomer();  
			//해당 메소드를 호출했는데 @before 어노된 메소드도 불리는 것을 확인
			//createCustomer 메소드에서 Exception을 던지지 않았을 때는 afterReturning이 호출되는데 (before->after->afterReturning)
			// Exception 던지니까 (예외가 있으니까 정상적으로 끝나지 않았단 얘기) returning이 안불리는 것을 로그로 확인
			// (before->after->afterThrowing)
			
		} catch (Exception e) {
		} 
		
		customerService.deleteCustomer();
		LoggerFactory.getLogger(AOPTest.class).info("===============================");
	
		try {
			customerService.updateCustomer();
		} catch (Exception e) {
		}
	}
}
