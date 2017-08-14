package com.globalexpress.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class CargoTracking implements Serializable{
	private static final long serialVersionUID = -8967178619823039499L;

	private Long id;//记录编号ID

    private Long orderId;//订单编号
    
    private String platformId;//电商平台
    
    private String shopId;//店铺名称

    private String carrierId;//物流公司名称
    
    private String carrierUrl;//物流公司网址

    private String trackingNum;//物流单号

    private Timestamp happenTime;//发生时间

    private String currentAddress;//订单当前所处地理位置

    private String terminalId;//订单当前到达站点名称
    
    private String staffId;//当前（到达站点）物流操作人名称

    private Long operatorId;//操作人

    private Long staffTel;//当前（到达站点）物流操作人电话

    private String cargoStatus;//物流状态

    private String facilityId;//运输工具编号

    private Integer complete;//物流是否完成

    private String nextAddress;//下一站（转运）地理位置

    private String nextTerminal;//下一站点名称

    private String transferCarrierId;//转运公司名称
    
    private String transferCarrierUrl;//转运公司网址

    private Long transferTrackingNum;//转运物流单号

    private String userTrackingInfo;//用户完全自定义物流记录

    private Integer show;//是否显示

    private String reserved1;//自定义内容

    private String note;//备注

    private Long ownerId;//用户主账户ID

    private Integer authorization;//该记录是否被授权

    private Integer apply;//该记录是否已被应用或调用

    private Timestamp gmtCreate;//记录创建时间

    private Timestamp gmtModified;//记录修改时间
    public CargoTracking() {
		// TODO Auto-generated constructor stub
	}
	
	public CargoTracking(Long id, Long orderId, String platformId, String shopId, String carrierId, String carrierUrl,
			String trackingNum, Timestamp happenTime, String currentAddress, String terminalId, String staffId,
			Long operatorId, Long staffTel, String cargoStatus, String facilityId, Integer complete,
			String nextAddress, String nextTerminal, String transferCarrierId, String transferCarrierUrl,
			Long transferTrackingNum, String userTrackingInfo, Integer show, String reserved1, String note,
			Long ownerId, Integer authorization, Integer apply, Timestamp gmtCreate, Timestamp gmtModified) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.platformId = platformId;
		this.shopId = shopId;
		this.carrierId = carrierId;
		this.carrierUrl = carrierUrl;
		this.trackingNum = trackingNum;
		this.happenTime = happenTime;
		this.currentAddress = currentAddress;
		this.terminalId = terminalId;
		this.staffId = staffId;
		this.operatorId = operatorId;
		this.staffTel = staffTel;
		this.cargoStatus = cargoStatus;
		this.facilityId = facilityId;
		this.complete = complete;
		this.nextAddress = nextAddress;
		this.nextTerminal = nextTerminal;
		this.transferCarrierId = transferCarrierId;
		this.transferCarrierUrl = transferCarrierUrl;
		this.transferTrackingNum = transferTrackingNum;
		this.userTrackingInfo = userTrackingInfo;
		this.show = show;
		this.reserved1 = reserved1;
		this.note = note;
		this.ownerId = ownerId;
		this.authorization = authorization;
		this.apply = apply;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getCarrierUrl() {
		return carrierUrl;
	}

	public void setCarrierUrl(String carrierUrl) {
		this.carrierUrl = carrierUrl;
	}

	public String getTrackingNum() {
		return trackingNum;
	}

	public void setTrackingNum(String trackingNum) {
		this.trackingNum = trackingNum;
	}

	public Timestamp getHappenTime() {
		return happenTime;
	}

	public void setHappenTime(Timestamp happenTime) {
		this.happenTime = happenTime;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getTerminalId() {
		return terminalId;
	}

	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public Long getStaffTel() {
		return staffTel;
	}

	public void setStaffTel(Long staffTel) {
		this.staffTel = staffTel;
	}

	public String getCargoStatus() {
		return cargoStatus;
	}

	public void setCargoStatus(String cargoStatus) {
		this.cargoStatus = cargoStatus;
	}

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public Integer getComplete() {
		return complete;
	}

	public void setComplete(Integer complete) {
		this.complete = complete;
	}

	public String getNextAddress() {
		return nextAddress;
	}

	public void setNextAddress(String nextAddress) {
		this.nextAddress = nextAddress;
	}

	public String getNextTerminal() {
		return nextTerminal;
	}

	public void setNextTerminal(String nextTerminal) {
		this.nextTerminal = nextTerminal;
	}

	public String getTransferCarrierId() {
		return transferCarrierId;
	}

	public void setTransferCarrierId(String transferCarrierId) {
		this.transferCarrierId = transferCarrierId;
	}

	public String getTransferCarrierUrl() {
		return transferCarrierUrl;
	}

	public void setTransferCarrierUrl(String transferCarrierUrl) {
		this.transferCarrierUrl = transferCarrierUrl;
	}

	public Long getTransferTrackingNum() {
		return transferTrackingNum;
	}

	public void setTransferTrackingNum(Long transferTrackingNum) {
		this.transferTrackingNum = transferTrackingNum;
	}

	public String getUserTrackingInfo() {
		return userTrackingInfo;
	}

	public void setUserTrackingInfo(String userTrackingInfo) {
		this.userTrackingInfo = userTrackingInfo;
	}

	public Integer getShow() {
		return show;
	}

	public void setShow(Integer show) {
		this.show = show;
	}

	public String getReserved1() {
		return reserved1;
	}

	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Integer authorization) {
		this.authorization = authorization;
	}

	public Integer getApply() {
		return apply;
	}

	public void setApply(Integer apply) {
		this.apply = apply;
	}

	public Timestamp getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Timestamp gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Timestamp getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Timestamp gmtModified) {
		this.gmtModified = gmtModified;
	}

	@Override
	public String toString() {
		return "CargoTracking [id=" + id + ", orderId=" + orderId + ", platformId=" + platformId + ", shopId=" + shopId
				+ ", carrierId=" + carrierId + ", carrierUrl=" + carrierUrl + ", trackingNum=" + trackingNum
				+ ", happenTime=" + happenTime + ", currentAddress=" + currentAddress + ", terminalId=" + terminalId
				+ ", staffId=" + staffId + ", operatorId=" + operatorId + ", staffTel=" + staffTel
				+ ", cargoStatus=" + cargoStatus + ", facilityId=" + facilityId + ", complete=" + complete
				+ ", nextAddress=" + nextAddress + ", nextTerminal=" + nextTerminal + ", transferCarrierId="
				+ transferCarrierId + ", transferCarrierUrl=" + transferCarrierUrl + ", transferTrackingNum="
				+ transferTrackingNum + ", userTrackingInfo=" + userTrackingInfo + ", show=" + show + ", reserved1="
				+ reserved1 + ", note=" + note + ", ownerId=" + ownerId + ", authorization=" + authorization
				+ ", apply=" + apply + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CargoTracking other = (CargoTracking) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
}