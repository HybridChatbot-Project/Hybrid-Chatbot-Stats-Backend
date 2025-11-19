package com.hybridchatbotstats.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AverageStaticsResponse {
    private LocalDateTime date;
    private BigDecimal grade;
}
