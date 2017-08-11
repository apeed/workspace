package orderInfoTest;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng_tech.cms.dao.OrderInfoDao;
import com.rongcheng_tech.cms.dao.UserRemarkDao;
import com.rongcheng_tech.cms.entity.OrderItemLink;
import com.rongcheng_tech.cms.entity.UserRemark;

public class TestOrderInfoDao {
	@Test
	public void test1(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"config/springmvc.xml");
		OrderInfoDao dao=
		context.getBean("orderInfoDao",OrderInfoDao.class);
		OrderItemLink oil = new OrderItemLink();
		oil.setOrderId(new Long("1"));
		oil.setGmtCreate(new Date(System.currentTimeMillis()));
		oil.setOperatorId(new Long("1"));
		oil.setOrderId(new Long("1"));
		oil.setOrderItemId(new Long("1"));
		oil.setAuthorized(new Byte("1"));
		dao.addOrderItemLink(oil);
	}	
}