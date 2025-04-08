package org.acme.components.todo.data.usecases.list;

import org.acme.components.todo.data.usecases.create.CreateTodo;
import org.acme.components.todo.domain.usecases.ICreateTodo;
import org.acme.components.todo.domain.usecases.ICreateTodo.Input;
import org.acme.components.todo.domain.usecases.IListTodo.Output;
import org.acme.components.todo.domain.usecases.IListTodo;
import org.acme.components.todo.infra.memory.repositories.MemoryTodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
class ListTodoTest {
    
    @Inject 
    MemoryTodoRepository todoRepository;

    @Test
    void testListTodosAfterCreate() {
        
        ICreateTodo createTodo = new CreateTodo(this.todoRepository);
        IListTodo listTodo = new ListTodo(this.todoRepository);

        createTodo.execute(new Input("Lavar a louça", "2025-04-08"));
        createTodo.execute(new Input("Estudar Quarkus", "2025-04-09"));
        
        Output output = listTodo.execute();

        System.out.println("== Todos Listados ==");
        output.todos().forEach(todo -> {
            System.out.println("ID: " + todo.getId());
            System.out.println("Nome: " + todo.getName());
            System.out.println("Data limite: " + todo.getLimitDate());
            System.out.println("Concluído: " + todo.isDone());
            System.out.println("---------------");
        });

        Assertions.assertEquals("Todos listed", output.message());
        Assertions.assertEquals(2, output.todos().size());
        Assertions.assertEquals("Lavar a louça", output.todos().get(0).getName());
        Assertions.assertEquals("Estudar Quarkus", output.todos().get(1).getName());
    }

    @Test
    void testListTodosWhenEmpty() {
    
        IListTodo listTodo = new ListTodo(this.todoRepository);

        Output output = listTodo.execute();

        Assertions.assertEquals("No todos found", output.message());
        Assertions.assertTrue(output.todos().isEmpty());
    }
}
