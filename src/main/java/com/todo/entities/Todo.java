package com.todo.entities;

import java.util.Date;

public class Todo {
    private String title;

    public Todo() {
        super();
    }

    private String description;
    private Date  date;

    @Override
    public String toString() {
        return  "title='" + title + '\'' +
                ", description='" + description + '\'' + "date"+getDate();
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

    public Todo(String title, String description, Date date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }


}
