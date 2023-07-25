package com.zhengsongjun.hotel.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidateCookiesServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookie = req.getCookies();
        for (Cookie cookie1 : cookie) {
           String name = cookie1.getName();
           String value = cookie1.getValue();
           System.out.println(name+"="+value);
        }
    }

}
