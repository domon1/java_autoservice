package com.course.project.carservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AutoServiceDto {
    private String name;
    private String description;
    private Integer price;
    private Long category;
}
