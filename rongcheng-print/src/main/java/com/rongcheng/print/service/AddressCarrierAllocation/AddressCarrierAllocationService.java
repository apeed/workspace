package com.rongcheng.print.service.AddressCarrierAllocation;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.rongcheng.print.entity.CarrierInfo;
import com.rongcheng.print.entity.AddressCarrierAllocation;

public interface AddressCarrierAllocationService {
	public AddressCarrierAllocation findByRegionCode(Integer regionCode);
	public List<AddressCarrierAllocation> findRegionByPage(int start,int rows);//分页
	public String findRegionCount();
	public void modifyRegionArea(Integer regionCode,BigInteger carrierId,String reserved1);//改区
	public void modifyRegionList(Integer regionCode,BigInteger carrierId,String reserved1);//改市区
	public void modifyRegionCity(Integer regionCode,BigInteger carrierId,String reserved1);////改市区
	public void modifyRegionCity1(String i, String j,BigInteger carrierId,String reserved1);
	public List<AddressCarrierAllocation> findAddressCarrierAllocation(String i, String j, BigInteger carrierId);
	public void modifyRegionArea2(Integer regionCode,String reserved1);//快递模板选择，修改省份
	public void modifyRegionArea1(Integer regionCode,BigInteger carrierId,String reserved1);//做删除用
	public void modifyRegionArea3(String i, String j,BigInteger carrierId);//做删除省份用
	public void modifyProvince(Integer regionCode,BigInteger carrierId);//省选择快递
	public void modifyRegions(Integer[] rc1,BigInteger carrierId);
	public List<AddressCarrierAllocation> findAddressCarrierAllocationArea(String i, BigInteger carrierId);//模糊查找区
//----分割线----	
	public List<Map<Object, Object>> findByRegionArea(BigInteger parentId);
//	public void modifyRegionList1(BigInteger parentId,BigInteger carrierId);
	public int delProvice(BigInteger regionId);
	public CarrierInfo findByRegionCarrierId(BigInteger carrierId);
//	public List<AddressCarrierAllocation> findAddressCarrierAllocationArea(BigInteger carrierId,BigInteger regionId);
	public AddressCarrierAllocation findByRegionName(String regionName);
	public List<AddressCarrierAllocation> findByRegionName1(String regionName);
}
