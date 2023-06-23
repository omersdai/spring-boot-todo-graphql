package com.example.springboottodo.task;

import com.example.springboottodo.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Task {

    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    @JsonProperty("completed")
    private boolean isCompleted;
    private Date created;
    private Date updated;

    @PrePersist
    private void onCreate() {
        created = new Date();
    }

    @PreUpdate
    private void onUpdate() {
        updated = new Date();
    }

    @JoinColumn(name = "user_email")
    private String email;
}
