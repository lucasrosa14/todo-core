package org.acme.components.todo.domain.entity;

import java.time.LocalDate;

public class Todo {
    
    private Long id;
    private String name;
    private LocalDate limitDate;
    private boolean done;
   
    public Todo() {}

    public Todo(String name, LocalDate limitDate) {
        this.name = name;
        this.limitDate = limitDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return this.id != null && this.id > 0;
    }

    public static Todo createDefaulTodo(String name, LocalDate limitDate) {
        return new Todo(name, limitDate);        
    }

    @Override
    public String toString() {
        return "Todo [id=" + id + ", name=" + name + ", limitDate=" + limitDate + ", done=" + done + "]";
    }

    
    

}
