package org.acme.web.todo;

import java.util.List;

import org.acme.components.todo.domain.entity.Todo;
import org.acme.components.todo.infra.mongo.repositories.MongoTodoRepository;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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

    @Path("/list")
    @POST
    @Produces(MediaType.APPLICATION_JSON)  
    public List<Todo> listTodo(ListTodoInput body) {
        return this.todoController.listTodo(body.id(), body.name(), body.limitDate(), body.done());
    }

    public record CreateTodoInput(
        String name, 
        String limitDate
    ) {}

    public record ListTodoInput(
        String id,
        String name, 
        String limitDate,
        String done
    ) {}
    
}
