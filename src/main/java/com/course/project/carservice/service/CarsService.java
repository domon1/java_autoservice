package com.course.project.carservice.service;

import com.course.project.carservice.domain.CarMark;
import com.course.project.carservice.domain.CarModel;
import com.course.project.carservice.repository.CarMarkRepository;
import com.course.project.carservice.repository.CarModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {
    private final CarMarkRepository carMarkRepository;
    private final CarModelRepository carModelRepository;

    public CarsService(CarMarkRepository carMarkRepository, CarModelRepository carModelRepository) {
        this.carMarkRepository = carMarkRepository;
        this.carModelRepository = carModelRepository;
    }

    public List<CarMark> findAllMark(){
        return carMarkRepository.findAll();
    }

    public List<CarModel> findAllModelByMarkId(Long id){
        return carModelRepository.findCarModelByMarkId(id);
    }
}
