package com.rongcheng_tech.cms.service.CargoTracking;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.rongcheng_tech.cms.dao.CargoTrackingDao;
import com.rongcheng_tech.cms.entity.CargoTracking;
@Service("cargoTrackingService")
public class CargoTrackingServiceImpl implements CargoTrackingService {
	@Resource
	private CargoTrackingDao dao;//分页查询
	public List<CargoTracking> findCargoTrackingByPage(int start, int rows, Long ownerId) {
		List<CargoTracking> d1=dao.findCargoTrackingByPage(start, rows, ownerId);
		return d1;
	}
	//查询总条数
	public String findCargoTrackingCount(Long ownerId) {
		String c=dao.findCargoTrackingCount(ownerId);
		return c;
	}
	//通过Id查询此对象
	public CargoTracking findByCargoTrackingId(Long id, Long ownerId) {
		CargoTracking c=dao.findByCargoTrackingId(id, ownerId);
		return c;
	}
	//关键词分页查询 
	public List<CargoTracking> findListByCargoTracking(String keyword, Long ownerId) {
		List<CargoTracking> c=dao.findListByCargoTracking(keyword, ownerId);
		return c;
	}
	//添加内容，方法名建议(save前缀)
	public int addCargoTracking(Long ownerId, Timestamp gmtCreate, Long operatorId,String platformId,String shopId,String staffId, Long orderId,
			String carrierId, String carrierUrl, String trackingNum, Timestamp happenTime, String currentAddress,
			String terminalId, Long operatorTel, String cargoStatus, String facilityId, Integer complete,
			String nextAddress, String nextTerminal, String transferCarrierId, String transferCarrierUrl,
			Long transferTrackingNum, String userTrackingInfo, Integer show, String note) {
		CargoTracking ct = new CargoTracking();
		ct.setOwnerId(ownerId);
		ct.setGmtCreate(gmtCreate);
		ct.setOperatorId(operatorId);
		ct.setPlatformId(platformId);
		ct.setShopId(shopId);
		ct.setStaffId(staffId);
		ct.setOrderId(orderId);
		ct.setCarrierId(carrierId);
		ct.setCarrierUrl(carrierUrl);
		ct.setTrackingNum(trackingNum);
		ct.setHappenTime(happenTime);
		ct.setCurrentAddress(currentAddress);
		ct.setTerminalId(terminalId);
		ct.setOperatorTel(operatorTel);
		ct.setCargoStatus(cargoStatus);
		ct.setFacilityId(facilityId);
		ct.setComplete(complete);
		ct.setNextAddress(nextAddress);
		ct.setNextTerminal(nextTerminal);
		ct.setTransferCarrierId(transferCarrierId);
		ct.setTransferCarrierUrl(transferCarrierUrl);
		ct.setTransferTrackingNum(transferTrackingNum);
		ct.setUserTrackingInfo(userTrackingInfo);
		ct.setShow(show);
		ct.setNote(note);
		int c=dao.addCargoTracking(ct);
		return c;
	}
	//修改内容 
	public int modifyCargoTracking(Long id, Long ownerId, Long operatorId,String staffId, Timestamp gmtModified,
			String carrierId, String carrierUrl, String trackingNum, Timestamp happenTime,
			String currentAddress, String terminalId, Long operatorTel, String cargoStatus, String facilityId,
			Integer complete, String nextAddress, String nextTerminal, String transferCarrierId,
			String transferCarrierUrl, Long transferTrackingNum, String userTrackingInfo, Integer show,
			String note) {
		CargoTracking ct=dao.findByCargoTrackingId(id, ownerId);
		ct.setOperatorId(operatorId);
		ct.setStaffId(staffId);
		ct.setGmtModified(gmtModified);
		ct.setCarrierId(carrierId);
		ct.setCarrierUrl(carrierUrl);
		ct.setTrackingNum(trackingNum);
		ct.setHappenTime(happenTime);
		ct.setCurrentAddress(currentAddress);
		ct.setTerminalId(terminalId);
		ct.setOperatorTel(operatorTel);
		ct.setCargoStatus(cargoStatus);
		ct.setFacilityId(facilityId);
		ct.setComplete(complete);
		ct.setNextAddress(nextAddress);
		ct.setNextTerminal(nextTerminal);
		ct.setTransferCarrierId(transferCarrierId);
		ct.setTransferCarrierUrl(transferCarrierUrl);
		ct.setTransferTrackingNum(transferTrackingNum);
		ct.setUserTrackingInfo(userTrackingInfo);
		ct.setShow(show);
		ct.setNote(note);
		int c=dao.modifyCargoTracking(ct);
		return c;
	}

}
