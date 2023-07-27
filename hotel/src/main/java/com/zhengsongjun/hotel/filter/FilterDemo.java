package com.zhengsongjun.hotel.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(filterName = "FilterDemo",urlPatterns = "/session/*")
public class FilterDemo extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("拦截器filterDemo1进入执行");
        chain.doFilter(req, res);
        System.out.println("拦截器filterDemo1出去执行");
    }

}
