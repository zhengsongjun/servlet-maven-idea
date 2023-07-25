package com.zhengsongjun.hotel.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QuerySessionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object count = session.getAttribute("count");
        if(count != null){
            resp.getWriter().write("request's count is" + count);
        }else{
            resp.getWriter().write("Please create request!");
        }
    }
}
