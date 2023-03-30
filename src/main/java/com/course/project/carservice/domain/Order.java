package com.course.project.carservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ordr")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "total_price")
    private Integer totalPrice;
    private String message;

    // Связи
    @ManyToOne
    @JoinColumn(name = "record_id")
    private UserRecord record;
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private User user;
    @ManyToMany
    @JoinTable(
            name = "order_workservice",
            joinColumns = { @JoinColumn(name = "ordr_id") },
            inverseJoinColumns = { @JoinColumn(name = "workservice_id") }
    )
    private Set<WorkService> workservices;
    @ManyToMany
    @JoinTable(
            name = "order_spare",
            joinColumns = { @JoinColumn(name = "ordr_id") },
            inverseJoinColumns = { @JoinColumn(name = "spare_id") }
    )
    private Set<Spare> spares;
}
