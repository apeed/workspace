package com.rongcheng_tech.cms.service.CargoTracking;

import java.sql.Timestamp;
import java.util.List;
import com.rongcheng_tech.cms.entity.CargoTracking;

public interface CargoTrackingService {
	//分页
	 List<CargoTracking> findCargoTrackingByPage(int start,int rows,Long ownerId);
	 String findCargoTrackingCount(Long ownerId);
	 CargoTracking findByCargoTrackingId(Long id,Long ownerId);
	//模糊查询
	 List<CargoTracking> findListByCargoTracking(String keyword,Long ownerId);
	 //增加修改方法
	 int addCargoTracking(Long ownerId,Timestamp gmtCreate,Long operatorId,String platformId,String shopId,String staffId,Long orderId,String carrierId,String carrierUrl,String trackingNum,Timestamp happenTime,String currentAddress,String  terminalId,Long  operatorTel,String cargoStatus,String facilityId,Integer complete,String nextAddress,String nextTerminal,String transferCarrierId,String transferCarrierUrl,Long transferTrackingNum,String userTrackingInfo,Integer show,String note);
	 int modifyCargoTracking(Long id,Long ownerId,Long operatorId,String staffId,Timestamp gmtModified,String carrierId,String carrierUrl,String trackingNum,Timestamp happenTime,String currentAddress,String  terminalId,Long  operatorTel,String cargoStatus,String facilityId,Integer complete,String nextAddress,String nextTerminal,String transferCarrierId,String transferCarrierUrl,Long transferTrackingNum,String userTrackingInfo,Integer show,String note);
}
