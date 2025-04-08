package org.acme.components.todo.infra.memory.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.domain.entity.Todo;

import jakarta.inject.Singleton;

@Singleton
public class MemoryTodoRepository implements ITodoRepository {

    private final List<Todo> todos = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1); // Garante IDs únicos

    public MemoryTodoRepository() {
        // Empty constructor
    }
    
    @Override
    public Todo insertTodo(Todo todo) {
        Todo createTodo = new Todo();
        createTodo.setId(idGenerator.getAndIncrement());
        createTodo.setName(todo.getName());
        createTodo.setLimitDate(todo.getLimitDate());   
        createTodo.setDone(todo.isDone());  

        todos.add(createTodo); // Armazena na lista

        return createTodo;
    }
    
    @Override
    public List<Todo> listTodos() {
        return todos; // Lista original (modificável)
    }
        
}
