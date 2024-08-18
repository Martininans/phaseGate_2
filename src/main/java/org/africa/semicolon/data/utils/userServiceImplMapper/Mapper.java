package org.africa.semicolon.data.utils.userServiceImplMapper;

import org.africa.semicolon.data.model.Task;
import org.africa.semicolon.data.model.User;
import org.africa.semicolon.dto.request.CreateTaskRequest;
import org.africa.semicolon.dto.request.UpdateTaskRequest;
import org.africa.semicolon.dto.request.RegisterUserRequst;
import org.africa.semicolon.dto.response.CreateTaskResponse;


public class Mapper {

        public static User map(RegisterUserRequst userRegistrationRequest) {
            User user = new User();
            user.setUsername(userRegistrationRequest.getUsername());
            user.setPassword(userRegistrationRequest.getPassword());
            user.setLocked(true);
            return user;
        }

        public static CreateTaskResponse map(CreateTaskRequest createTaskrequest, Task task) {
            getCreateTask(createTaskrequest, task);

            CreateTaskResponse response = getCreateTaskResponse(createTaskrequest);

            return response;
        }

        public static void getCreateTask(CreateTaskRequest createTaskrequest, Task task) {
            User taskCreator = new User();
            taskCreator.setUsername(createTaskrequest.getUsername());

            task.setUsername(taskCreator);
            task.setTaskName(createTaskrequest.getTaskName());
            task.setDescription(createTaskrequest.getDescription());
            task.setDueDate(createTaskrequest.getDueDate());
            task.setPriority(createTaskrequest.getPriority());
            task.setIsComplete(createTaskrequest.isComplete());
            task.setReminderDateTime(createTaskrequest.getReminderDateTime());
            task.setTaskCategory(createTaskrequest.getTaskCategory());
        }

        private static CreateTaskResponse getCreateTaskResponse(CreateTaskRequest createTaskrequest) {
            CreateTaskResponse response = new CreateTaskResponse();
            response.setTaskName(createTaskrequest.getUsername());
            response.setDescription(createTaskrequest.getDescription());
            response.setDueDate(createTaskrequest.getDueDate());
            response.setPriority(createTaskrequest.getPriority());
            response.setComplete(createTaskrequest.isComplete());
            response.setReminderDateTime(createTaskrequest.getReminderDateTime());
            response.setTaskCategory(createTaskrequest.getTaskCategory());
            return response;
        }

        public static Task map(UpdateTaskRequest updateTaskrequest, Task newTask) {
            newTask.setTaskName(updateTaskrequest.getNewTaskName());
            newTask.setDescription(updateTaskrequest.getDescription());
            newTask.setDueDate(String.valueOf(updateTaskrequest.getDueDate()));
            newTask.setPriority(updateTaskrequest.getPriority());
            newTask.setIsComplete(updateTaskrequest.isComplete());
            newTask.setReminderDateTime(updateTaskrequest.getReminderDateTime());
            newTask.setTaskCategory(updateTaskrequest.getTaskCategory());
            return newTask;
        }

        public static Task map(User foundUser, Task foundTask) {
            User receiver = new User();
            receiver.setUsername(foundUser.getUsername());

            Task newTask = new Task();
            newTask.setUsername(receiver);
            newTask.setTaskName(foundTask.getTaskName());
            newTask.setDescription(foundTask.getDescription());
            newTask.setDueDate(foundTask.getDueDate());
            newTask.setPriority(foundTask.getPriority());
            newTask.setIsComplete(foundTask.getIsComplete());
            newTask.setReminderDateTime(foundTask.getReminderDateTime());
            newTask.setTaskCategory(foundTask.getTaskCategory());
            return newTask;
        }

}
