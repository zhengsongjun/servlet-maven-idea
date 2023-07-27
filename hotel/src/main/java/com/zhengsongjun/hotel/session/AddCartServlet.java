package com.zhengsongjun.hotel.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddCartServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String product = req.getParameter("product");
        Object obj = session.getAttribute("cart");
        List<String> productList;
        if(obj == null) {
            productList = new ArrayList<>();
        }else {
            productList = (List<String>) obj;
        }
        productList.add(product);
        session.setAttribute("cart",productList);

    }
}
