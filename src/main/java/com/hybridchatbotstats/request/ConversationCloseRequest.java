package com.hybridchatbotstats.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversationCloseRequest {
    private Integer conversationId;
    private Integer grade;
    private String userComment;
}
