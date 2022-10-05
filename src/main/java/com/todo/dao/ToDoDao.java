package com.todo.dao;

import com.todo.entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Component
public class ToDoDao {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Transactional
    public int save(Todo t){
        Integer i=(Integer) this.hibernateTemplate.save(t);
        System.out.println("saving "+i);
        return i;
    }

    public List<Todo> getAll(){
        List<Todo> todos=this.hibernateTemplate.loadAll(Todo.class);
        Collections.reverse(todos);
        return  todos;
    }

    @Transactional
    public void delete(int toID){
        Todo t=this.hibernateTemplate.load(Todo.class,toID);
        System.out.println(t);
        this.hibernateTemplate.delete(t);
    }
}
