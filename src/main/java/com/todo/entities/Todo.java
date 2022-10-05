package com.todo.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int toID;
    private String title;
    private String description;
    private Date  date;


    public Todo(int toID, String title, String description, Date date) {
        this.toID = toID;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Todo(int toID) {
        this.toID = toID;
    }

    public Todo(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }
    public int getToID() {
        return toID;
    }

    public Todo() {
        super();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Todo{" +
                "toID=" + toID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
