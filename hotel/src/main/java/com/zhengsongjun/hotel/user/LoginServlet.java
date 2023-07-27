package com.zhengsongjun.hotel.user;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(PasswordClass.verify(username,password)){
            System.out.println(PasswordClass.verify(username,password));
            Cookie n = new Cookie("username",username);
            Cookie p = new Cookie("password",password);
            n.setMaxAge(30*24*60*60);
            p.setMaxAge(30*24*60*60);
            n.setHttpOnly(true);
            n.setHttpOnly(true);
            resp.addCookie(n);
            resp.addCookie(p);
            resp.getWriter().write("login success");
        }else{
            resp.getWriter().write("login fail");
        }
    }
}
