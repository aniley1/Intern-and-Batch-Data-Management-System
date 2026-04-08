package com.idms.idms_backend.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Intern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String internId;

    private String name;

    private String email;

    private String mobile;

    private String idCardType;

    private LocalDate dateOfJoining;

    @ManyToOne
    @JoinColumn(name = "batch_id")
    @JsonManagedReference
    private Batch batch;
}