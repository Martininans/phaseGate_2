package org.africa.semicolon.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
public class NotificationResponse {
    private String title;
    private String content;
    private LocalDateTime dateTime;
}
