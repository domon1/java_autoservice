package com.course.project.carservice.restcontroller;

import com.course.project.carservice.domain.AutoService;
import com.course.project.carservice.service.ServicesService;
import com.course.project.carservice.util.AutoServiceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<List<AutoService>> findAll(){
        List<AutoService> all = servicesService.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<List<AutoService>> findAllByCategory(@PathVariable Long categoryId){
        List<AutoService> allByCategory = servicesService.findAllByCategory(categoryId);
        return ResponseEntity.ok(allByCategory);
    }

    @GetMapping("service/{serviceId}")
    public ResponseEntity<AutoService> findById(@PathVariable Long serviceId){
        AutoService byId = servicesService.findById(serviceId);
        return ResponseEntity.ok(byId);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping
    public ResponseEntity<HttpStatus> createService(@RequestBody AutoService autoService){
        servicesService.save(autoService);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @DeleteMapping("{serviceId}")
    public ResponseEntity<HttpStatus> deleteService(@PathVariable Long serviceId){
        servicesService.delete(serviceId);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PutMapping("{serviceId}")
    public ResponseEntity<AutoService> updateService(@PathVariable Long serviceId, @RequestBody AutoService autoService){
        AutoService service = servicesService.update(serviceId, autoService);
        return ResponseEntity.ok(service);
    }

    @ExceptionHandler
    private ResponseEntity<AutoServiceNotFoundException> notFound(AutoServiceNotFoundException e){
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
