package com.zhengsongjun.hotel.listener;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class QuerySessionCount extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(true);
        httpSession.setMaxInactiveInterval(10);
        int count = (int) httpSession.getServletContext().getAttribute("onlineCount");
        resp.getWriter().write("count is "+ count);
    }

}
