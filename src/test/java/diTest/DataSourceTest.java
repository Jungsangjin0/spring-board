package diTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataSourceTest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory factory;
	
	@Autowired
	SqlSession sqlSession;
	
	
	private static final Logger log = LoggerFactory.getLogger(DataSourceTest.class);
	
	
	@Test
	public void dataSourceDITest() {
		try {
			Connection con = dataSource.getConnection();
			log.info("con : {}", con);
			assertNotNull(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("dataSource : {}", dataSource);
		log.info("factory : {}", factory);
		log.info("sqlSession : {}", sqlSession);
		
	}
}
