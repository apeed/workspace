package test.PrintTemplate;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.rongcheng.print.dao.PrintTemplateDao;
import com.rongcheng.print.entity.PrintTemplate;

public class TestPrintTemplateDao {
	@Test
	public void test1(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		PrintTemplateDao dao=
		context.getBean("printTemplateDao",PrintTemplateDao.class);
		List<PrintTemplate> pt=dao.findtemplateType(new BigInteger("3"));
		System.out.println(pt);
	}
	/*@Test
	public void test2(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		PrintTemplateDao dao=
		context.getBean("printTemplateDao",PrintTemplateDao.class);
		List<PrintTemplate> list=dao.findtemplateType(new BigInteger("8"));
		for (int i = 0; i < list.size(); i++) {
			Map<Object, Object> map = (Map<Object, Object>) list.get(i);
			for (Object key :  map.keySet()) {
				map.put("templateName", "菜鸟电子面单");
				map.put("templateType", "7");
				dao.modifyPrintTemplate(map);
		}
	}
}*/
}