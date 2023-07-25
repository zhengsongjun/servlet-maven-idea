package com.zhengsongjun.hotel.user;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangePassword extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String oldP = req.getParameter("oldPassword");
        String newP = req.getParameter("newPassword");
        if(PasswordClass.verify(username,oldP)){
            PasswordClass.register(username,newP);
            resp.sendRedirect("/hotel/user/login.html");
        }else{
            resp.getWriter().write("verify not call");
        }
    }
}
