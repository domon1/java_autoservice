package com.course.project.carservice.restcontroller;

import com.course.project.carservice.domain.AutoService;
import com.course.project.carservice.service.ServicesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest-auto-service")
public class RestAutoServiceController {
    private final ServicesService servicesService;

    public RestAutoServiceController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping
    public List<AutoService> findAll(){
        return servicesService.findAll();
    }

    @GetMapping("{categoryId}")
    public List<AutoService> findAllByCategory(@PathVariable Long categoryId){
        return servicesService.findAllByCategory(categoryId);
    }

    // TODO мб поменять на хттп статус 404
    @GetMapping("service/{serviceId}")
    public AutoService findById(@PathVariable Long serviceId){
        return servicesService.findById(serviceId);
    }

    // Для менеджера
    // TODO mb use ResponseEntity<HttpStatus>?
    @PostMapping
    public AutoService createService(@RequestBody AutoService autoService){
        return servicesService.save(autoService);
    }

    // TODO добавить запрос на удаление сервиса
    @DeleteMapping("{serviceId}")
    public void deleteService(@PathVariable Long serviceId){
        servicesService.delete(serviceId);
    }

    // TODO добавить запрос на изменение сервиса
    @PutMapping("{serviceId}")
    public AutoService updateService(@PathVariable Long serviceId, @RequestBody AutoService autoService){
        return servicesService.update(serviceId, autoService);
    }
}
