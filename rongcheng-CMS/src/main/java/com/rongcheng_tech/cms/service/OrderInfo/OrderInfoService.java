package com.rongcheng_tech.cms.service.OrderInfo;
import java.sql.Date;
import java.util.List;
import com.rongcheng_tech.cms.entity.ItemInfo;
import com.rongcheng_tech.cms.entity.OrderInfo;
import com.rongcheng_tech.cms.entity.OrderItemLink;
import com.rongcheng_tech.cms.entity.UserInfo;

public interface OrderInfoService {
	 //分页
	 List<OrderInfo> findOrderInfoByPage(int start,int rows,Long ownerId);
	 String findOrderInfoCount(Long ownerId);
	//添加,修改,删除方法
	 int addOrderInfo(Long ownerId,Date gmtCreate,Long operatorId,Long orderNum,String consignorId,String consigneeId,Long consigneeTel,String consigneeAddress,String orderLabel,String carrierId,Long trackingNum,Integer packageWeight,Integer totalShippingFee,String orderKeyword,Integer supportValue,String note,Byte orderType);
	 void addOrderItemLink(Long ownerId,Date gmtCreate,Long operatorId,Long orderId,Long[] orderItemId,Byte authorized);
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
}