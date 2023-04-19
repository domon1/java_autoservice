package com.course.project.carservice.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "car_mark")
public class CarMark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mark_name")
    private String name;

    @OneToMany(mappedBy = "mark")
    private Set<CarModel> models;
}
