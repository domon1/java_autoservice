package com.course.project.carservice.restcontroller;

import com.course.project.carservice.domain.CarModel;
import com.course.project.carservice.service.CarsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest-car")
public class RestCarController {
    private final CarsService carsService;

    public RestCarController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping("model/{markId}")
    public List<CarModel> getModelsByMarkId(@PathVariable("markId") Long id){
        return carsService.findAllModelByMarkId(id);
    }
}
