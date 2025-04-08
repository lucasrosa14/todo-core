package org.acme.components.todo.domain.usecases;

import java.util.List;
import org.acme.components.todo.domain.entity.Todo;

public interface IListTodo {

    Output execute();

    public record Output(
        List<Todo> todos,
        String message
    ) {}
}
