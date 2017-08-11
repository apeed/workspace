package com.rongcheng_tech.cms.controller;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.rongcheng_tech.cms.entity.CargoTracking;
import com.rongcheng_tech.cms.entity.UserInfo;
import com.rongcheng_tech.cms.service.CargoTracking.CargoTrackingService;
import com.rongcheng_tech.cms.utils.JsonResult;
@Controller
public class CargoTrackingController {
	private int rows=20;
	@Value("#{sysconfig['ownerId']}")
	private Long ownerId;
	@Resource
	private CargoTrackingService service;
	
	@RequestMapping("/logistics.do")
	public String toLogistics(){
		return "logistics";
	}
	@RequestMapping("/logisticsPublic.do")
	public String logisticsPublic(){
		return "logisticsPublic";
	}
	@RequestMapping("/logisticsAdd.do")
	public String logisticsAdd(){
		return "logisticsAdd";
	}
	//根据页码检索商品信息
		@RequestMapping("/loadList_logistics.do")
		@ResponseBody
		public JsonResult loadCargoTracking(HttpSession session,String page) {
			return loadCargoTrackings(session,page);
		}
		//根据页码检索
		public JsonResult loadCargoTrackings(HttpSession session,String page) {
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			int max_page = (int) Math.ceil(new Double(service.findCargoTrackingCount(ownerId))/rows);
			if(max_page == 0){
				return new JsonResult();
			}
			List<CargoTracking> UserInfo=service.findCargoTrackingByPage(new Integer(page)*rows-rows,rows,ownerId);
			JsonResult jr = new JsonResult(UserInfo);
			jr.setMessage(max_page+"");
			return jr;
		}
		//加载修改数据
		@RequestMapping("/load_modify_cargoTracking.do")
		@ResponseBody
		public JsonResult findByUserInfoId(HttpSession session,Long id){
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			CargoTracking sn=service.findByCargoTrackingId(id, ownerId);
			return new JsonResult(sn);
		}
		//修改内容
		@RequestMapping("/modify_cargoTracking.do")
		@ResponseBody
		public JsonResult modifyCargoTracking(Long id,HttpSession session,String staffId,String carrierId,String carrierUrl,String trackingNum,String happenTime,String currentAddress,String  terminalId,Long  operatorTel,String cargoStatus,String facilityId,Integer complete,String nextAddress,String nextTerminal,String transferCarrierId,String transferCarrierUrl,Long transferTrackingNum,String userTrackingInfo,Integer show,String note){
//			System.out.println(id+","+operatorId+","+orderId+","+carrierId+","+carrierUrl+","+trackingNum+","+happenTime+","+currentAddress+","+terminalId+","+operatorTel+","+cargoStatus+","+facilityId+","+complete+","+nextAddress+","+nextTerminal+","+transferCarrierId+","+transferCarrierUrl+","+transferTrackingNum+","+userTrackingInfo+","+show+","+note);
//			SimpleDateFormat dateFm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); //格式化当前系统日期
			Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
//			System.out.println(operatorId);
			Timestamp ts = new Timestamp(System.currentTimeMillis());   
			if(happenTime!=null&&happenTime.length()<=16){
				ts = Timestamp.valueOf(happenTime+":00"); 
			}else if(happenTime.length()>16){
				ts = Timestamp.valueOf(happenTime); 
			}
			Timestamp tamp = new Timestamp(System.currentTimeMillis());
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		int n=service.modifyCargoTracking(id, ownerId, operatorId, staffId,tamp, carrierId, carrierUrl, trackingNum, ts, currentAddress, terminalId, operatorTel, cargoStatus, facilityId, complete, nextAddress, nextTerminal, transferCarrierId, transferCarrierUrl, transferTrackingNum, userTrackingInfo, show, note);
		return new JsonResult(n);
		}
		//添加物流
		@RequestMapping("/add_cargoTracking.do")
		@ResponseBody
		public JsonResult addCargoTracking(HttpSession session,String platformId,String shopId,String staffId,Long orderId,String carrierId,String carrierUrl,String trackingNum,String happenTime,String currentAddress,String  terminalId,Long  operatorTel,String cargoStatus,String facilityId,Integer complete,String nextAddress,String nextTerminal,String transferCarrierId,String transferCarrierUrl,Long transferTrackingNum,String userTrackingInfo,Integer show,String note){
			Long operatorId = ((UserInfo)(session.getAttribute("user"))).getId();
//			System.out.println(operatorId+""+orderId+carrierId+carrierUrl+trackingNum+happenTime+currentAddress+terminalId+operatorTel+cargoStatus+facilityId+complete+nextAddress+nextTerminal+transferCarrierId+transferCarrierUrl+transferTrackingNum+userTrackingInfo+show+note);
		Timestamp ts = new Timestamp(System.currentTimeMillis());   
		if(happenTime!=""){
			ts = Timestamp.valueOf(happenTime+":00"); 
		}
		Timestamp tamp = new Timestamp(System.currentTimeMillis());
		Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
		int n=service.addCargoTracking(ownerId, tamp, operatorId,platformId,shopId,staffId, orderId, carrierId, carrierUrl, trackingNum, ts, currentAddress, terminalId, operatorTel, cargoStatus, facilityId, complete, nextAddress, nextTerminal, transferCarrierId, transferCarrierUrl, transferTrackingNum, userTrackingInfo, show, note);
		return new JsonResult(n);
		}
		@RequestMapping("/findListByCargoTracking.do")//模糊查询
		@ResponseBody
		public JsonResult findListByCargoTracking(HttpSession session,String keyword) {
			Long ownerId = ((UserInfo)(session.getAttribute("user"))).getOwnerId();
			List<CargoTracking> list=service.findListByCargoTracking(keyword, ownerId);
			return new JsonResult(list);
		}
}
