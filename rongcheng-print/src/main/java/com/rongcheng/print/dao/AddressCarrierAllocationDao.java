package com.rongcheng.print.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.rongcheng.print.entity.CarrierInfo;
import com.rongcheng.print.entity.AddressCarrierAllocation;

public interface AddressCarrierAllocationDao {
	public AddressCarrierAllocation findByRegionCode(Integer regionCode);
	public List<AddressCarrierAllocation> findRegionByPage(int start,int rows);
	public String findRegionCount();
	public int modifyRegionArea(AddressCarrierAllocation rn);//修改
	public List<Map<Object, Object>> findListByRegionCode(Integer regionCode);
	public void modifyRegionList(Map<Object, Object> map);
	public void modifyRegionList1(Map<Object, Object> map);
	public List<AddressCarrierAllocation> findAddressCarrierAllocation(Object i, Object j, Object carrierId);//模糊查找市
	public List<AddressCarrierAllocation> findAddressCarrierAllocationArea(Object i, Object carrierId);//模糊查找区
	public List<AddressCarrierAllocation> findAddressCarrierAllocation1(Object i, Object j);
	public AddressCarrierAllocation findCityByRegionCode(Object i, Object j);
	//---分割---

	public List<Map<Object, Object>> findByRegion(Object parentId);
	public List<Map<Object, Object>> findByRegionArea(Object parentId);
	public int delProvice(BigInteger regionId);//不用
	public CarrierInfo findByRegionCarrierId(BigInteger carrierId);
	public AddressCarrierAllocation findByRegionName(String regionName);
	public List<AddressCarrierAllocation> findByRegionName1(String regionName);
}
