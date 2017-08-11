package com.globalexpress.web.cms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BlockChannelFilter implements Filter{

    //销毁实例前，调用一次
    public void destroy() {
        System.out.println("destroy()");
    }

    //处理请求
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain cha)
            throws IOException, ServletException {
        System.out.println("doFilter()");

        System.out.println(req.getRemoteAddr());
        
        
        cha.doFilter(req, res);
    }

    //创建实例后，调用一次
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("init()");
    }
    
}
