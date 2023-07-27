package com.zhengsongjun.hotel.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionCount implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        int count = (int) servletContext.getAttribute("onlineCount");
        System.out.println(count);
        servletContext.setAttribute("onlineCount",count+1);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext servletContext = se.getSession().getServletContext();
        int count = (int) servletContext.getAttribute("onlineCount");
        System.out.println(count);
        servletContext.setAttribute("onlineCount",count-1);
    }
}
