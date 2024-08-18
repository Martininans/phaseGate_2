package org.africa.semicolon.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
public class CreateTaskResponse {
    private String username;
    private String taskName;
    private String description;
    private String dueDate;
    private String priority;
    private boolean isComplete;
    private LocalDateTime reminderDateTime;
    private String taskCategory;

}
