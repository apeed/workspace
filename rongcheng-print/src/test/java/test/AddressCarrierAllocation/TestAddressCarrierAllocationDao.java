package test.AddressCarrierAllocation;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.print.entity.CarrierInfo;
import com.rongcheng.print.dao.AddressCarrierAllocationDao;
import com.rongcheng.print.entity.AddressCarrierAllocation;

public class TestAddressCarrierAllocationDao {
	@Test
	public void test1(){//findByRegion
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AddressCarrierAllocationDao dao=
		context.getBean("addressCarrierAllocationDao",AddressCarrierAllocationDao.class);
		List<Map<Object, Object>> list=dao.findByRegion(3);
		System.out.println(list);
	}
	@Test
	public void test2(){//findRegionByPage
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AddressCarrierAllocationDao dao=
		context.getBean("addressCarrierAllocationDao",AddressCarrierAllocationDao.class);
		List<AddressCarrierAllocation> list=dao.findRegionByPage(0, 2);
		System.out.println(list);
	}
	@Test
	public void test3(){//findRegionCount
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AddressCarrierAllocationDao dao=
		context.getBean("addressCarrierAllocationDao",AddressCarrierAllocationDao.class);
		String s=dao.findRegionCount();
		System.out.println(s);
	}
	@Test
	public void test4(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AddressCarrierAllocationDao dao=
		context.getBean("addressCarrierAllocationDao",AddressCarrierAllocationDao.class);
		AddressCarrierAllocation r=dao.findByRegionCode(new Integer("120000"));
		r.setReserved1("cc");
		int n=dao.modifyRegionArea(r);
		System.out.println(r);
		System.out.println(n);
	}
	@Test
	public void test5(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AddressCarrierAllocationDao dao=
		context.getBean("addressCarrierAllocationDao",AddressCarrierAllocationDao.class);
		AddressCarrierAllocation n=dao.findByRegionCode(new Integer("120000"));
		System.out.println(n);
	}
	@Test
	public void test6(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AddressCarrierAllocationDao dao=
		context.getBean("addressCarrierAllocationDao",AddressCarrierAllocationDao.class);
		List<Map<Object, Object>> list=dao.findByRegion(4);//向下找
//		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			Map<Object, Object> map = list.get(i);//
			for (Object key :  map.keySet()) {
				map.put("carrierId", "18");
				dao.modifyRegionList(map);
				List<Map<Object, Object>> list1=dao.findByRegion(map.get(key));
				for (int j = 0; j < list1.size(); j++) {
					Map<Object, Object> map1 = list1.get(j);
					map1.put("carrierId", "18");
					dao.modifyRegionList(map1);
				}
			}   
		}
	}
	@Test
	public void test7(){//del
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AddressCarrierAllocationDao dao=
		context.getBean("addressCarrierAllocationDao",AddressCarrierAllocationDao.class);
	int n=dao.delProvice(new BigInteger("1"));
	System.out.println(n);
	}
	@Test
	public void test8(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AddressCarrierAllocationDao dao=
		context.getBean("addressCarrierAllocationDao",AddressCarrierAllocationDao.class);
		CarrierInfo r=dao.findByRegionCarrierId(new BigInteger("20"));
	System.out.println(r);
	}
	@Test
	public void test9(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AddressCarrierAllocationDao dao=
		context.getBean("addressCarrierAllocationDao",AddressCarrierAllocationDao.class);
		List<AddressCarrierAllocation> r=dao.findAddressCarrierAllocationArea("1305", 2);
	System.out.println(r);
	}
	@Test
	public void test10(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AddressCarrierAllocationDao dao=
		context.getBean("addressCarrierAllocationDao",AddressCarrierAllocationDao.class);
		List<AddressCarrierAllocation> n=dao.findByRegionName1("桥西区");
		System.out.println(n);
	}
	@Test
	public void test11(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AddressCarrierAllocationDao dao=
		context.getBean("addressCarrierAllocationDao",AddressCarrierAllocationDao.class);
		List<Map<Object, Object>> n=dao.findListByRegionCode(new Integer("130"));
		System.out.println(n);
	}
	@Test
	public void test12(){
		ApplicationContext context=
				new ClassPathXmlApplicationContext(
						"conf/spring-mybatis.xml");
		AddressCarrierAllocationDao dao=
		context.getBean("addressCarrierAllocationDao",AddressCarrierAllocationDao.class);
		AddressCarrierAllocation n=dao.findCityByRegionCode("1102","00");
		System.out.println(n);
	}
	
}
