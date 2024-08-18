package org.africa.semicolon.services;

import org.africa.semicolon.data.model.Task;
import org.africa.semicolon.data.model.User;
import org.africa.semicolon.dto.request.CreateTaskRequest;
import org.africa.semicolon.dto.request.SetReminderRequest;
import org.africa.semicolon.dto.request.ShareTaskRequest;
import org.africa.semicolon.dto.request.UpdateTaskRequest;
import org.africa.semicolon.dto.response.CreateTaskResponse;
import org.africa.semicolon.exceptions.TaskNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task findTaskBy(String senderUsername, String taskName) throws TaskNotFoundException;

    void saveTask(Task task);

    void deleteTask(Task task);

    Optional<Task> findTaskByTaskName(String taskName);

    void deleteAll();

    long count();

    CreateTaskResponse save(CreateTaskRequest createTaskRequest);

    Task updateTask(UpdateTaskRequest updateTaskRequest) throws TaskNotFoundException;

    void setReminder(SetReminderRequest setReminderRequest) throws TaskNotFoundException;

    List<Task> returnAllTasks();
}
