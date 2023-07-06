package com.zhengsongjun.hotel;

import javax.servlet.*;
import java.io.IOException;

public class CheckInServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("checkInServlet init is called");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("checkInServlet servlet is called");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("checkInServlet destroy is called");
    }
}
