package com.zhengsongjun.hotel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

public class UserRegisterServlet extends HttpServlet {
    @Override

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String hobby = req.getParameter("hobby");
        String age = req.getParameter("age");


        Map<String, String[]> parameterMap = req.getParameterMap();
        Enumeration<String> parameterNames= req.getParameterNames();
        System.out.println("userRegisterServlet is called");
    }
}
