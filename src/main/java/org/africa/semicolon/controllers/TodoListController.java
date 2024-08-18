package org.africa.semicolon.controllers;

import org.africa.semicolon.data.model.Task;
import org.africa.semicolon.data.model.User;
import org.africa.semicolon.dto.request.*;
import org.africa.semicolon.dto.response.CreateTaskResponse;
import org.africa.semicolon.exceptions.TaskNotFoundException;
import org.africa.semicolon.services.TaskService;
import org.africa.semicolon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/todolist")
public class TodoListController {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @PostMapping("/api/registration")
    public User register(@RequestBody RegisterUserRequst registerUserRequest) {
        try {
            User registeredUser = userService.register(registerUserRequest);
            return registeredUser;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @PostMapping(path = "/api/login")
    public User login(@RequestBody UserLoginRequest userLoginRequest) {
        try {
            User loggedInUser = userService.unlock(userLoginRequest);
            return loggedInUser;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @PostMapping(path = "/api/Logout")
    public User logout(@RequestBody String username) {
        try {
            User user = userService.logout(username);
            return user;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    @PostMapping(path = "/api/tasks")
    public CreateTaskResponse createTask(@RequestBody CreateTaskRequest createTaskRequest) {
        try {
            CreateTaskResponse response = userService.createTask(createTaskRequest);
            return response;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @PatchMapping(path = "/api/updates")
    public Task updateTask(@RequestBody UpdateTaskRequest updateTaskRequest) {
        try {
            Task updatedTask = userService.updateTask(updateTaskRequest);
            return updatedTask;
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        } catch (TaskNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @DeleteMapping(path = "/api/delete")
    public String deleteTask(@RequestBody CreateTaskRequest createTaskRequest) {
        try {
            userService.deleteTask(createTaskRequest);
            return "Task deleted!";
        } catch (Exception ex) {
            return ex.getMessage();
        } catch (TaskNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping(path = "api/clear")
    public void deleteAllTasks() {
        taskService.deleteAll();
    }

    @PostMapping(path = "/api/shares")
    public Task shareTask(@RequestBody ShareTaskRequest shareTaskRequest) {
        try {
            Task task = userService.shareTask(shareTaskRequest);
            return task;
        } catch (Exception | TaskNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @GetMapping(path = "/api/find/{taskName}")
    public Optional<Task> findTask(@PathVariable String taskName) {
        try {
            Optional<Task> foundTask = taskService.findTaskByTaskName(taskName);
            return foundTask;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }

    @GetMapping(path = "api/findAll")
    public List<Task> findAllTasks() {
        try {
            List<Task> allTasks = taskService.returnAllTasks();
            return allTasks;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

}
