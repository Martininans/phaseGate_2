package org.africa.semicolon.dto.request;

import lombok.Data;

@Data
public class ShareTaskRequest {
    private String senderUsername;
    private String taskName;
    private String receiverUsername;
}
