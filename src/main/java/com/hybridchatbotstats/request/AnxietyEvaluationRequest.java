package com.hybridchatbotstats.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnxietyEvaluationRequest {
    private Integer grade;
    private Integer resultId;
    private Integer userId;
}
