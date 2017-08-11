package com.globalexpress.web.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderItemLink implements Serializable{
	private static final long serialVersionUID = 9203978392746001655L;

	private Long id;

	private Long orderId;

	private Long orderItemId;

	private Integer quantity;

	private String reserved1;

	private String note;

	private Long ownerId;
	
	private Long operatorId;

	private Byte authorized;

	private Date gmtCreate;

	private Date gmtModified;
	public OrderItemLink() {
	
	}
	public OrderItemLink(Long id, Long orderId, Long orderItemId, Integer quantity, String reserved1, String note,
			Long ownerId, Long operatorId, Byte authorized, Date gmtCreate, Date gmtModified) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.reserved1 = reserved1;
		this.note = note;
		this.ownerId = ownerId;
		this.operatorId = operatorId;
		this.authorized = authorized;
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
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public Byte getAuthorized() {
		return authorized;
	}
	public void setAuthorized(Byte authorized) {
		this.authorized = authorized;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	@Override
	public String toString() {
		return "OrderItemLink [id=" + id + ", orderId=" + orderId + ", orderItemId=" + orderItemId + ", quantity="
				+ quantity + ", reserved1=" + reserved1 + ", note=" + note + ", ownerId=" + ownerId + ", operatorId="
				+ operatorId + ", authorized=" + authorized + ", gmtCreate=" + gmtCreate + ", gmtModified="
				+ gmtModified + "]";
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
		OrderItemLink other = (OrderItemLink) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}