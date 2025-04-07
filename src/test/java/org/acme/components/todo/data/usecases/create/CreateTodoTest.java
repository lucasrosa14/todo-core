package org.acme.components.todo.data.usecases.create;

import org.acme.components.todo.domain.usecases.ICreateTodo;
import org.acme.components.todo.domain.usecases.ICreateTodo.Input;
import org.acme.components.todo.domain.usecases.ICreateTodo.Output;
import org.acme.components.todo.infra.memory.repositories.MemoryTodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
class CreateTodoTest {

    @Inject 
    MemoryTodoRepository todoRepository;
                
    @Test
    void testRightExecute() {
       ICreateTodo createTodo = new CreateTodo(this.todoRepository);

       Output output = createTodo.execute(new Input("Fazer café", "2025-04-08"));

       Assertions.assertEquals("Todo created", output.message());
    }

    @Test
    void testWrongExecute() {
       ICreateTodo createTodo = new CreateTodo(this.todoRepository);

       Assertions.assertThrows(Exception.class, () -> createTodo.execute(new Input("Fazer Café", "20-04-08")));
    }
}
