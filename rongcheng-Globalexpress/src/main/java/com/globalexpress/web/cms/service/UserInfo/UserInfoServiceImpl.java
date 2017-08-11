package com.globalexpress.web.cms.service.UserInfo;

import java.sql.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.globalexpress.web.cms.dao.UserInfoDao;
import com.globalexpress.web.entity.UserInfo;
@Service("userService")
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
	private UserInfoDao dao;//分页查询 
	public List<UserInfo> findUserInfoByPage(int start, int rows, Long ownerId) {
		List<UserInfo> d1=dao.findUserInfoByPage(start, rows, ownerId);
		return d1;
	}
	//查询总条数
	public String findUserInfoCount(Long ownerId) {
		String c1=dao.findUserInfoCount(ownerId);
		return c1;
	}
	//发件人
	public List<UserInfo> findUserInfoByPage1(int start, int rows, Long ownerId) {
		List<UserInfo> d1=dao.findUserInfoByPage1(start, rows, ownerId);
		return d1;
	}
	public String findUserInfoCount1(Long ownerId) {
		String c1=dao.findUserInfoCount1(ownerId);
		return c1;
	}

	//通过id查询对象
	public UserInfo findByUserInfoId(Long id, Long ownerId) {
		UserInfo sn=dao.findByUserInfoId(id, ownerId);
		return sn;
	}
	//修改方法
	public int modifyUserInfo(Long id, Long ownerId,String userPassword,
			String accountEmail, String userNickname, String userName, String userTelephone, String userMobile,
			String userAddress, Byte accountStatus, String userQuestion1, String userAnswer1, String userQuestion2,
			String userAnswer2, String userQuestion3, String userAnswer3, Long operatorId, Date gmtModified,
			String note) {
		UserInfo sn=dao.findByUserInfoId(id, ownerId);
		sn.setUserPassword(userPassword);
		sn.setAccountEmail(accountEmail);
		sn.setUserNickname(userNickname);
		sn.setUserName(userName);
		sn.setUserTelephone(userTelephone);
		sn.setUserMobile(userMobile);
		sn.setUserAddress(userAddress);
		sn.setAccountStatus(accountStatus);
		sn.setUserQuestion1(userQuestion1);
		sn.setUserAnswer1(userAnswer1);
		sn.setUserQuestion2(userQuestion2);
		sn.setUserAnswer2(userAnswer2);
		sn.setUserQuestion3(userQuestion3);
		sn.setUserAnswer3(userAnswer3);
		sn.setOperatorId(operatorId);
		sn.setGmtModified(gmtModified);
		sn.setNote(note);
		int b=dao.modifyUserInfo(sn);
		return b;
	}
	//添加方法
	public int addUserInfo(Long ownerId, Date gmtCreate, Long operatorId, String accountNum,
			String userPassword, String accountEmail, String userNickname, String userName, String userTelephone,
			String userMobile, String userAddress, Byte accountStatus, String userQuestion1, String userAnswer1,
			String userQuestion2, String userAnswer2, String userQuestion3, String userAnswer3, String note,Byte userType) {
		UserInfo sn=new UserInfo();
		sn.setOwnerId(ownerId);
		sn.setGmtCreate(gmtCreate);
		sn.setOperatorId(operatorId);
		sn.setAccountNum(accountNum);
		sn.setUserPassword(userPassword);
		sn.setAccountEmail(accountEmail);
		sn.setUserNickname(userNickname);
		sn.setUserName(userName);
		sn.setUserTelephone(userTelephone);
		sn.setUserMobile(userMobile);
		sn.setUserAddress(userAddress);
		sn.setAccountStatus(accountStatus);
		sn.setUserQuestion1(userQuestion1);
		sn.setUserAnswer1(userAnswer1);
		sn.setUserQuestion2(userQuestion2);
		sn.setUserAnswer2(userAnswer2);
		sn.setUserQuestion3(userQuestion3);
		sn.setUserAnswer3(userAnswer3);
		sn.setNote(note);
		sn.setUserType(userType);
		int n=dao.addUserInfo(sn);
		return n;
	}
	//模糊查询
	public List<UserInfo> findListByUserInfo(String keyword, Long ownerId) {
		List<UserInfo> list=dao.findListByUserInfo(keyword, ownerId);
		return list;
	}
	//删除单条
	public int delUserInfo(Long id, Long ownerId) {
		int n=dao.delUserInfo(id, ownerId);
		return n;
	}
	//修改方法
	public int modifyUserInfo1(Long id, Long ownerId, String userName, String userTelephone,
			String userAddress,Long operatorId,Date gmtModified, String note) {
		UserInfo sn=dao.findByUserInfoId(id, ownerId);
		sn.setUserName(userName);
		sn.setUserTelephone(userTelephone);
		sn.setUserAddress(userAddress);
		sn.setNote(note);
		sn.setOperatorId(operatorId);
		sn.setGmtModified(gmtModified);
		int b=dao.modifyUserInfo(sn);
		return b;
	}
	//添加内容
	public int addUserInfo1(Long ownerId, Date gmtCreate, Long operatorId, String userName,
			String userTelephone, String userAddress, String note,Byte userType) {
		UserInfo sn=new UserInfo();
		sn.setOwnerId(ownerId);
		sn.setGmtCreate(gmtCreate);
		sn.setOperatorId(operatorId);
		sn.setUserName(userName);
		sn.setUserTelephone(userTelephone);
		sn.setUserAddress(userAddress);
		sn.setNote(note);
		sn.setUserType(userType);
		int n=dao.addUserInfo(sn);
		return n;
	}
	//删除多条
	public void delUserInfoList(Long[] id, Long ownerId) {
		for(int i=0;i<id.length;i++){
			dao.delUserInfo(id[i], ownerId);
			}
	}
	//模糊查询
	public List<UserInfo> findListsByUserInfo(String keyword, Long ownerId) {
		List<UserInfo> list=dao.findListsByUserInfo(keyword, ownerId);
		return list;
	}
	public List<UserInfo> getAccountNum(String keyword,Long ownerId) {
		List<UserInfo> list=dao.getAccountNum(keyword,ownerId);
		return list;
	}
	//通过用户账号查找
	public UserInfo findByAccountNum(String accountNum, Long ownerId) {
		UserInfo ui=dao.findByAccountNum(accountNum, ownerId);
		return ui;
	}
	
}
