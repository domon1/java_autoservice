package com.course.project.carservice.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "car_model")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "mark_id")
    private CarMark mark;
}
