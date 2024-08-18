package org.africa.semicolon.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Task {
    @Id
    private String id;
    private User username;
    private String taskName;
    private String description;
    private String dueDate;
    private String priority;
    private Boolean isComplete;
    private LocalDateTime reminderDateTime;
    private String taskCategory;

    @Override
    public String toString() {
        return "Here's your task:" +
                "TaskName: " + taskName +
                "Description: " + description +
                "Due Date: " + dueDate +
                "Priority: " + priority +
                "Is Complete: " + isComplete +
                "Reminder Date & Time: " + reminderDateTime +
                "Task Category: " + taskCategory;
    }
}
