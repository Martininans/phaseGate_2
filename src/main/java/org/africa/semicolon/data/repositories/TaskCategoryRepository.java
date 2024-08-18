package org.africa.semicolon.data.repositories;

import org.africa.semicolon.data.model.TaskCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCategoryRepository extends MongoRepository<TaskCategory,String> {
}
