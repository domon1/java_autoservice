package com.course.project.carservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "record")
public class UserRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String name;
    private String comment;
    private String state;
    private String mark;
    private String model;
    @Column(name = "phone_number")
    private String phoneNumber;

    // Связи
    @ManyToOne
    @JoinColumn(name = "time_id")
    private RecordingTime time;
    @ManyToOne
    @JoinColumn(name = "service_id")
    private AutoService autoService;
    @OneToMany(mappedBy = "record")
    private Set<Order> orders;
}
