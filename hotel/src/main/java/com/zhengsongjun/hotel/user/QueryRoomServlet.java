package com.zhengsongjun.hotel.user;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QueryRoomServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = getCookieValue(req,"username");
        String p = getCookieValue(req,"password");
        if(u != null && p != null){
            if(PasswordClass.verify(u,p)) {
                resp.getWriter().write("queryRoom is called");
            }else{
                Cookie cookie1 = new Cookie("username","");
                Cookie cookie2 = new Cookie("password","");
                cookie1.setPath(req.getContextPath());
                cookie2.setPath(req.getContextPath());
                cookie1.setMaxAge(0);
                cookie2.setMaxAge(0);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
                resp.sendRedirect("/hotel/user/login.html");
            }

        }else{
            resp.getWriter().write("not login,need login");
            resp.sendRedirect("/hotel/user/login.html");
        }
    }


    public String getCookieValue(HttpServletRequest req,String name) {
        Cookie[] cookies = req.getCookies();
        if(cookies == null) {
            return null;
        }

        for (Cookie cookie : cookies) {
           if(name.equals(cookie.getName())){
               return cookie.getValue();
           }
        }
        return null;
    }
}
