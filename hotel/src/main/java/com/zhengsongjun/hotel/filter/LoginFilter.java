package com.zhengsongjun.hotel.filter;

import com.zhengsongjun.hotel.user.PasswordClass;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if("/user/login".equals(req.getServletPath())){
            chain.doFilter(req,resp);
            return;
        }
        String u = getCookieValue(req,"username");
        String p = getCookieValue(req,"password");
        if(u != null && p != null){
            if(PasswordClass.verify(u,p)) {
                chain.doFilter(req,resp);
            }else{
                resp.sendRedirect("/hotel/user/login.html");
            }

        }else{
            resp.getWriter().write("not login,need login");
            resp.sendRedirect("/hotel/user/login.html");
        }
    }

    public static String getCookieValue(HttpServletRequest req,String name) {
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
