package com.todo.dao;

import com.todo.entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Component
public class ToDoDao {
    @Autowired
    HibernateTemplate hibernateTemplate;

    @Transactional
    public int save(Todo t){
        Integer i=(Integer) this.hibernateTemplate.save(t);
        return i;
    }

    public List<Todo> getAll(){
        List<Todo> todos=this.hibernateTemplate.loadAll(Todo.class);
        return  todos;
    }
}
