package orderInfoTest;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng_tech.cms.entity.ItemInfo;
import com.rongcheng_tech.cms.entity.UserInfo;
import com.rongcheng_tech.cms.service.OrderInfo.OrderInfoService;

public class TestOrderInfoService {
	private OrderInfoService service;
	@Before
	public void init(){
		String[] conf={"config/springmvc.xml"};
		ApplicationContext context
			= new ClassPathXmlApplicationContext(conf);
		service=context.getBean("orderInfoService",
				OrderInfoService.class);
	}
	@Test
	public void test1(){
		List<ItemInfo> s=service.findItemInfoByPage(0, 3, new Long(1));
		System.out.println(s);
	}
	@Test
	public void test2(){
		List<ItemInfo> s=service.findListByItemInfo("a", new Long(1));	
		System.out.println(s);
	}
	@Test
	public void test3(){
		List<UserInfo> s=service.findUserInfoList(new Long(1));
		System.out.println(s);
	}
	@Test
	public void test4(){
		Long[] lon = {new Long(1),new Long(2)};
		service.addOrderItemLink(new Long(2), new Date(System.currentTimeMillis()), new Long(1), new Long(1), lon, new Byte("1"));
	}
	@Test
	public void test5(){
		int s=service.updateOrderInfo(new Long(4), new Long(1), new Long(2), new Date(System.currentTimeMillis()), "hahh");
		System.out.println(s);
	}
}
