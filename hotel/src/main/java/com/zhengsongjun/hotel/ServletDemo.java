package com.zhengsongjun.hotel;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class ServletDemo extends MyGenericServlet{
    @Override
    public void init(){
        System.out.println("servletDemo init");
    }


    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("实现业务逻辑");
    }
}
