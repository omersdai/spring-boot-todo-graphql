package com.example.springboottodo.task;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @MutationMapping
    public Task addTask(@Argument Task task){
        return service.saveTask(task);
    }

    @QueryMapping
    public List<Task> getTasks(){
        return service.getTasks();
    }

    @QueryMapping
    public List<Task> getCompletedTasks(){
        return service.getCompletedTasks();
    }

    @QueryMapping
    public Task findTaskById(@Argument Integer id){
        return service.getTaskById(id);
    }

    @MutationMapping
    public Task updateTask(@Argument Task task){
        return service.updateTask(task);
    }

    @MutationMapping
    public String deleteTask(@Argument Integer id){
        return service.deleteProduct(id);
    }
}
