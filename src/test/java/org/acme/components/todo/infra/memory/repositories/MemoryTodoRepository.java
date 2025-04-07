package org.acme.components.todo.infra.memory.repositories;

import org.acme.components.todo.data.repositories.ITodoRepository;
import org.acme.components.todo.domain.entity.Todo;

import jakarta.inject.Singleton;

@Singleton
public class MemoryTodoRepository implements ITodoRepository {

    public MemoryTodoRepository() {
        // Empty constructor
    }
    
    @Override
        public Todo insertTodo(Todo todo) {
            Todo createTodo = new Todo();
            createTodo.setId(1L);
            createTodo.setName(todo.getName());
            createTodo.setLimitDate(todo.getLimitDate());   
            createTodo.setDone(todo.isDone());  

            return createTodo;
        }
}
