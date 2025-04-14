package org.acme.web.todo;

import org.acme.components.todo.infra.mongo.repositories.MongoTodoRepository;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/todo")
public class TodoRouter {

    private final TodoController todoController;

    public TodoRouter(MongoTodoRepository mongoTodoRepository) {
        this.todoController = new TodoController(mongoTodoRepository);
        
    }

    @Path("/create")
    @POST
    public String createTodo(CreateTodoInput body) {
       return this.todoController.createTodo(body.name(), body.limitDate());
        
    }

    public record CreateTodoInput(
        String name, 
        String limitDate
    ) {}
    
}
