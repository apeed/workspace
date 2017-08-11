package com.rongcheng.print.service.AddressCarrierAllocation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.rongcheng.print.entity.CarrierInfo;
import com.rongcheng.print.dao.AddressCarrierAllocationDao;
import com.rongcheng.print.entity.AddressCarrierAllocation;
@Service("addressCarrierAllocationService")
public class AddressCarrierAllocationServiceImpl implements AddressCarrierAllocationService {
	@Resource
	private AddressCarrierAllocationDao dao;

	public List<AddressCarrierAllocation> findRegionByPage(int start, int rows) {
		List<AddressCarrierAllocation> list = dao.findRegionByPage(start, rows);
		return list;
	}

	public String findRegionCount() {
		String s=dao.findRegionCount();
		return s;
	}
//	public List<Map<Object, Object>> findByRegion(BigInteger parentId) {
//		List<Map<Object, Object>> list=dao.findByRegion(parentId);
//		return list;
//	}

	/*public List<Region> findByRegionArea(BigInteger regionId) {
		List<Region> list=dao.findByRegionArea(regionId);
		return list;
	}*/
	public void modifyRegionArea(Integer regionCode,BigInteger carrierId,String reserved1) {//改区
		AddressCarrierAllocation r=dao.findByRegionCode(regionCode);
		r.setReserved1(reserved1);
		r.setCarrierId(carrierId);
		dao.modifyRegionArea(r);
	}
//-----------分割线------------
	
	/*public void modifyRegionList1(BigInteger parentId, BigInteger carrierId) {//可能作删除
		AddressCarrierAllocation reg=dao.findByRegionId(parentId);
		reg.setCarrierId(carrierId);
		dao.modifyRegionArea(reg);
		List<Map<Object, Object>> list=dao.findByRegion(parentId);
		for (int i = 0; i < list.size(); i++) {
			Map<Object, Object> map = list.get(i);
			
			for (Object key :  map.keySet()) {
				map.put("carrierId", carrierId);
				dao.modifyRegionList(map);
				List<Map<Object, Object>> list1=dao.findByRegion(map.get(key));
				for (int j = 0; j < list1.size(); j++) {
					Map<Object, Object> map1 = list1.get(j);
					map1.put("carrierId", carrierId);
					dao.modifyRegionList(map1);
				}
			}      
		}
		
	}*/

	public int delProvice(BigInteger regionId) {
		int n =dao.delProvice(regionId);
		return n;
	}

	/*public void modifyRegions(BigInteger[] parentId, BigInteger carrierId) {
		for(int k=0;k<parentId.length;k++){
			AddressCarrierAllocation reg=dao.findByRegionId(parentId[k]);
			reg.setCarrierId(carrierId);
			dao.modifyRegionArea(reg);
			List<Map<Object, Object>> list=dao.findByRegion(parentId[k]);
			for (int i = 0; i < list.size(); i++) {
				Map<Object, Object> map = list.get(i);
				map.put("carrierId", carrierId);
				dao.modifyRegionList(map);
				for (Object key :  map.keySet()) {
					List<Map<Object, Object>> list1=dao.findByRegion(map.get(key));
					for (int j = 0; j < list1.size(); j++) {
						Map<Object, Object> map1 = list1.get(j);
						map1.put("carrierId", carrierId);
						dao.modifyRegionList(map1);
					}
				}      
			}
		}
	}*/
	public CarrierInfo findByRegionCarrierId(BigInteger carrierId) {
		CarrierInfo r=dao.findByRegionCarrierId(carrierId);
		return r;
	}

	public List<Map<Object, Object>> findByRegionArea(BigInteger parentId) {
		List<Map<Object, Object>> list=dao.findByRegionArea(parentId);
		return list;
	}
	public void modifyRegions(Integer[] rc1, BigInteger carrierId) {
		for(int k=0;k<rc1.length;k++){
			AddressCarrierAllocation r=dao.findByRegionCode(rc1[k]);
			r.setCarrierId(carrierId);
			dao.modifyRegionArea(r);
		}
	}
	
