package com.rcb.controller;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rcb.entity.User;
import com.rcb.service.AdminCodeException;
import com.rcb.service.LoginService;
import com.rcb.service.PasswordException;

@Controller
public class LoginController implements Serializable {
    
    @Resource
    private LoginService loginService;
    @RequestMapping("/toLogin.do")
    public String toLogin() {
        return "login";
    }
    
    @RequestMapping("/toIndex.do")
    public String toIndex() {
        return "index";
    }
    
    @RequestMapping("/checkLogin.do")
    public String checkLogin(String account, String password, 
            ModelMap model, HttpSession session) {
        try {
            User admin = 
                loginService.checkAdminCodeAndPwd(account, password);
            session.setAttribute("admin", admin);
        } catch (AdminCodeException e) {
            model.addAttribute("message", e.getMessage());
            model.addAttribute("adminCode", account);
            model.addAttribute("password", password);
            return "main/login";
        } catch (PasswordException e) {
            model.addAttribute("message", e.getMessage());
            model.addAttribute("adminCode", account);
            model.addAttribute("password", password);
            return "main/login";
        }
        return "redirect:toIndex.do";
    }
    
}