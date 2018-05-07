package edu.spring.ex01;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class VOControllerTest {
	
	
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mock;
	private static final Logger logger=LoggerFactory.getLogger(VOControllerTest.class);
	
	@Before
	public void beforeTest(){
		mock=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	public void test() throws Exception{
		RequestBuilder req = MockMvcRequestBuilders.post("/product1").param("pname", "과잠").param("price", "30000");
		mock.perform(req);
		
		req= MockMvcRequestBuilders.post("/product2").param("pname", "과잠").param("price", "30000");
		mock.perform(req);
	}
	
	

}
