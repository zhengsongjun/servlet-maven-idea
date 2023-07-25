package com.zhengsongjun.hotel.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCookiesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("name","zhengsongjun");
        Cookie cookie2 = new Cookie("age","29");
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
