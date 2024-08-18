package org.africa.semicolon.data.repositories;

import org.africa.semicolon.data.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
