package com.example.springboottodo.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    @Query(value = """
    select t from Task t \s
    where t.email = :email
    """)
    List<Task> findAllTaskByUser(String email);

    @Query(value = """
    select t from Task t \s
    where t.email = :email and t.isCompleted = true
    """)
    List<Task> findAllCompletedTaskByUser(String email);

    @Query(value = """
    select t from Task t \s
    where t.id = :id and t.email = :email
    """)
    Optional<Task> findById(int id, String email);
}
