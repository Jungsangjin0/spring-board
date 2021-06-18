package selectTest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.js.board.model.dto.BoardDTO;
import com.js.board.model.dto.BoardDTO2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SelectListTest {

	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	Logger log = LoggerFactory.getLogger(SelectListTest.class);
	
	@Test
	public void test() {
//		List<BoardDTO> list = sqlSession.selectList("board.selectList");
		List<BoardDTO2> list = sqlSession.selectList("board.selectList");
		log.info("list : {}", list);
	}
	
}
