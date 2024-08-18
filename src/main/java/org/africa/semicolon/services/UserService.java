package org.africa.semicolon.services;


import org.africa.semicolon.data.model.Task;
import org.africa.semicolon.data.model.User;
import org.africa.semicolon.dto.request.*;
import org.africa.semicolon.dto.response.CreateTaskResponse;
import org.africa.semicolon.exceptions.TaskNotFoundException;

import java.util.Optional;

public interface UserService {
    User register(RegisterUserRequst registerUserRequst);


    User logout(String username);

    User unlock(UserLoginRequest userLoginRequest);

    CreateTaskResponse createTask(CreateTaskRequest createTaskrequest);

    User findUserBy(String username);

    Task updateTask(UpdateTaskRequest updateTaskRequest) throws TaskNotFoundException;

    void deleteTask(CreateTaskRequest createTaskRequest2) throws TaskNotFoundException;


    Task shareTask(ShareTaskRequest shareTaskRequest) throws TaskNotFoundException;

    Optional<User> findUserByUsernameForTask(String username);

    String getUsername();
}
