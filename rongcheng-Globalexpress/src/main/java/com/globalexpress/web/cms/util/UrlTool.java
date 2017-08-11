package com.globalexpress.web.cms.util;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

public class UrlTool {

    /**
     * 发送参数给指指定地址
     * @param webPageLocation 地址
     * @param webPageIp ip
     * @author 赵滨
     */
    public static void sendUrl(String webPageLocation, String webPageIp) {
      //解决异常
        try {
            //设置HTTP连接的URL地址，就是第二个应用的URL。如果在同一个计算机上可以将192.168.1.134变成127.0.0.1或者localhost  
            String http="http://192.168.1.121:80/vipUser.do";
            
            //定义url对象
            URL url=new URL(http);  
            
            //生成HttpURLConnection连接  
            HttpURLConnection httpurlconnection=(HttpURLConnection) url.openConnection(); 
            
            //设置有输出流，默认为false，就是不能传递参数。  
            httpurlconnection.setDoOutput(true);  
            
            //设置发送请求的方式。注意：一定要大写  
            httpurlconnection.setRequestMethod("POST"); 
            
            //设置连接超时的时间。不过不设置，在网络异常的情况下，可能会造成程序僵死而无法继续向下执行，所以一般设置一个超时时间。单位为毫秒  
            httpurlconnection.setConnectTimeout(30000);
            
            //设置输出流。  
            OutputStreamWriter writer=new OutputStreamWriter(httpurlconnection.getOutputStream(), "utf-8");
            
            //传递的参数，中间使用&符号分割。  
            writer.write("webPageLocation=" + webPageLocation + "&webPageIp=" + webPageIp);
            
            //用于刷新缓冲流。因为默认她会写入到内存的缓冲流中，到一定的数据量时，才会写入，使用这个命令可以让他立即写入，不然下面就到关闭流了  
            writer.flush();  
            
            //用于关闭输出流，关闭之后就不可以输出数据了，所以要使用flush刷新缓冲流  
            writer.close();  
            
            //获得返回的请求吗。  
            int responseCode=httpurlconnection.getResponseCode();  
            
            //表示请求成功  
            /*if(responseCode==HttpURLConnection.HTTP_OK){  
                
                System.out.println("OK"+responseCode);  
                
                //获得服务端的输出流。得到返回的数据  
                InputStream urlstream=httpurlconnection.getInputStream();  
                
                BufferedReader reader=new BufferedReader(new InputStreamReader(urlstream));  
                
                String line;  
                
                String tline="";  
                
                while((line=reader.readLine())!=null){  
                    
                    tline+=line;  
                    
                }  
                
                //输出所有的数据  
                System.out.println(tline);  
                
            }else{  
                
                System.out.println("ERR"+responseCode);  
                
            } */
        } catch (Exception e) {
            
            //显示异常
//            System.out.println(e);
            
        }
    }
}
