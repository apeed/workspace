package com.rongcheng.print.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rongcheng.print.entity.CarrierInfo;
import com.rongcheng.print.entity.PrintTemplate;
import com.rongcheng.print.service.AddressCarrierAllocation.AddressCarrierAllocationService;
import com.rongcheng.print.entity.AddressCarrierAllocation;
import com.rongcheng.print.utils.JsonResult;

@Controller
public class AddressCarrierAllocationController {
	private int rows=6;
	@Resource
	private AddressCarrierAllocationService service;
	@RequestMapping("/ExpressPartition.do")
	public String toSort(){
		return "ExpressPartition";
	}
	//根据页码检索商品信息
		@RequestMapping("/loadList_region.do")
		@ResponseBody
		public JsonResult loadRegion(String page) {
			return loadRegions(page);
		}
		
		//根据页码检索
		public JsonResult loadRegions(String page) {
			int max_page = (int) Math.ceil(new Double(service.findRegionCount())/rows);
			if(max_page == 0){
				return new JsonResult();
			}
			List<AddressCarrierAllocation> AddressCarrierAllocation=service.findRegionByPage(new Integer(page)*rows-rows,rows);
			JsonResult jr = new JsonResult(AddressCarrierAllocation);
			jr.setMessage(max_page+"");
			return jr;
		}
		@RequestMapping("/load_region.do")
		@ResponseBody
		public JsonResult findByRegionCity(BigInteger parentId) {
			List<Map<Object, Object>> list=service.findByRegionArea(parentId);
			return new JsonResult(list);
		}
		@RequestMapping("/modifyRegionArea.do")
		@ResponseBody
		public JsonResult modifyRegionArea(Integer regionCode,BigInteger carrierId,String reserved1) {
			service.modifyRegionArea(regionCode, carrierId,reserved1);
			return new JsonResult();
		}
		@RequestMapping("/modifyProvince.do")
		@ResponseBody
		public JsonResult modifyProvince(Integer regionCode,BigInteger carrierId) {
			service.modifyProvince(regionCode, carrierId);
			return new JsonResult();
		}
		@RequestMapping("/modify_regionList.do")//改市区
		@ResponseBody
		public JsonResult modifyRegionList(Integer regionCode, BigInteger carrierId, String reserved1) {
			service.modifyRegionList(regionCode, carrierId, reserved1);
			return new JsonResult();
		}
		@RequestMapping("/modify_regions.do")
		@ResponseBody
		public JsonResult modifyRegions(Integer[] rc1, BigInteger sort) {
			System.out.println(rc1[0]+","+sort);
			service.modifyRegions(rc1, sort);
			return new JsonResult();
		}
		@RequestMapping("/find_CarrierInfoName.do")
		@ResponseBody
		public JsonResult findByRegionCarrierId(BigInteger carrierId) {
			CarrierInfo ci=service.findByRegionCarrierId(carrierId);
			return new JsonResult(ci);
		}
		
		@RequestMapping("/findByRegionCode.do")
		@ResponseBody
		public JsonResult findByRegionCode(Integer regionCode) {
			AddressCarrierAllocation aca=service.findByRegionCode(regionCode);
			return new JsonResult(aca);
		}
		@RequestMapping("/findAddressCarrierAllocation.do")
		@ResponseBody
		public JsonResult findAddressCarrierAllocation(String i, String j, BigInteger carrierId) {
//			System.out.println(i+","+j+","+carrierId);
			List<AddressCarrierAllocation> aca=service.findAddressCarrierAllocation(i, j, carrierId);
//			System.out.println(aca.size());
			return new JsonResult(aca);
		}
		/*@RequestMapping("/findAddressCarrierAllocation1.do")
		@ResponseBody
		public JsonResult findAddressCarrierAllocation1(String i,String j, BigInteger carrierId) {
			System.out.println(i+","+carrierId);
			List<AddressCarrierAllocation> aca=service.findAddressCarrierAllocation(i, "", carrierId);
			System.out.println(aca.size());
			return new JsonResult(aca);
		}*/
		
		@RequestMapping("/modifyRegionArea1.do")//单个删除
		@ResponseBody
		public JsonResult modifyRegionArea1(Integer regionCode,BigInteger carrierId,String reserved1) {
			service.modifyRegionArea1(regionCode, carrierId, reserved1);
			return new JsonResult();
		}
		@RequestMapping("/modifyRegionArea2.do")
		@ResponseBody
		public JsonResult modifyRegionArea2(Integer regionCode, String reserved1) {
		service.modifyRegionArea2(regionCode, reserved1);
		return new JsonResult();
		}
		@RequestMapping("/modifyRegionArea3.do")//删除子集
		@ResponseBody
		public JsonResult modifyRegionArea3(String i, String j,BigInteger carrierId) {
			service.modifyRegionArea3(i, j, carrierId);
			return new JsonResult();
		}
		//加载
		@RequestMapping("/findByRegionName.do")
		@ResponseBody
		public JsonResult  findByRegionName(String regionName) {
			AddressCarrierAllocation n=service.findByRegionName(regionName);
			return new JsonResult(n);
		}
		@RequestMapping("/findByRegionName1.do")
		@ResponseBody
		public JsonResult  findByRegionName1(String regionName) {
			List<AddressCarrierAllocation> list=service.findByRegionName1(regionName);
			return new JsonResult(list);
		}
		@RequestMapping("/modifyRegionCity.do")
		@ResponseBody
		public JsonResult  modifyRegionCity(Integer regionCode, BigInteger carrierId, String reserved1) {
			service.modifyRegionCity(regionCode, carrierId, reserved1);
			return new JsonResult();
		}
		@RequestMapping("/findAddressCarrierAllocationArea.do")
		@ResponseBody
		public JsonResult  findAddressCarrierAllocationArea(String i, BigInteger carrierId) {
			System.out.println(i+","+carrierId);
			List<AddressCarrierAllocation> list=service.findAddressCarrierAllocationArea(i, carrierId);
			return new JsonResult(list);
		}
		@RequestMapping("/modifyRegionCity1.do")
		@ResponseBody
		public JsonResult  modifyRegionCity1(String i, String j,BigInteger carrierId, String reserved1) {
			service.modifyRegionCity1(i, j, carrierId, reserved1);
			return new JsonResult();
		}
		
		/*@RequestMapping("/delProvice_region.do")
		@ResponseBody
		public JsonResult delProvice(BigInteger regionId) {
			int n=service.delProvice(regionId);
			return new JsonResult(n);
		}*/
		/*@RequestMapping("/mod_reserved1.do")
		@ResponseBody
		public JsonResult modifyRegionReserved1(BigInteger regionId,String reserved1) {
			int n=service.modifyRegionReserved1(regionId, reserved1);
			return new JsonResult(n);
		}*/
		/*@RequestMapping("/mod_reserved1.do")
		@ResponseBody
		public JsonResult modifyRegionReserved1(BigInteger regionId,String reserved1) {
			int n=service.modifyRegionReserved1(regionId, reserved1);
			return new JsonResult(n);
		}*/
}
