package com.rongcheng.print.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

public class WarehouseInfo implements Serializable{
	private static final long serialVersionUID = 3006302476296196611L;
private BigInteger id;
private String name;
private String position;
private String shelfCode;
private String consignorName;
private String consignorTel;
private String consignorMobile;
private BigInteger regionId;
private String userAddress;
private String note;
private BigInteger ownerId;
private BigInteger operatorId;
private Boolean authorized;
private Timestamp gmtCreate;
private Timestamp gmtModified;
public WarehouseInfo() {
	
}

public WarehouseInfo(BigInteger id, String name, String position, String shelfCode, String consignorName,
		String consignorTel, String consignorMobile, BigInteger regionId, String userAddress, String note,
		BigInteger ownerId, BigInteger operatorId, Boolean authorized, Timestamp gmtCreate, Timestamp gmtModified) {
	super();
	this.id = id;
	this.name = name;
	this.position = position;
	this.shelfCode = shelfCode;
	this.consignorName = consignorName;
	this.consignorTel = consignorTel;
	this.consignorMobile = consignorMobile;
	this.regionId = regionId;
	this.userAddress = userAddress;
	this.note = note;
	this.ownerId = ownerId;
	this.operatorId = operatorId;
	this.authorized = authorized;
	this.gmtCreate = gmtCreate;
	this.gmtModified = gmtModified;
}

public BigInteger getId() {
	return id;
}

public void setId(BigInteger id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPosition() {
	return position;
}

public void setPosition(String position) {
	this.position = position;
}

public String getShelfCode() {
	return shelfCode;
}

public void setShelfCode(String shelfCode) {
	this.shelfCode = shelfCode;
}

public String getConsignorName() {
	return consignorName;
}

public void setConsignorName(String consignorName) {
	this.consignorName = consignorName;
}

public String getConsignorTel() {
	return consignorTel;
}

public void setConsignorTel(String consignorTel) {
	this.consignorTel = consignorTel;
}

public String getConsignorMobile() {
	return consignorMobile;
}

public void setConsignorMobile(String consignorMobile) {
	this.consignorMobile = consignorMobile;
}

public BigInteger getRegionId() {
	return regionId;
}

public void setRegionId(BigInteger regionId) {
	this.regionId = regionId;
}

public String getUserAddress() {
	return userAddress;
}

public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
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

public Boolean getAuthorized() {
	return authorized;
}

public void setAuthorized(Boolean authorized) {
	this.authorized = authorized;
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
	return "WarehouseInfo [id=" + id + ", name=" + name + ", position=" + position + ", shelfCode=" + shelfCode
			+ ", consignorName=" + consignorName + ", consignorTel=" + consignorTel + ", consignorMobile="
			+ consignorMobile + ", regionId=" + regionId + ", userAddress=" + userAddress + ", note=" + note
			+ ", ownerId=" + ownerId + ", operatorId=" + operatorId + ", authorized=" + authorized + ", gmtCreate="
			+ gmtCreate + ", gmtModified=" + gmtModified + "]";
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
	WarehouseInfo other = (WarehouseInfo) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}



}
