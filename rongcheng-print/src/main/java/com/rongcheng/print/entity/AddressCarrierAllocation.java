package com.rongcheng.print.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

public class AddressCarrierAllocation implements Serializable{
	private static final long serialVersionUID = -3916838437807095608L;
	private BigInteger regionId;//地区ID
	private Integer regionCode;//行政区划代码
	private String regionName;//地区名称
	private BigInteger parentId;//父项（上级）ID
	private Boolean regionLevel;//地区等级
	private BigInteger regionOrder;//地区顺序？
	private String regionNameEn;//地区英文名
	private String regionShort;//地区缩写
	private BigInteger carrierId;//分配的快递公司
	private BigDecimal headFee;//首重运费
	private BigDecimal repeatFee;//续重运费
	private String reserved1;//自定义内容1
	private String note;//备注
	private BigInteger ownerId;//用户主账户ID
	private BigInteger operatorId;//操作人
	private Boolean isAuthorized;//该记录是否被授权
	private Timestamp gmtCreate;//记录创建时间
	private Timestamp gmtModified;//记录修改时间
	public AddressCarrierAllocation() {
		// TODO Auto-generated constructor stub
	}
	public AddressCarrierAllocation(BigInteger regionId, Integer regionCode, String regionName, BigInteger parentId,
			Boolean regionLevel, BigInteger regionOrder, String regionNameEn, String regionShort, BigInteger carrierId,
			BigDecimal headFee, BigDecimal repeatFee, String reserved1, String note, BigInteger ownerId,
			BigInteger operatorId, Boolean isAuthorized, Timestamp gmtCreate, Timestamp gmtModified) {
		super();
		this.regionId = regionId;
		this.regionCode = regionCode;
		this.regionName = regionName;
		this.parentId = parentId;
		this.regionLevel = regionLevel;
		this.regionOrder = regionOrder;
		this.regionNameEn = regionNameEn;
		this.regionShort = regionShort;
		this.carrierId = carrierId;
		this.headFee = headFee;
		this.repeatFee = repeatFee;
		this.reserved1 = reserved1;
		this.note = note;
		this.ownerId = ownerId;
		this.operatorId = operatorId;
		this.isAuthorized = isAuthorized;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
	}
	public BigInteger getRegionId() {
		return regionId;
	}
	public void setRegionId(BigInteger regionId) {
		this.regionId = regionId;
	}
	public Integer getRegionCode() {
		return regionCode;
	}
	public void setRegionCode(Integer regionCode) {
		this.regionCode = regionCode;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public BigInteger getParentId() {
		return parentId;
	}
	public void setParentId(BigInteger parentId) {
		this.parentId = parentId;
	}
	public Boolean getRegionLevel() {
		return regionLevel;
	}
	public void setRegionLevel(Boolean regionLevel) {
		this.regionLevel = regionLevel;
	}
	public BigInteger getRegionOrder() {
		return regionOrder;
	}
	public void setRegionOrder(BigInteger regionOrder) {
		this.regionOrder = regionOrder;
	}
	public String getRegionNameEn() {
		return regionNameEn;
	}
	public void setRegionNameEn(String regionNameEn) {
		this.regionNameEn = regionNameEn;
	}
	public String getRegionShort() {
		return regionShort;
	}
	public void setRegionShort(String regionShort) {
		this.regionShort = regionShort;
	}
	public BigInteger getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(BigInteger carrierId) {
		this.carrierId = carrierId;
	}
	public BigDecimal getHeadFee() {
		return headFee;
	}
	public void setHeadFee(BigDecimal headFee) {
		this.headFee = headFee;
	}
	public BigDecimal getRepeatFee() {
		return repeatFee;
	}
	public void setRepeatFee(BigDecimal repeatFee) {
		this.repeatFee = repeatFee;
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
	public BigInteger getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(BigInteger ownerId) {
		this.ownerId = ownerId;
	}
	public BigInteger getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(BigInteger operatorId) {
		this.operatorId = operatorId;
	}
	public Boolean getIsAuthorized() {
		return isAuthorized;
	}
	public void setIsAuthorized(Boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
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
		return "AddressCarrierAllocation [regionId=" + regionId + ", regionCode=" + regionCode + ", regionName="
				+ regionName + ", parentId=" + parentId + ", regionLevel=" + regionLevel + ", regionOrder="
				+ regionOrder + ", regionNameEn=" + regionNameEn + ", regionShort=" + regionShort + ", carrierId="
				+ carrierId + ", headFee=" + headFee + ", repeatFee=" + repeatFee + ", reserved1=" + reserved1
				+ ", note=" + note + ", ownerId=" + ownerId + ", operatorId=" + operatorId + ", isAuthorized="
				+ isAuthorized + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regionCode == null) ? 0 : regionCode.hashCode());
		result = prime * result + ((regionId == null) ? 0 : regionId.hashCode());
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
		AddressCarrierAllocation other = (AddressCarrierAllocation) obj;
		if (regionCode == null) {
			if (other.regionCode != null)
				return false;
		} else if (!regionCode.equals(other.regionCode))
			return false;
		if (regionId == null) {
			if (other.regionId != null)
				return false;
		} else if (!regionId.equals(other.regionId))
			return false;
		return true;
	}
	
}
