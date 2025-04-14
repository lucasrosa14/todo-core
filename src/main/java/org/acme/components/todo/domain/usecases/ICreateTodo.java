package org.acme.components.todo.domain.usecases;

import org.acme.components.todo.domain.entity.Todo;

public interface ICreateTodo {

    Output execute(Input input);
    
    public record Input(
        String name, 
        String limitDate
    ) {}

    public record Output(
        String message,
        Todo todo
    ) {}
}
