package org.africa.semicolon.data.utils.taskServiceImplMapper;

import org.africa.semicolon.data.model.Task;
import org.africa.semicolon.dto.request.CreateTaskRequest;

public class Mapper {
    public void map(CreateTaskRequest createTaskRequest, Task newTask) {
        org.africa.semicolon.data.utils.userServiceImplMapper.Mapper.getCreateTask(createTaskRequest, newTask);
    }
}
