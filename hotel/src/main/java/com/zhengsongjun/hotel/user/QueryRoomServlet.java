package com.zhengsongjun.hotel.user;

import com.zhengsongjun.hotel.filter.LoginFilter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryRoomServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = LoginFilter.getCookieValue(req,"username");
        resp.getWriter().write(u+" queryRoom");
    }
}
