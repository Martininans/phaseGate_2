package org.africa.semicolon.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class CreateTaskRequest {
    private String id;
    private String username;
    private String taskName;
    private String description;
    private String dueDate;
    private String priority;
    private boolean isComplete;
    private LocalDateTime reminderDateTime;
    private String taskCategory;
}
