package com.anil.placementprep.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "questions")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String company;

    private String difficulty;

    private String topic;

    @Column(length = 5000)
    private String solution;
}