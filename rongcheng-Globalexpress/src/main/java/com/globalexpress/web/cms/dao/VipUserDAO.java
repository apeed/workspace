package com.globalexpress.web.cms.dao;

import com.globalexpress.web.entity.VipUser;

/**
 * 用户访客信息表 DAO层
 * 
 * <p>用户访客信息表的增删改查一系列的方法，是JAVA使用MyBatis来完成与MySQL的交互。
 * 
 * @author 赵滨
 */
public interface VipUserDAO {
    
    /**
     * 保存 用户访客信息表
     * 
     * <p>传入用户访客信息对象，MyBatis使用对象保存栏目表。
     * 
     * @param vipUser 用户访客信息对象
     * @return row 存储的行数
     * @author 赵滨
     */
    int saveVipUser(VipUser vipUser);
}
