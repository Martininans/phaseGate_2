package org.africa.semicolon.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class NotificationRequest {
    private String title;
    private String content;
    private LocalDateTime dateTime;
}
