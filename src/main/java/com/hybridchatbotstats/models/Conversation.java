package com.hybridchatbotstats.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "conversation", schema = "hybridchatbotstats")
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "createdate")
    private LocalDateTime createDate;
    @Column(name = "isactive")
    private Integer isActive;
    @Column(name = "userid")
    private Integer userId;
    private Integer grade;
    @Column(name = "usercomment")
    private String userComment;
    @Column(name = "isclosed")
    private Boolean isClosed;
}
