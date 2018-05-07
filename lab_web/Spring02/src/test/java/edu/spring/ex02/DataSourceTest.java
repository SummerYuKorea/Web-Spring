package edu.spring.ex02;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DataSourceTest {
	
	private static final Logger logger= LoggerFactory.getLogger(DataSourceTest.class);
	
	//spring framework이 관리하는 DataSource 객체를 주입받음
	@Autowired  //null이 아니라 spring에 의해 초기화되는!!(root-context.xml에서 bean으로 선언된 객체를 주입받음(걔랑 엮임))
	private DataSource ds;  //javax.sql.DataSource 형태!! 주입할 클래스는 oracle.jdbc.pool.OracleDataSource의 데이타소스임
									//둘이 상속관계래. 다형성을 이용해서 주입이 가능한.
	
	@Test
	public void testDataSource(){
		Connection conn=null;
		try {
			conn=ds.getConnection();
			logger.info("DataSource 연결 성공");
		} catch (SQLException e) {
			logger.error("DataSource 연결 실패: "+e.getMessage());
		}finally {
			try {
				conn.close();
				logger.info("DataSource 반환 성공");
			} catch (SQLException e) {
				logger.error("DataSource 반환 실패: "+e.getMessage());
				
			}
		}
	}

}
