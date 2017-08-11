package com.rongcheng_tech.cms.dao;

import java.util.List;
import com.rongcheng_tech.cms.entity.ItemInfo;
import com.rongcheng_tech.cms.entity.UserInfo;
import com.rongcheng_tech.cms.entity.UserRemark;

public interface UserRemarkDao {
	//分页
	 List<UserRemark> findUserRemarkByPage(int start,int rows,Long ownerId);
	 List<UserRemark> findUserRemarkByPage1(int start,int rows,Long ownerId);
	 String findUserRemarkCount(Long ownerId);
	//增删改查
	 int modifyUserRemark(UserRemark ur);
	 int delUserRemark(Long id,Long ownerId);
	 int addUserRemark(UserRemark ur);
	 UserRemark findByUserRemarkId(Long id,Long ownerId);
	 List<UserRemark> findByUserRemarkAccount(String accountNum,Long ownerId,Long itemSku);//历史回复记录
	//查itemInfo表，通过 contentId,找到item_sku
	 ItemInfo findByItemInfoId(Long id,Long ownerId);
	 void addItemInfo(ItemInfo imf);
	//模糊查询
	 List<UserRemark> findListByUserRemark(String keyword,Long ownerId);
	//查询客服账号
	 List<UserInfo> getByOperatorId(Long id,Long ownerId);
}
