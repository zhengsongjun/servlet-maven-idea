package com.zhengsongjun.hotel.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class QueryCartServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        Object obj = session.getAttribute("cart");
        if(obj == null){
            resp.getWriter().write("cart is empty");
            System.out.println("cart is empty");
        }else{
            resp.getWriter().write("cart has "+ obj);
            System.out.println("cart has "+obj);
        }
    }
}
