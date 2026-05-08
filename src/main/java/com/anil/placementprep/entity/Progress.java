package com.anil.placementprep.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "progress")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long questionId;

    private String status;
}