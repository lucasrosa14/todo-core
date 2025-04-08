package org.acme.components.todo.data.repositories;

import java.util.List;

import org.acme.components.todo.domain.entity.Todo;

public interface ITodoRepository {
    Todo insertTodo(Todo todo);    

    List<Todo> listTodos();
}
