package com.rongcheng_tech.cms.service.UserInfo;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rongcheng_tech.cms.dao.UserInfoDAO_JXB;
import com.rongcheng_tech.cms.entity.UserInfo;

@Service
public class UserInfoService_JXBImpl implements UserInfoService_JXB {
	//ownerId
	@Value("#{sysconfig['ownerId']}")
	private Long ownerId;
	@Resource
	UserInfoDAO_JXB dao;
	public Object[] listByOwnerIdAndPage(Long ownerId, int page, int rows) {
		int count = dao.countByOwnerId(ownerId);
		int maxPage = (int) Math.ceil(new Double(count)/rows);
		if(maxPage == 0){
			return new Object[]{maxPage,null};
		}
		if(page>maxPage){
			page = maxPage;
		}
		if(page<1){
			page = 1;
		}
		int start = (page-1)*rows;
		List<UserInfo> list = dao.listByOwnerIdLimit(ownerId, start, rows);
		return new Object[]{maxPage,list};
	}

	public UserInfo checkLogin(String account, String password, String inputImgCode, String imgCode) throws RuntimeException {
		if (inputImgCode == null || inputImgCode == "" || !inputImgCode.equalsIgnoreCase(imgCode)) {
			throw new RuntimeException("imgCodeError");
		}

		UserInfo user = dao.getByOwnerIdAndAccountNum (ownerId,account);

		if (user == null) {
			// 找不到符合条件的记录, 抛出一个应用异常。
			throw new RuntimeException("accountError");
		}

		if (!user.getUserPassword().equals(password)) {
			System.out.println(user);
			// 用户提交的密码与数据库保存的密码不一致。
			throw new RuntimeException("passWordError");
		}
		if (user.getAccountStatus()!=1) {
			// 用户已被冻结
			throw new RuntimeException("userError");
		}

		// 登录验证通过
		return user;
	}
}
