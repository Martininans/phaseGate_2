package org.africa.semicolon.data.repositories;

import org.africa.semicolon.data.model.Task;
import org.africa.semicolon.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    Optional<Task> findTaskByTaskName(String taskName);

    Optional<Task> findByUsernameAndTaskName(User username, String taskName);

    Optional<Task> findByTaskName(String taskName);
}
