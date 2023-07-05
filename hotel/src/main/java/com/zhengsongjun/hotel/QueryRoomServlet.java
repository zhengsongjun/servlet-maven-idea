package com.zhengsongjun.hotel;

import javax.servlet.*;
import java.io.IOException;

public class QueryRoomServlet implements Servlet {
    public QueryRoomServlet(){
        System.out.println("被创建");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service is called");
    }
    @Override
    public String getServletInfo() {
        return null;
    }
    @Override
    public void destroy() {

    }
}
