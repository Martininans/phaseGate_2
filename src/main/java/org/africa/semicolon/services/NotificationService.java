package org.africa.semicolon.services;

import org.africa.semicolon.dto.request.NotificationRequest;
import org.africa.semicolon.dto.response.NotificationResponse;
import org.springframework.stereotype.Service;


public interface NotificationService {
    NotificationResponse sendNotification(NotificationRequest notificationRequest);
    Long count();
    void deleteAll();
}
