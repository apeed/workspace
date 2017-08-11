package com.rongcheng_tech.cms.dao;
import java.util.List;

import com.rongcheng_tech.cms.entity.ItemInfo;
import com.rongcheng_tech.cms.entity.OrderInfo;
import com.rongcheng_tech.cms.entity.OrderItemLink;
import com.rongcheng_tech.cms.entity.UserInfo;

public interface OrderInfoDao {
	//分页查询
	 List<OrderInfo> findOrderInfoByPage(int start,int rows,Long ownerId);
	 String findOrderInfoCount(Long ownerId);
	 OrderInfo findByOrderInfoId(Long id,Long ownerId);
	//添加,修改,删除方法
	 int addOrderInfo(OrderInfo oi);
	 void addOrderItemLink(OrderItemLink oil);
	 int updateOrderInfo(OrderInfo oi);
	 int delOrderInfo(Long id,Long ownerId);
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
	 //通过id查找对象信息
	 ItemInfo findByItemInfoId(Long id,Long ownerId);
	 List<OrderItemLink> findOrderItemIds(Long orderId,Long ownerId);
	 
}