package com.todo.controller;


import com.sun.net.httpserver.Authenticator;
import com.todo.entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
public class ToDoController {

    @Autowired
    ServletContext context;
    @RequestMapping("/home")
    public  String home(Model m){
        String attr="home";
        m.addAttribute("page",attr);
        List<Todo> list= (List<Todo>) context.getAttribute("list");
        m.addAttribute("todos",list);

        return "home";
    }

    @RequestMapping("/add")
    public String add(Model m){
        Todo todo=new Todo();
        m.addAttribute("page","add");
        m.addAttribute("AddTodo",todo);
        return "home";
    }
    @RequestMapping(value = "/saveTodo",method = RequestMethod.POST)
    public String SaveToDo(@ModelAttribute("AddTodo") Todo t, Model m){
        System.out.println(t);
        t.setDate(new Date());
        List<Todo> list= (List<Todo>) context.getAttribute("list");
        list.add(t);
        m.addAttribute("msg", "Sucessfully Added");
        return "home";
    }
}
