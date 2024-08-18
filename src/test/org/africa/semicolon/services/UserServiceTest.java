package org.africa.semicolon.services;

import org.africa.semicolon.data.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoAssertionError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskService taskService;

    @Autowired
    NotificationService notificationService;

    @BeforeEach
    public void delete() {
        userRepository.deleteAll();
        taskService.deleteAll();
        notificationService.deleteAll();
    }
  
}