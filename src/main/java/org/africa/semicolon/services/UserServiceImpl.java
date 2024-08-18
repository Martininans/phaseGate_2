package org.africa.semicolon.services;

import org.africa.semicolon.data.model.Task;
import org.africa.semicolon.data.model.User;
import org.africa.semicolon.data.repositories.UserRepository;
import org.africa.semicolon.dto.request.*;
import org.africa.semicolon.dto.response.CreateTaskResponse;
import org.africa.semicolon.exceptions.IncorrectUsernameOrPasswordException;
import org.africa.semicolon.exceptions.TaskNotFoundException;
import org.africa.semicolon.exceptions.UniqueUserException;
import org.africa.semicolon.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.africa.semicolon.data.utils.userServiceImplMapper.Mapper.map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskService taskService;

    @Override
    public User register(RegisterUserRequst registerUserRequst) {
        findUserBy(String.valueOf(registerUserRequst));
        User user = map(registerUserRequst);
        userRepository.save(user);

        return user;
    }

    @Override
    public User logout(String username) {
        User foundUser = findUserBy(username);
        foundUser.setLocked(true);
        userRepository.save(foundUser);

        return foundUser;
    }

    @Override
    public User unlock(UserLoginRequest userLoginRequest) {
        Optional<User> user = userRepository.findFirstUserByUsername(userLoginRequest.getUsername());
        if(user.isEmpty()) throw new UserNotFoundException("User not found");
        if (user.get().getUsername().equals(userLoginRequest.getUsername()) &&
                user.get().getPassword().equals(userLoginRequest.getPassword()))
            user.get().setLocked(false);
        else throw new IncorrectUsernameOrPasswordException("Username or password is incorrect");
        userRepository.save(user.get());

        return user.get();
    }

    @Override
    public CreateTaskResponse createTask(CreateTaskRequest createTaskrequest) {
        CreateTaskResponse response = taskService.save(createTaskrequest);
        return response;
    }

    @Override
    public User findUserBy(String username) {
        Optional<User> foundUser = userRepository.findUserByUsername(username);
        if (foundUser.isEmpty()) throw new UserNotFoundException("User not found!");
        return foundUser.get();
    }

    @Override
    public Task updateTask(UpdateTaskRequest updateTaskRequest) throws TaskNotFoundException {
        Task updatedTask =  taskService.updateTask(updateTaskRequest);
        return updatedTask;
    }

    @Override
    public void deleteTask(CreateTaskRequest createTaskRequest2) throws TaskNotFoundException {
        Optional<Task> task = taskService.findTaskByTaskName(createTaskRequest2.getTaskName());
        if (task.isEmpty()) throw new TaskNotFoundException("Task not found!");
        taskService.deleteTask(task.get());
    }

    @Override
    public Task shareTask(ShareTaskRequest shareTaskRequest) throws TaskNotFoundException {
        Task foundTask = taskService.findTaskBy(shareTaskRequest.getSenderUsername(), shareTaskRequest.getTaskName());
        User foundUser = findUserBy(shareTaskRequest.getReceiverUsername());
        Task newTask = map(foundUser, foundTask);
        taskService.saveTask(newTask);

        return newTask;
    }

    @Override
    public Optional<User> findUserByUsernameForTask(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public String getUsername() {
        User user = new User();
        return user.getUsername();
    }
    private void findUserBy(RegisterUserRequst registerUserRequest) throws UniqueUserException {
        Optional<User> user = userRepository.findUserByUsername(registerUserRequest.getUsername());
        if (user.isPresent())
            throw new UniqueUserException("Username exists already!!");
    }
}
