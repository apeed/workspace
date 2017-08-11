package StatementNotice;

import java.sql.Timestamp;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.rongcheng_tech.cms.service.StatementNotice.StatementNoticeService;

public class TestStatementService {
	private StatementNoticeService service;
	@Before
	public void init(){
		String[] conf={"config/springmvc.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("statementNoticeService",
				StatementNoticeService.class);
	}
	@Test
	public void test1(){
		service.updateStatementNotice1(new Long("7"), new Long("1"), new Long("1"), new Timestamp(System.currentTimeMillis()), "0");
	}
}
