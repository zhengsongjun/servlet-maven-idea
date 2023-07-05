package com.zhengsongjun.hotel;

import javax.servlet.*;
import java.io.IOException;

public class BookRoomServlet implements Servlet {
    public BookRoomServlet () {
        System.out.println("book 被创建");
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
        System.out.println("book service is call");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
