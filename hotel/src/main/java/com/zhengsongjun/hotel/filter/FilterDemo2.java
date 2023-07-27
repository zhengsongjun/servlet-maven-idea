package com.zhengsongjun.hotel.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "FilterDemo2",urlPatterns = "/session/*")
public class FilterDemo2  extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("拦截器filterDemo2进入执行");
        chain.doFilter(req, res);
        System.out.println("拦截器filterDemo2出去执行");
    }

}