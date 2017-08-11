package test.AddressCarrierAllocation;

import java.math.BigInteger;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rongcheng.print.entity.CarrierInfo;
import com.rongcheng.print.service.AddressCarrierAllocation.AddressCarrierAllocationService;
import com.rongcheng.print.entity.AddressCarrierAllocation;


public class TestAddressCarrierAllocationService {
	private AddressCarrierAllocationService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mvc.xml",
				"conf/spring-mybatis.xml"};
		ApplicationContext context= new ClassPathXmlApplicationContext(conf);
	service=context.getBean("addressCarrierAllocationService",
			AddressCarrierAllocationService.class);
	}
	@Test 
	public void test01(){//findByRegionCode
		AddressCarrierAllocation list=service.findByRegionCode(new Integer("120000"));
		System.out.println(list);
	}
	@Test 
	public void test1(){//findRegionByPage
		List<AddressCarrierAllocation> list =service.findRegionByPage(0, 2);
		System.out.println(list);
	}
	@Test 
	public void test2(){//findRegionCount
		String n =service.findRegionCount();
		System.out.println(n);
	}
	
	@Test 
	public void test4(){//modifyRegionArea
		service.modifyRegionArea(new Integer("120000"), new BigInteger("19"),"9");
	}
	@Test 
	public void test5(){//modifyRegionList
		service.modifyRegionList(new Integer("1301"), new BigInteger("1"), "8");
	}
	
	@Test
	public void test7(){
		CarrierInfo n=service.findByRegionCarrierId(new BigInteger("20"));
		System.out.println(n);
	}
	
	@Test
	public void test9(){
		List<AddressCarrierAllocation> aca=service.findAddressCarrierAllocation("1305", "", new BigInteger("1"));
		System.out.println(aca.size());
	}
	
	@Test
	public void test10(){
		List<AddressCarrierAllocation> aca=service.findAddressCarrierAllocationArea("1305",new BigInteger("2"));
		System.out.println(aca.size());
	}
	@Test 
	public void test13(){//modifyRegionArea3
		String s="";
		service.modifyRegionArea3("13", "00", new BigInteger(s));
	}
	@Test 
	public void test14(){//modifyProvince
		service.modifyProvince(new Integer("130000"), new BigInteger("9"));
	}
	/*@Test
	public void test10(){
		List<AddressCarrierAllocation> aca=service.findAddressCarrierAllocationArea(new BigInteger("6"), new BigInteger("4"));
		System.out.println(aca);
	}*/
	/*@Test 
	public void test11(){//modifyRegionArea1
		service.modifyRegionArea1(new BigInteger("2"),new BigInteger("1"),"");
	}
	@Test 
	public void test12(){//modifyRegionArea2
		service.modifyRegionArea2(new BigInteger("2"), "55");
	}*/
	/*@Test
	public void test8(){
		int n=service.modifyRegionReserved1(new Double(2), "xxoo");
		System.out.println(n);
	}*/
	/*@Test 
	public void test6(){
		BigInteger[] d = {new BigInteger("3"),new BigInteger("4")};
		service.modifyRegions(d, new BigInteger("47"));
	}*/
}
