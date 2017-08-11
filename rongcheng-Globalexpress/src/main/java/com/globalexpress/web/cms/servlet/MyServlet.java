package com.globalexpress.web.cms.servlet;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.globalexpress.web.cms.util.UrlTool;

public class MyServlet  extends HttpServlet {

    /**
     * 序列号
     */
    private static final long serialVersionUID = 4997418837606788826L;

    //全局变量，今天日期
    String todayDate = "";
    
    //全局变量，第多少周
    int theWeek;
    
    //全局变量，网页地址
    String webPageLocation = "";
    
    //全局变量，IP地址
    String webPageIp = null;
    
    @Override  
    public void init() throws ServletException {
        
        //设置上下文
        ServletContext sc = getServletContext();
        
        //设置网页地址初始化
        sc.setAttribute("webPageLocation", "");
        
        System.out.println("init()start();");
        
        //定义计时器
        TimerTask task = new TimerTask() {
            
            //重写线程run方法
            @Override
            public void run() {
                
                //当前日期
                String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                
                //当前多少周
                Calendar c = Calendar.getInstance();
                int nowWeek = c.get(Calendar.WEEK_OF_YEAR);
                
                //当前地址
                String nowLocation = String.valueOf(getServletContext().getAttribute("webPageLocation"));
                
                //当前IP
                String nowIp = null;
                
                try {
                    
                    nowIp = InetAddress.getLocalHost().getHostAddress();
                    
                } catch (UnknownHostException e1) {
                    
//                    e1.printStackTrace();
                    
                }
                
                //如果日期不同 或者 地址不同 或者 IP不同 或者 周不同   
                //!todayDate.equals(nowDate)|| !webPageLocation.equals(nowLocation)  || !webPageIp.equals(nowIp)
                if (theWeek != nowWeek) {
                    
                    //覆盖日期
                    //todayDate = nowDate;
                    
                    //覆盖多少周
                    theWeek = nowWeek;
                    
                    //覆盖地址
                    webPageLocation = nowLocation;
                    
                    //覆盖IP
                    webPageIp = nowIp;
                    
                    //发送url
                    UrlTool.sendUrl(webPageLocation, webPageIp);
                }
            }
        };
        
        Timer timer = new Timer();
        
        //开始延迟
        long delay = 0;
        
        //间隔时间
        long intevalPeriod = 10 * 1000;
        
        //执行定时器
        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
          
    }  
    
}
