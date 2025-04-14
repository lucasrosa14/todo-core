package org.acme.components.todo.infra.mongo.entity;

import java.time.LocalDate;

import org.acme.components.todo.domain.entity.Todo;
import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "todo")
public class MongoTodo {
    
    private ObjectId id;
    private String name;
    private LocalDate limitDate;
    private boolean done;
    
    public MongoTodo() {
        // Empty constructor
    }

    public MongoTodo(ObjectId id, String name, LocalDate limitDate, boolean done) {
        this.id = id;
        this.name = name;
        this.limitDate = limitDate;
        this.done = done;
    }

    public MongoTodo(String name, LocalDate limitDate, boolean done) {
        this.name = name;
        this.limitDate = limitDate;
        this.done = done;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
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

    public static MongoTodo createMongoTodo(Todo todo) {
        return new MongoTodo(todo.getName(), todo.getLimitDate(), todo.isDone());
    }

    public Todo convertToTodo() {
        return new Todo(this.id.toString(), this.name, this.limitDate, this.done);
    }

    @Override
    public String toString() {
        return "MongoTodo [id=" + id + ", name=" + name + ", limitDate=" + limitDate + ", done=" + done + "]";
    }

    
}
