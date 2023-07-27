package com.zhengsongjun.hotel.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;

public class MyFilterChain implements FilterChain {
    private ArrayList<Filter> filterArrayList;

    private int point;

    private Servlet servlet;


    public MyFilterChain(ArrayList<Filter> filterArrayList,Servlet servlet){
        this.filterArrayList = filterArrayList;
        this.servlet = servlet;
        if(filterArrayList != null && filterArrayList.size() > 0) {
            this.point = 0;
        }else {
            this.point = -1;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
        System.out.println(this.point);
        if(this.point == -1) {
            this.servlet.service(servletRequest,servletResponse);
        }else{
            if(this.point >= filterArrayList.size()){
                servlet.service(servletRequest,servletResponse);
            }else{
                Filter filter = filterArrayList.get(point);
                point++;
                filter.doFilter(servletRequest,servletResponse,this);
            }
        }
    }
}
