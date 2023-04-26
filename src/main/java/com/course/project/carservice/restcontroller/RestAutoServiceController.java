package com.course.project.carservice.restcontroller;

import com.course.project.carservice.domain.AutoService;
import com.course.project.carservice.service.ServicesService;
import com.course.project.carservice.util.AutoServiceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest-auto-service")
public class RestAutoServiceController {
    private final ServicesService servicesService;

    public RestAutoServiceController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping("{categoryId}")
    public List<AutoService> findAllByCategory(@PathVariable("categoryId") Long id){
        return servicesService.findAllByCategory(id);
    }

    // TODO мб поменять на хттп статус 404
    @GetMapping("service/{serviceId}")
    public AutoService findById(@PathVariable("serviceId") Long id){
        return servicesService.findById(id).orElseThrow(
                () -> new AutoServiceNotFoundException("Service not found!")
        );
    }

    // Для менеджера
    // TODO добавить запрос на добавление сервиса
    // TODO добавить запрос на удаление сервиса
    // TODO добавить запрос на изменение сервиса
}
