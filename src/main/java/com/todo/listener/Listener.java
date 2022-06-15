package com.todo.listener;
import com.todo.entities.Todo;

import javax.naming.Context;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;

public class Listener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context Created");
        List<Todo> list=new ArrayList<>();
        ServletContext context=servletContextEvent.getServletContext();
        context.setAttribute("list",list);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
