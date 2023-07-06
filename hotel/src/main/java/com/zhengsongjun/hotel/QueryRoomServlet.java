package com.zhengsongjun.hotel;

import javax.servlet.*;
import java.io.IOException;

public class QueryRoomServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("queryServlet init is called");
    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("queryServlet service is called");
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    @Override
    public void destroy() {
        System.out.println("room service destroy is call");
    }
}
