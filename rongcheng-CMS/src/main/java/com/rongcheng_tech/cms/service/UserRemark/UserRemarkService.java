package com.rongcheng_tech.cms.service.UserRemark;

import java.sql.Date;
import java.util.List;

import com.rongcheng_tech.cms.entity.ItemInfo;
import com.rongcheng_tech.cms.entity.UserInfo;
import com.rongcheng_tech.cms.entity.UserRemark;


public interface UserRemarkService {
	 //分页
	 List<UserRemark> findUserRemarkByPage(int start,int rows,Long ownerId);
	 List<UserRemark> findUserRemarkByPage1(int start,int rows,Long ownerId);
	 String findUserRemarkCount(Long ownerId);
	 //查询删除修改增加
	 UserRemark findByUserRemarkId(Long id,Long ownerId);
	 void delUserRemark(Long id,Long ownerId);
	 void delUserRemarkList(Long[] id,Long ownerId);
	 void modifyUserRemark(Long id,Long ownerId,String adminReply,String note,Boolean show,Integer userSequence,Long operatorId,Date gmtModified);
	 ItemInfo findByItemInfoId(Long id,Long ownerId);
	 int addUserRemark(Long ownerId,Date gmtCreate,String userAccount,Long userId,
			String userWord,Date userWordTime,Integer userSequence,Integer remarkType,Boolean show,String note,Byte contentType,Long contentId);
	//批量修改
	 void modifyUserRemarks(Long[] id,Long ownerId,Boolean show);
	 void updateUserRemarks(Long[] id,Long ownerId,Boolean reply);
	 void modifyUserRemark1(Long id,Long ownerId,String adminReply,Date replyTime,Long operatorId,Date gmtModified,Boolean reply);
	 //查询历史回复
	 List<UserRemark> findByUserRemarkAccount(String accountNum,Long ownerId,Long itemSku);//回复
	 //分页
	 List<UserRemark> findListByUserRemark(String keyword,Long ownerId);
	//查询客服账号
	 List<UserInfo> getByOperatorId(Long id,Long ownerId);
	 
}