package org.acme.components.todo.domain.entity;

import java.time.LocalDate;

public class Todo {
    
    private String id;
    private String name;
    private LocalDate limitDate;
    private boolean done;
   
    public Todo() {}

 
    public Todo(String id, String name, LocalDate limitDate, boolean done) {
        this.id = id;
        this.name = name;
        this.limitDate = limitDate;
        this.done = done;
    }


    public Todo(String name, LocalDate limitDate) {
        this.name = name;
        this.limitDate = limitDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(LocalDate limitDate) {
        this.limitDate = limitDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isValid(){
        return this.name != null && ! this.name.isEmpty() && this.limitDate != null;
    }

    public boolean isCorrectlyInserted(){
        return this.id != null && ! this.id.isEmpty();
    }

    public static Todo createDefaulTodo(String name, LocalDate limitDate) {
        return new Todo(name, limitDate);        
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", name=" + name + ", limitDate=" + limitDate + ", done=" + done + "]";
    }

    
    

}
