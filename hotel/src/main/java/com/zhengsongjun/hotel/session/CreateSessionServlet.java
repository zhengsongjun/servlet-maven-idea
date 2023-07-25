package com.zhengsongjun.hotel.session;

import com.zhengsongjun.hotel.user.PasswordClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateSessionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object count = session.getAttribute("count");
        if(count == null) {
            session.setAttribute("count",1);
        }else{
            int num = (int) count;
            session.setAttribute("count",num+1);
        }
    }
}
