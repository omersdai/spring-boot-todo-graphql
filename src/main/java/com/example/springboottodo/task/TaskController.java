package com.example.springboottodo.task;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return service.saveTask(task);
    }

    @GetMapping
    public List<Task> getTasks(){
        return service.getTasks();
    }

    @GetMapping("/completed")
    public List<Task> getCompletedTasks(){
        return service.getCompletedTasks();
    }

    @GetMapping("/{id}")
    public Task findTaskById(@PathVariable int id){
        return service.getTaskById(id);
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task){
        return service.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id){
        return service.deleteProduct(id);
    }
}
