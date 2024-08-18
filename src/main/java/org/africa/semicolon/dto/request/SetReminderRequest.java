package org.africa.semicolon.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Data
public class SetReminderRequest {
    private LocalDateTime reminderDateTime;
}
