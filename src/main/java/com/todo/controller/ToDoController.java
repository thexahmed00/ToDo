package com.todo.controller;


import com.sun.net.httpserver.Authenticator;
import com.todo.dao.ToDoDao;
import com.todo.entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
public class ToDoController {

    @Autowired
    ServletContext context;

    @Autowired
    ToDoDao toDoDao;

    @RequestMapping("/home")
    public  String home(Model m){
        String attr="home";
        m.addAttribute("page",attr);
        List<Todo> list= this.toDoDao.getAll();
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
      this.toDoDao.save(t);
        m.addAttribute("msg", "Sucessfully Added");
        return "home";
    }

    @RequestMapping("/deleteTask/{toID}")
    public String DeleteTodo(@PathVariable("toID") int toID, Model m){

        System.out.println("deleting...");
        this.toDoDao.delete(toID);
        m.addAttribute("msg","Succesfully deleted");
        return "home";
    }
}
