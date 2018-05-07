package edu.spring.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import oracle.jdbc.OracleDriver;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class OracleJDBCTest {

//	@Autowired
//	private WebApplicationContext wac;
//	
//	private MockMvc mock;
	
	private static final Logger logger =LoggerFactory.getLogger(OracleJDBCTest.class);
	
	private static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER="scott";
	private static final String PASSWORD="tiger";
	
//	@Before
//	public void beforeTest(){
//		mock=MockMvcBuilders.webAppContextSetup(wac).build();
//	}
	
	@Test
	public void testOracleConnect(){
//		RequestBuilder req= MockMvcRequestBuilders.post("").param(name, values);
//		mock.perform(req);
		
		Connection conn=null;
		 try {
			 
			 // JDBC 라이브러리를 로드
			DriverManager.registerDriver(new OracleDriver());  
					//oracle공식문서 가보면 짧은거 import(oracle.jdbc.OracleDriver)해서 사용하라고함
			
			// Connection 설정
			conn =DriverManager.getConnection(URL, USER, PASSWORD);
			logger.info("Oracle 연결 성공");
		} catch (SQLException e) {
			logger.info("oracle 연결 실패: "+e.getMessage());
		} finally {
			try {
				conn.close();
				logger.info("Oracle 연결 해제 성공");
			} catch (SQLException e) {
				logger.info("Oracle 연결 해제 실패: "+e.getMessage());
			}
		}
	}
}
