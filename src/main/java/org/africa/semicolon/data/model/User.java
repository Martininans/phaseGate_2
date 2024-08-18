package org.africa.semicolon.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class User {

    private String id;
    private String username;
    private String password;
    private String email;
    private boolean isLocked;
    private List<Task> tasks;
    private List<TaskCategory> category;
}