	public AddressCarrierAllocation findByRegionCode(Integer regionCode) {
		AddressCarrierAllocation aca=dao.findByRegionCode(regionCode);
		return aca;
	}


//先注掉
	/*public List<AddressCarrierAllocation> findAddressCarrierAllocationArea(BigInteger carrierId, BigInteger regionId) {
		List<AddressCarrierAllocation> aca = new ArrayList<AddressCarrierAllocation>();
		List<Map<Object, Object>> list=dao.findByRegion(regionId);
		for (int i = 0; i < list.size(); i++) {
			Map<Object, Object> map = list.get(i);
			for (Object key :  map.keySet()) {
//				System.out.println(list.get(i).get("regionId"));
//				List<Map<Object, Object>> list1=dao.findByRegion(map.get("regionId"));
				aca=dao.findAddressCarrierAllocation(carrierId, map.get("regionId"));
				for (int j = 0; j < list1.size(); j++) {
					Map<Object, Object> map1 = list1.get(j);
					for (Object key1 :  map1.keySet()) {
						
						
//						System.out.println(aca);
					}
				}
			}
		}
		return aca;
}*/

	

	
	public void modifyRegionArea1(Integer regionCode,BigInteger carrierId,String reserved1) {
		AddressCarrierAllocation r=dao.findByRegionCode(regionCode);
		r.setCarrierId(carrierId);
		r.setReserved1(reserved1);
		dao.modifyRegionArea(r);
	}
	public void modifyRegionArea2(Integer regionCode, String reserved1) {
		AddressCarrierAllocation r=dao.findByRegionCode(regionCode);
		r.setReserved1(reserved1);
		dao.modifyRegionArea(r);
	}
	public void modifyRegionArea3(String i, String j, BigInteger carrierId) {//删除子集（省以下）
		List<AddressCarrierAllocation> list=dao.findAddressCarrierAllocation1(i, j);
	for (int k = 0; k < list.size()-1; k++) {
		Map<Object, Object> map = (Map<Object, Object>) list.get(k+1);
			map.put("carrierId", carrierId);
			dao.modifyRegionList1(map);
	}
}
	public void modifyProvince(Integer regionCode, BigInteger carrierId) {
		AddressCarrierAllocation r=dao.findByRegionCode(regionCode);
		r.setCarrierId(carrierId);
		dao.modifyRegionArea(r);
	}

	

	public AddressCarrierAllocation findByRegionName(String regionName) {
		AddressCarrierAllocation n=dao.findByRegionName(regionName);
		return n;
	}

	public List<AddressCarrierAllocation> findByRegionName1(String regionName) {
		List<AddressCarrierAllocation> list = dao.findByRegionName1(regionName);
		return list;
	}

	public void modifyRegionList(Integer regionCode, BigInteger carrierId, String reserved1) {
		List<Map<Object, Object>> list=dao.findListByRegionCode(regionCode);
		for (int i = 0; i < list.size(); i++) {
			Map<Object, Object> map = list.get(i);
				map.put("carrierId", carrierId);
				map.put("reserved1", reserved1);
				dao.modifyRegionList(map);
		}
	}
	public List<AddressCarrierAllocation> findAddressCarrierAllocation(String i, String j, BigInteger carrierId) {
		List<AddressCarrierAllocation> r=dao.findAddressCarrierAllocation(i, j, carrierId);
//		System.out.println(r.size()+"****");
//		for(int k=0;k<r.size();k++){
//			if(k==0){
//				r.remove(k);	
//			}
//		}
		return r;
	}
	

	public void modifyRegionCity(Integer regionCode, BigInteger carrierId, String reserved1) {
		AddressCarrierAllocation r=dao.findByRegionCode(regionCode);
		r.setCarrierId(carrierId);
		r.setReserved1(reserved1);
		dao.modifyRegionArea(r);
	}

	public List<AddressCarrierAllocation> findAddressCarrierAllocationArea(String i, BigInteger carrierId) {
		List<AddressCarrierAllocation> r=dao.findAddressCarrierAllocationArea(i, carrierId);
		for(int k=0;k<r.size();k++){
			if(k==0){
				r.remove(k);	
			}
		}
		return r;
	}
	
	

	public void modifyRegionCity1(String i, String j,BigInteger carrierId, String reserved1) {
		AddressCarrierAllocation aca=dao.findCityByRegionCode(i, j);
		aca.setCarrierId(carrierId);
		aca.setReserved1(reserved1);
		dao.modifyRegionArea(aca);
	}
	/*public void modifyRegionCityList(Integer regionCode, BigInteger carrierId, String reserved1) {
	List<Map<Object, Object>> list=dao.findCityListByRegionCode(regionCode);
	for (int i = 0; i < list.size(); i++) {
		Map<Object, Object> map = list.get(i);
			map.put("carrierId", carrierId);
			map.put("reserved1", reserved1);
			dao.modifyRegionList(map);
	}
}*/
	/*public int modifyRegionReserved1(BigInteger regionId,String reserved1) {
	AddressCarrierAllocation aca=dao.findByRegionId(regionId);
	aca.setReserved1(reserved1);
	int n=dao.modifyRegionArea(aca);
	return n;
}*/
	/*public AddressCarrierAllocation findByPid(String regionName) {
	AddressCarrierAllocation n=dao.findByRegionName(regionName);
	BigInteger b=n.getRegionId();
	List<Map<Object, Object>> list=dao.findByRegionArea(b);
	for (int i = 0; i < list.size(); i++) {
		Map<Object, Object> map = list.get(i);
	return null;
}*/
//public List<AddressCarrierAllocation> findAddressCarrierAllocationArea(BigInteger carrierId, BigInteger regionId) {
//	// TODO Auto-generated method stub
//	return null;
//}
/*public void modifyRegionList1(BigInteger parentId, BigInteger carrierId,String reserved1) {
AddressCarrierAllocation reg=dao.findByRegionId(parentId);
reg.setCarrierId(carrierId);
dao.modifyRegionArea(reg);
List<Map<Object, Object>> list=dao.findByRegion(parentId);
for (int i = 0; i < list.size(); i++) {
	Map<Object, Object> map = list.get(i);
	for (Object key :  map.keySet()) {
		map.put("carrierId", carrierId);
		map.put("reserved1", reserved1);
		dao.modifyRegionList(map);
	}      
}

}*/

	


}