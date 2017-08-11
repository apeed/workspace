package com.rongcheng.print.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

public class PlatformErpLink implements Serializable{
	private static final long serialVersionUID = -5371694839096413288L;
private BigInteger id;
private BigInteger platformId;
private BigInteger platformItemSku;
private BigInteger itemId;
private BigInteger ownerId;
private BigInteger shopId;
private Timestamp gmtCreate;
private Timestamp gmtModified;
private Boolean authorized;
private BigInteger operatorId;
private String note;
public PlatformErpLink() {
	
}
public PlatformErpLink(BigInteger id, BigInteger platformId, BigInteger platformItemSku, BigInteger itemId,
		BigInteger ownerId, BigInteger shopId, Timestamp gmtCreate, Timestamp gmtModified, Boolean authorized,
		BigInteger operatorId, String note) {
	super();
	this.id = id;
	this.platformId = platformId;
	this.platformItemSku = platformItemSku;
	this.itemId = itemId;
	this.ownerId = ownerId;
	this.shopId = shopId;
	this.gmtCreate = gmtCreate;
	this.gmtModified = gmtModified;
	this.authorized = authorized;
	this.operatorId = operatorId;
	this.note = note;
}
public BigInteger getId() {
	return id;
}

public void setId(BigInteger id) {
	this.id = id;
}

public BigInteger getPlatformId() {
	return platformId;
}

public void setPlatformId(BigInteger platformId) {
	this.platformId = platformId;
}

public BigInteger getPlatformItemSku() {
	return platformItemSku;
}

public void setPlatformItemSku(BigInteger platformItemSku) {
	this.platformItemSku = platformItemSku;
}

public BigInteger getItemId() {
	return itemId;
}

public void setItemId(BigInteger itemId) {
	this.itemId = itemId;
}

public BigInteger getOwnerId() {
	return ownerId;
}

public void setOwnerId(BigInteger ownerId) {
	this.ownerId = ownerId;
}

public BigInteger getShopId() {
	return shopId;
}

public void setShopId(BigInteger shopId) {
	this.shopId = shopId;
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

public Boolean getAuthorized() {
	return authorized;
}

public void setAuthorized(Boolean authorized) {
	this.authorized = authorized;
}

public BigInteger getOperatorId() {
	return operatorId;
}

public void setOperatorId(BigInteger operatorId) {
	this.operatorId = operatorId;
}

public String getNote() {
	return note;
}

public void setNote(String note) {
	this.note = note;
}

@Override
public String toString() {
	return "PlatformErpLink [id=" + id + ", platformId=" + platformId + ", platformItemSku=" + platformItemSku
			+ ", itemId=" + itemId + ", ownerId=" + ownerId + ", shopId=" + shopId + ", gmtCreate=" + gmtCreate
			+ ", gmtModified=" + gmtModified + ", authorized=" + authorized + ", operatorId=" + operatorId + ", note="
			+ note + "]";
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
	PlatformErpLink other = (PlatformErpLink) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


}
