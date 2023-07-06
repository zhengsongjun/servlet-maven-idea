package com.zhengsongjun.hotel;

import junit.framework.TestCase;
import org.junit.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class WebContainerTest extends TestCase {
    private List<ServletConfiguration> buildConfiguration() {
        ServletConfiguration bookRoom = new ServletConfiguration("/book","com.zhengsongjun.hotel.BookRoomServlet",null);
        ServletConfiguration queryRoom = new ServletConfiguration("/queryRoom","com.zhengsongjun.hotel.QueryRoomServlet",-1);
        ServletConfiguration checkIn = new ServletConfiguration("/checkIn","com.zhengsongjun.hotel.CheckInServlet",0);
        ServletConfiguration checkOut= new ServletConfiguration("/checkOut","com.zhengsongjun.hotel.CheckOutServlet",1);
        ServletConfiguration end= new ServletConfiguration("/end","com.zhengsongjun.hotel.EndServlet",null);


        List<ServletConfiguration> servletConfigurationList = new ArrayList<>();
        servletConfigurationList.add(bookRoom);
        servletConfigurationList.add(queryRoom);
        servletConfigurationList.add(checkIn);
        servletConfigurationList.add(checkOut);
        servletConfigurationList.add(end);
        return servletConfigurationList;
    }


    @Test
    public void testWebContainer() throws ServletException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        List<ServletConfiguration> configurationList = buildConfiguration();
        WebContainer webContainer = new WebContainer();
        webContainer.start(configurationList);
        webContainer.doService("/queryRoom",null,null);
        webContainer.doService("/bookRoom",null,null);
        webContainer.doService("/checkIn",null,null);
        webContainer.doService("/checkOut",null,null);
        webContainer.doService("/end",null,null);
        webContainer.close();
    }

}