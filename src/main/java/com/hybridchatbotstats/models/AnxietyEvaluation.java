package com.hybridchatbotstats.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "anxietyevaluation", schema = "hybridchatbotstats")
public class AnxietyEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer grade;
    @Column(name="isactive")
    private Integer isActive;
    @OneToOne()
    @JoinColumn(name="idresult", referencedColumnName = "id", nullable=false)
    private Result result;
    @Column(name = "userid")
    private Integer userId;
    @Column(name = "createdate")
    private LocalDateTime createDate;
}
