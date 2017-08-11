package itemInfoTest;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng_tech.cms.entity.ItemInfo;
import com.rongcheng_tech.cms.service.ItemInfo.ItemInfoService;

public class TestItemInfoService {
	private ItemInfoService service;
	@Before
	public void init(){
		String[] conf={"config/springmvc.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("itemInfoService",
				ItemInfoService.class);
	}
	@Test
	public void test1(){
		List<ItemInfo> s=service.getItemSku("6", new Long(2));
		System.out.println(s);
	}
}
