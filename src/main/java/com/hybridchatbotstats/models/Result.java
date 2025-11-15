package com.hybridchatbotstats.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "results", schema = "hybridchatbotstats")
public class Result {
    @Id
    private Integer id;
    private String result;
    @Column(name = "isactive")
    private Integer isActive;
}
