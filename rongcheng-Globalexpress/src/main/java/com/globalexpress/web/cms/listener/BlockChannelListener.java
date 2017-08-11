package com.globalexpress.web.cms.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class BlockChannelListener implements HttpSessionListener{
    
    private int count = 0;

    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("sessionCreated()");
        count++;
        HttpSession session = se.getSession();
        ServletContext sct = session.getServletContext();
        sct.setAttribute("count", count);
        System.out.println(count);
        
        se.getSession().setMaxInactiveInterval(5);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed()");
        count--;
        HttpSession session = se.getSession();
        ServletContext sct = session.getServletContext();
        sct.setAttribute("count", count);
        System.out.println(count);
    }
    
}
