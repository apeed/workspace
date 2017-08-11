package com.rcb.service;



import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rcb.dao.UserDao;
import com.rcb.entity.User;

@Service
public class LoginService implements Serializable {
    @Resource
    private UserDao adminDao;
    /**
     * 校验管理员账号和密码
     * @param adminCode 账号
     * @param password 密码
     * @return 验证通过时返回管理员对象
     */
    public User checkAdminCodeAndPwd(
            String account, String password)
            throws AdminCodeException, PasswordException {
    	User admin = adminDao.findByName(account);
        if(admin == null) {
            throw new AdminCodeException("账号错误");
        } else if (!admin.getPassword().equals(password)) {
            throw new PasswordException("密码错误");
        } else {
            return admin;
        }
    }
}