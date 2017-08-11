package boss;

import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;  
  
  
  
/** 
 * @author hu.shiguo 
 * @time 2014-3-19下午11:50:36 
 * @description 系统加载监听器，可以在web容器启动的时候加载一些配置到内存中 
 * @version 
 */  
public class SystemListener implements ServletContextListener {  
  
    /* (non-Javadoc) 
     * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent) 
     */  
    public void contextDestroyed(ServletContextEvent event) {  
          
    }  
  
    /* (non-Javadoc) 
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent) 
     */  
    public void contextInitialized(ServletContextEvent event) {  
        String webRoot = event.getServletContext().getRealPath("/");  
        System.out.println(webRoot);  
        SystemConstants.WEB_ROOT = webRoot;  
    }  
  
}  