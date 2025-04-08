package org.acme.components.todo.data.usecases.list;

import java.util.List;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.domain.entity.Todo;
import org.acme.components.todo.domain.usecases.IListTodo;


public class ListTodo implements IListTodo {

    private final ITodoRepository todoRepository;

    public ListTodo(ITodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Output execute() {
        List<Todo> todos = this.todoRepository.listTodos();
    
        if (todos == null || todos.isEmpty()) {
            return new Output(List.of(), "No todos found");
        }
    
        return new Output(todos, "Todos listed");
    }
}
