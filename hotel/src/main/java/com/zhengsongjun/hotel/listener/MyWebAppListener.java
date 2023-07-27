package com.zhengsongjun.hotel.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class MyWebAppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("webapp start");
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("onlineCount",0);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("webapp shut down");
    }
}
