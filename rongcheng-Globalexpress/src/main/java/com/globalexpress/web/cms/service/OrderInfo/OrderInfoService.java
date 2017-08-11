package com.globalexpress.web.cms.service.OrderInfo;

import java.util.Date;
import java.util.List;

import com.globalexpress.web.entity.ItemInfo;
import com.globalexpress.web.entity.OrderInfo;
import com.globalexpress.web.entity.OrderItemLink;
import com.globalexpress.web.entity.UserInfo;

public interface OrderInfoService {
	 //分页
	 List<OrderInfo> findOrderInfoByPage(int start,int rows,Long ownerId);
	 String findOrderInfoCount(Long ownerId);//增加页面使用商品
	//添加,修改,删除方法
	 int addOrderInfo(Long ownerId,Date gmtCreate,Long operatorId,Long orderNum,String consignorId,String consigneeId,Long consigneeTel,String consigneeAddress,String orderLabel,String carrierId,Long trackingNum,Integer packageWeight,Integer totalShippingFee,String orderKeyword,Integer supportValue,String note,Byte orderType);
	 void addOrderItemLink(Long ownerId,Date gmtCreate,Long operatorId,Long orderId,Long[] orderItemId,Byte authorized,Integer[] quantity);
	 int updateOrderInfo(Long id,Long ownerId,Long operatorId,Date gmtModified,String consignorId,String consigneeId,Long consigneeTel,String consigneeAddress,String orderLabel,String carrierId,Long trackingNum,Integer packageWeight,Integer totalShippingFee,String note,String orderKeyword,Integer supportValue);
	 OrderInfo findByOrderInfoId(Long id,Long ownerId);
	 void delOrderInfo(Long id,Long ownerId);
	 void delOrderInfoList(Long[] id,Long ownerId);
	 int delOrderItemLink(Long orderItemId,Long ownerId);
	//模糊查询
	 List<OrderInfo> findListByOrderInfo(String keyword,Long ownerId);
//	 List<OrderInfo> findListByOrderInfo1(String keyword,Long ownerId);
	 /**
	  * 分页搜索商品
	  */
	 List<ItemInfo> findItemInfoByPage(int start,int rows,Long ownerId);
	 String findItemInfoCount(Long ownerId);
	//模糊查询商品
	List<ItemInfo> findListByItemInfo(String keyword,Long ownerId);
	//查找发件人
	List<UserInfo> findUserInfoList(Long ownerId);
	//根据订单状态查询
	List<OrderInfo> findListByOrderType(Long ownerId,Byte orderType);
	//修改备注
	int updateOrderInfo(Long id,Long ownerId,Long operatorId,Date gmtModified,String note);
	//修改发货
	int updateOrderInfo(Long id,Long ownerId,Long operatorId,Date gmtModified,String carrierId,Long trackingNum);
	//修改退款
	int updateOrderInfo(Long id,Long ownerId,Long operatorId,Date gmtModified,Byte refundCompleted,Date refundComplete,Byte orderType);
	//通过订单编号查询
	List<OrderItemLink> findOrderItemIds(Long orderId,Long ownerId);
	//通过id查找对象信息
	ItemInfo findByItemInfoId(Long id,Long ownerId);
	//查找所有的订单编号
	List<OrderInfo> findOrderNums(Long ownerId);
}