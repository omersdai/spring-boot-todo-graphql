package com.example.springboottodo.task;

import com.example.springboottodo.config.JwtService;
import com.example.springboottodo.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;
    private final JwtService jwtService;

    public Task saveTask(Task task) {
        task.setEmail(getEmail());
        return repository.save(task);
    }

    public List<Task> getTasks(){
        return repository.findAllTaskByUser(getEmail());
    }

    public List<Task> getCompletedTasks() {
        return repository.findAllCompletedTaskByUser(getEmail());
    }

    public Task getTaskById(int id){
        return repository.findById(id, getEmail()).orElse(null);
    }

    public String deleteProduct(int id){
        Task task = repository.findById(id, getEmail()).orElse(null);
        if(task == null) return "Task does not exist!";

        repository.deleteById(id);
        return "Task with " + id + " removed!";
    }

    public Task updateTask(Task task){
        Task existingTask = repository.findById(task.getId(), getEmail()).orElse(null);
        if(existingTask == null) return null;
        existingTask.setDescription(task.getDescription());
        existingTask.setCompleted(task.isCompleted());

        return repository.save(existingTask);
    }

    private String getEmail(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ((User) principal).getEmail();
    }
}
