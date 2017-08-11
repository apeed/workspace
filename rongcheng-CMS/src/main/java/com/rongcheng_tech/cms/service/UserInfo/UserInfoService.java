package com.rongcheng_tech.cms.service.UserInfo;

import java.sql.Date;
import java.util.List;
import com.rongcheng_tech.cms.entity.UserInfo;

public interface UserInfoService {
	//分页
	 List<UserInfo> findUserInfoByPage(int start,int rows,Long ownerId);
	 String findUserInfoCount(Long ownerId);	
	 //修改增加查询方法 
	 UserInfo findByUserInfoId(Long id,Long ownerId);
	 int modifyUserInfo(Long id,Long ownerId,String userPassword,String accountEmail,String userNickname,String userName,String userTelephone,
			String userMobile,String userAddress,Byte accountStatus,String userQuestion1,String userAnswer1,String userQuestion2,String userAnswer2,String userQuestion3,String userAnswer3,
			Long operatorId,Date gmtModified,String note);
	 int addUserInfo(Long ownerId,Date gmtCreate,Long operatorId,String accountNum,String userPassword,String accountEmail,String userNickname,
			String userName,String userTelephone,String userMobile,String userAddress,Byte accountStatus,String userQuestion1,String userAnswer1,String userQuestion2,String userAnswer2,String userQuestion3,String userAnswer3,String note,Byte userType);
	 int delUserInfo(Long id,Long ownerId);
	 void delUserInfoList(Long[] id,Long ownerId);
	 int modifyUserInfo1(Long id,Long ownerId,String userName,String userTelephone,String userAddress,Long operatorId,Date gmtModified,String note);
	 int addUserInfo1(Long ownerId,Date gmtCreate,Long operatorId,String userName,String userTelephone,String userAddress,String note);
	 //分页
	 List<UserInfo> findListByUserInfo(String keyword,Long ownerId);
	 List<UserInfo> findListsByUserInfo(String keyword,Long ownerId);
	 //查询所有的用户
	 List<UserInfo> getAccountNum(String keyword,Long ownerId);
	 UserInfo findByAccountNum(String accountNum,Long ownerId);//通过用户账号查找
}
