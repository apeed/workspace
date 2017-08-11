package test.PrintTemplate;

import java.math.BigInteger;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.rongcheng.print.entity.PrintTemplate;
import com.rongcheng.print.service.PrintTemplate.PrintTemplateService;

public class TestPrintTemplateService {
	private PrintTemplateService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context= new ClassPathXmlApplicationContext(conf);
	service=context.getBean("printTemplateService",
			PrintTemplateService.class);
	}
	@Test 
	public void test1(){
		List<PrintTemplate> pt=service.findtemplateType(new BigInteger("2"));
		System.out.println(pt);
	}
	
}
