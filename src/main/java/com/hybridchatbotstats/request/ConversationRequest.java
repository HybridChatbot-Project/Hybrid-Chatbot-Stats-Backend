package com.hybridchatbotstats.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversationRequest {
    private Integer userId;
    private Integer grade;
    private String userComment;
    private Boolean isClosed;
}
