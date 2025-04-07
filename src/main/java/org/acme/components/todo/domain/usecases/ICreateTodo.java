package org.acme.components.todo.domain.usecases;

public interface ICreateTodo {

    Output execute(Input input);
    
    public record Input(
        String name, 
        String limitDate
    ) {}

    public record Output(
        String message
    ) {}
}
