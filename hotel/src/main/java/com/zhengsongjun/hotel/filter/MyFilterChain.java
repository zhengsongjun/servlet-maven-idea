package com.zhengsongjun.hotel.filter;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MyFilterChain implements FilterChain {
    private ArrayList<Filter> filterArrayList;

    private int point = 0;



    public MyFilterChain(ArrayList<Filter> filterArrayList,Servlet servlet){
        if(filterArrayList == null) {
            filterArrayList = new ArrayList<>();
        }
        filterArrayList.add(new FilterProxy(servlet));
        this.filterArrayList = filterArrayList;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
        if(this.point < filterArrayList.size()) {
            Filter filter = filterArrayList.get(point);
            point++;
            filter.doFilter(servletRequest,servletResponse,this);
        }
    }

    private static class FilterProxy extends HttpFilter {
        private Servlet servlet;

        public FilterProxy(Servlet servlet) {
            this.servlet = servlet;
        }

        @Override
        public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
            servlet.service(req, res);
        }
    }

}
