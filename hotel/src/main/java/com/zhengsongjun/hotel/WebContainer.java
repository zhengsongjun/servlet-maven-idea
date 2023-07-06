package com.zhengsongjun.hotel;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.*;

public class WebContainer {
    Map<String, String> urlPatternToServletClass = new HashMap<>();

    Map<String,Servlet> urlPatternToServlet = new HashMap<>();
    /***
     * 启动web容器
     */


    public void start(List<ServletConfiguration> configurationList) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException {
        List<ServletConfiguration> servletLoadOnStartup = new ArrayList<>();
        for (ServletConfiguration configuration : configurationList) {
           String urlPattern = configuration.getUrlPattern();
           String servletClass = configuration.getServletClass();
           Integer loadOnStartup = configuration.getLoadOnStartup();
           urlPatternToServletClass.put(urlPattern,servletClass);
           if(loadOnStartup != null && loadOnStartup > 0) {
               servletLoadOnStartup.add(configuration);
           }
        }
        servletLoadOnStartup.sort(Comparator.comparing(v -> v.getLoadOnStartup()));
        // 创建servlet对象
        for (ServletConfiguration configuration : servletLoadOnStartup) {
            String servletClass = configuration.getServletClass();
            String urlPattern = configuration.getUrlPattern();
            Servlet servlet = createServlet(urlPattern,servletClass);
            servlet.init(null);

        }



    }

    private Servlet createServlet (String urlPattern,String servletClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName(servletClass);
        Object obj = clazz.newInstance();
        Servlet servlet = (Servlet) obj;
        urlPatternToServlet.put(urlPattern,servlet);
        return servlet;
    }

    /***
     * 执行请求
     */
    public void doService(String urlPattern, ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       if(urlPatternToServlet.containsKey(urlPattern)){
           Servlet servlet = urlPatternToServlet.get(urlPattern);
           servlet.service(servletRequest,servletResponse);
           return;
       }
       if(urlPatternToServletClass.containsKey(urlPattern)) {
           String servletClass = urlPatternToServletClass.get(urlPattern);
           Servlet servlet = createServlet(urlPattern,servletClass);
           servlet.service(servletRequest,servletResponse);
           return;
       }
        System.out.println("请求错误");
    }

    /***
     * 关闭web容器
     */
    public void close(){
        for (Servlet servlet : urlPatternToServlet.values()) {
           servlet.destroy();
        }
    }
}
